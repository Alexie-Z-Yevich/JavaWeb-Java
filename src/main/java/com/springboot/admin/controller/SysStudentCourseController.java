package com.springboot.admin.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.admin.common.lang.Result;
import com.springboot.admin.entity.AVGEntity;
import com.springboot.admin.entity.SysStudent;
import com.springboot.admin.entity.SysStudentCourse;
import com.springboot.admin.mapper.SysClassMapper;
import com.springboot.admin.mapper.SysStudentCourseMapper;
import com.springboot.admin.service.SysStudentCourseService;
import com.springboot.admin.service.SysStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/stu/grade")
public class SysStudentCourseController extends BaseController {

    @Autowired
    SysStudentService sysStudentService;

    @Autowired
    SysStudentCourseService sysStudentCourseService;
    @Autowired
    SysStudentCourseMapper sysStudentCourseMapper;

    @Autowired
    SysClassMapper sysClassMapper;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('stu:message:list')")
    public Result list(Integer s_id) {

        Page<SysStudentCourse> pageData = sysStudentCourseService.page(getPage());
        pageData.setRecords(null);
        List<SysStudentCourse> result;
        if(s_id != null){
            result = sysStudentCourseMapper.getByName(s_id);
        }else {
            result = sysStudentCourseMapper.getList();
        }
        pageData.setRecords(result);
        return Result.succ(pageData);
    }

    @GetMapping("/class")
    @PreAuthorize("hasAuthority('stu:message:list')")
    public Result list(String class_name) {
        Page<SysStudentCourse> pageData = sysStudentCourseService.page(getPage());
        pageData.setRecords(null);
        List<SysStudentCourse> result;
        if(class_name != null){
            Integer class_id = sysClassMapper.getByClassName(class_name);
            result = sysStudentCourseMapper.getByClassId(class_id);
        }else {
            result = sysStudentCourseMapper.getList();
        }
        pageData.setRecords(result);
        return Result.succ(pageData);
    }

    @GetMapping("/avg")
    public Result Avg(Integer s_id){
        List<AVGEntity> result;
        result = sysStudentCourseMapper.getAvg(s_id);
        return Result.succ(result);
    }

}
