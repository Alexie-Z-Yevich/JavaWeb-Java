package com.springboot.admin.controller;


import com.springboot.admin.common.lang.Result;
import com.springboot.admin.entity.AVGEntity;
import com.springboot.admin.entity.SysStudent;
import com.springboot.admin.entity.SysStudentCourse;
import com.springboot.admin.mapper.SysStudentCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Alexie
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/stu/push")
public class SysCourseController extends BaseController {

    @Autowired
    SysStudentCourseMapper sysStudentCourseMapper;

    @GetMapping("/info")
    public Result info(Integer s_id) {
        List<SysStudentCourse> result;
        result = sysStudentCourseMapper.getByName(s_id);
        return Result.succ(result);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody SysStudentCourse sysStudentCourse) {
        Integer sid = sysStudentCourse.getSId();
        sysStudentCourseMapper.setMath(sid, sysStudentCourse.getMath());
        sysStudentCourseMapper.setJava(sid, sysStudentCourse.getJava());
        sysStudentCourseMapper.setEnglish(sid, sysStudentCourse.getEnglish());
        sysStudentCourseMapper.setET(sid, sysStudentCourse.getET());
        return Result.succ("");
    }

}
