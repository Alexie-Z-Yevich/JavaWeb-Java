package com.springboot.admin.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.admin.common.lang.Const;
import com.springboot.admin.common.lang.Result;
import com.springboot.admin.entity.*;
import com.springboot.admin.mapper.SysClassDeptMapper;
import com.springboot.admin.mapper.SysClassMapper;
import com.springboot.admin.mapper.SysStudentMapper;
import com.springboot.admin.service.SysStudentCourseService;
import com.springboot.admin.service.SysStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Alexie
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/stu/student")
public class SysStudentController extends BaseController {
    @Autowired
    SysStudentService sysStudentService;

    @Autowired
    SysStudentCourseService sysStudentCourseService;

    @Autowired
    SysStudentMapper sysStudentMapper;

    @Autowired
    SysClassMapper sysClassMapper;

    @Autowired
    SysClassDeptMapper sysClassDeptMapper;



    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('stu:message:list')")
    public Result info(@PathVariable("id") Long id) {

        SysStudent sysStudent = sysStudentService.getById(id);
        Assert.notNull(sysStudent, "找不到该学生");

        SysStudent result = sysStudentMapper.getById(id);
        if(result.getStatu() != 0){
            result.setStatu(1);
        }
        return Result.succ(result);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('stu:message:list')")
    public Result list(String s_name) {

        Page<SysStudent> pageData = sysStudentService.page(getPage(), new QueryWrapper<SysStudent>()
                .like(StrUtil.isNotBlank(s_name), "s_name", s_name));
        pageData.setRecords(null);
        List<SysStudent> result;
        if(s_name != null && s_name != ""){
            result = sysStudentMapper.getByName(s_name);
        }else {
            result = sysStudentMapper.getAll();
        }
        for (SysStudent u:result) {
            if(u.getStatu() != 0){
                u.setStatu(1);
            }
        }
        pageData.setRecords(result);
        return Result.succ(pageData);
    }

    @GetMapping("/class")
    public Result getAllClass() {
        List<SysClass> result = sysClassMapper.getAllClass();
        return Result.succ(result);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('stu:student:save')")
    public Result save(@Validated @RequestBody SysStudent sysStudent) {
        // 设置班级
        String class_name = sysStudent.getClassName();
        Integer classId = sysClassMapper.getByClassName(class_name);
        sysStudent.setClassId(classId);

        // 通过班级设置学院
        Integer deptId = sysClassDeptMapper.getDept(classId);
        sysStudent.setDeptId(deptId);


        // 查找班级人数
        Integer classNum = sysStudentMapper.getClassNum(classId);

        // 设置学号
        String str;
        if(deptId < 10){
            str = "20050" + deptId;
        }else{
            str = "2005" + deptId;
        }
        if(classId< 10){
            str = str + "0"  + classId;
        }else{
            str = str + classId;
        }
        if(classNum < 10){
            str = str + "0" + (classNum + 1);
        }else{
            str = str + (classNum + 1);
        }
        int a = Integer.parseInt(str);
        sysStudent.setSId(a);
        SysStudentCourse sysStudentCourse = new SysStudentCourse();
        sysStudentCourse.setSId(a);
        sysStudentCourse.setCId(1);
        sysStudentCourse.setGrade(0);
        sysStudentCourseService.save(sysStudentCourse);
        sysStudentCourse.setCId(2);
        sysStudentCourseService.save(sysStudentCourse);
        sysStudentCourse.setCId(3);
        sysStudentCourseService.save(sysStudentCourse);
        sysStudentCourse.setCId(4);
        sysStudentCourseService.save(sysStudentCourse);

        sysStudentService.save(sysStudent);

        // 对班长职位进行判断
        if(sysStudent.getStatu() == 0){
            sysClassMapper.updateMonitor(a, classId);
        }

        return Result.succ(sysStudent);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('stu:student:update')")
    public Result update(@Validated @RequestBody SysStudent sysStudent) {
        // 设置班级
        String class_name = sysStudent.getClassName();
        Integer classId = sysClassMapper.getByClassName(class_name);
        sysStudent.setClassId(classId);

        // 通过班级设置学院
        Integer deptId = sysClassDeptMapper.getDept(classId);
        sysStudent.setDeptId(deptId);

        // 对班长职位进行判断
        if(sysStudent.getStatu() == 0){
            sysClassMapper.updateMonitor(sysStudent.getSId(), classId);
        }

        sysStudentService.updateById(sysStudent);
        return Result.succ(sysStudent);
    }

    @Transactional
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('stu:student:delete')")
    public Result delete(@RequestBody Long[] ids) {
        Long[] result = sysStudentMapper.getSIdByIds(ids);
        sysStudentService.removeByIds(Arrays.asList(ids));
        sysStudentCourseService.remove(new QueryWrapper<SysStudentCourse>().in("s_id", result));
        return Result.succ("");
    }

}
