package com.springboot.admin.controller;


import com.springboot.admin.common.lang.Result;
import com.springboot.admin.entity.PunishMessage;
import com.springboot.admin.entity.RewardMessage;
import com.springboot.admin.mapper.PunishMessageMapper;
import com.springboot.admin.mapper.SysClassDeptMapper;
import com.springboot.admin.mapper.SysClassMapper;
import com.springboot.admin.mapper.SysStudentMapper;
import com.springboot.admin.service.PunishMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/sta/punish")
public class PunishMessageController{

    @Autowired
    PunishMessageMapper punishMessageMapper;

    @Autowired
    PunishMessageService punishMessageService;

    @Autowired
    SysClassMapper sysClassMapper;

    @Autowired
    SysClassDeptMapper sysClassDeptMapper;

    @Autowired
    SysStudentMapper sysStudentMapper;

    @GetMapping("/list")
    public Result list(Integer s_id) {

        List<PunishMessage> result;
        if(s_id != null){
            result = punishMessageMapper.getByName(s_id);
        }else {
            result = punishMessageMapper.getList();
        }
        return Result.succ(result);
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id) {
        PunishMessage result = punishMessageMapper.getById(id);
        return Result.succ(result);
    }

    @Transactional
    @PostMapping("/delete")
    public Result delete(@RequestBody Long[] ids) {
        punishMessageService.removeByIds(Arrays.asList(ids));
        return Result.succ("");
    }

    @GetMapping("/class")
    public Result list(String class_name) {
        List<PunishMessage> result;
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
            result = punishMessageMapper.getByClassId(a);
        }else {
            result = punishMessageMapper.getList();
        }
        return Result.succ(result);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody PunishMessage punishMessage) {
        String s_name = sysStudentMapper.getBySId(punishMessage.getSId());
        if(s_name.equals(punishMessage.getSName())){
            punishMessage.setRecTime(LocalDateTime.now());
            punishMessageService.updateById(punishMessage);
            return Result.succ(punishMessage);
        }else {
            return Result.fail("学号与姓名不匹配");
        }
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody PunishMessage punishMessage) {
        String s_name = sysStudentMapper.getBySId(punishMessage.getSId());
        if(s_name.equals(punishMessage.getSName())) {
            punishMessage.setId(null);
            punishMessage.setRecTime(LocalDateTime.now());
            punishMessageService.save(punishMessage);
            return Result.succ(punishMessage);
        }else {
            return Result.fail("学号与姓名不匹配");
        }
    }

}
