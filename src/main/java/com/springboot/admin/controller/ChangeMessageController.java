package com.springboot.admin.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.admin.common.lang.Result;
import com.springboot.admin.entity.ChangeMessage;
import com.springboot.admin.entity.SysStudent;
import com.springboot.admin.entity.SysStudentCourse;
import com.springboot.admin.mapper.ChangeMessageMapper;
import com.springboot.admin.mapper.SysClassDeptMapper;
import com.springboot.admin.mapper.SysClassMapper;
import com.springboot.admin.mapper.SysStudentMapper;
import com.springboot.admin.service.ChangeMessageService;
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
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/sta/change")
public class ChangeMessageController{

    @Autowired
    ChangeMessageMapper changeMessageMapper;

    @Autowired
    ChangeMessageService changeMessageService;

    @Autowired
    SysClassMapper sysClassMapper;

    @Autowired
    SysClassDeptMapper sysClassDeptMapper;

    @Autowired
    SysStudentMapper sysStudentMapper;


    @GetMapping("/list")
    public Result list(Integer s_id) {

        List<ChangeMessage> result;
        if(s_id != null){
            result = changeMessageMapper.getByName(s_id);
        }else {
            result = changeMessageMapper.getList();
        }
        return Result.succ(result);
    }

    @GetMapping("/class")
    public Result list(String class_name) {
        List<ChangeMessage> result;
        if(class_name != null){
            Integer classId = sysClassMapper.getByClassName(class_name);
            Integer deptId = sysClassDeptMapper.getDept(classId);
            String str = null;
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
            Integer a = Integer.parseInt(str);
            result = changeMessageMapper.getByClassId(a);
        }else {
            result = changeMessageMapper.getList();
        }
        System.out.println(result);
        return Result.succ(result);
    }

    @Transactional
    @PostMapping("/delete")
    public Result delete(@RequestBody Long[] ids) {
        changeMessageService.removeByIds(Arrays.asList(ids));
        return Result.succ("");
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id) {
        ChangeMessage result = changeMessageMapper.getById(id);
        return Result.succ(result);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody ChangeMessage changeMessage) {
        String s_name = sysStudentMapper.getBySId(changeMessage.getSId());
        if(s_name.equals(changeMessage.getSName())){
            changeMessage.setRecTime(LocalDateTime.now());
            changeMessageService.updateById(changeMessage);
            return Result.succ(changeMessage);
        }else {
            return Result.fail("学号与姓名不匹配");
        }
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody ChangeMessage changeMessage) {
        String s_name = sysStudentMapper.getBySId(changeMessage.getSId());
        if(s_name.equals(changeMessage.getSName())) {
            changeMessage.setId(null);
            changeMessage.setRecTime(LocalDateTime.now());
            changeMessageService.save(changeMessage);
            return Result.succ(changeMessage);
        }else {
            return Result.fail("学号与姓名不匹配");
        }
    }

}
