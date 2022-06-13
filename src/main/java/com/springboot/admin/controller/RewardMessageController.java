package com.springboot.admin.controller;


import com.springboot.admin.common.lang.Result;
import com.springboot.admin.entity.ChangeMessage;
import com.springboot.admin.entity.RewardMessage;
import com.springboot.admin.mapper.RewardMessageMapper;
import com.springboot.admin.mapper.SysClassDeptMapper;
import com.springboot.admin.mapper.SysClassMapper;
import com.springboot.admin.mapper.SysStudentMapper;
import com.springboot.admin.service.RewardMessageService;
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
@RequestMapping("sta/reward")
public class RewardMessageController{

    @Autowired
    RewardMessageMapper rewardMessageMapper;

    @Autowired
    RewardMessageService rewardMessageService;

    @Autowired
    SysClassMapper sysClassMapper;

    @Autowired
    SysClassDeptMapper sysClassDeptMapper;

    @Autowired
    SysStudentMapper sysStudentMapper;

    @GetMapping("/list")
    public Result list(Integer s_id) {

        List<RewardMessage> result;
        if(s_id != null){
            result = rewardMessageMapper.getByName(s_id);
        }else {
            result = rewardMessageMapper.getList();
        }
        return Result.succ(result);
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id) {
        RewardMessage result = rewardMessageMapper.getById(id);
        return Result.succ(result);
    }

    @Transactional
    @PostMapping("/delete")
    public Result delete(@RequestBody Long[] ids) {
        rewardMessageService.removeByIds(Arrays.asList(ids));
        return Result.succ("");
    }

    @GetMapping("/class")
    public Result list(String class_name) {
        List<RewardMessage> result;
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
            result = rewardMessageMapper.getByClassId(a);
        }else {
            result = rewardMessageMapper.getList();
        }
        System.out.println(result);
        return Result.succ(result);
    }

    @PostMapping("/update")
    public Result update(@Validated @RequestBody RewardMessage rewardMessage) {
        String s_name = sysStudentMapper.getBySId(rewardMessage.getSId());
        if(s_name.equals(rewardMessage.getSName())){
            rewardMessage.setRecTime(LocalDateTime.now());
            rewardMessageService.updateById(rewardMessage);
            return Result.succ(rewardMessage);
        }else {
            return Result.fail("学号与姓名不匹配");
        }
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody RewardMessage rewardMessage) {
        String s_name = sysStudentMapper.getBySId(rewardMessage.getSId());
        if(s_name.equals(rewardMessage.getSName())) {
            rewardMessage.setId(null);
            rewardMessage.setRecTime(LocalDateTime.now());
            rewardMessageService.save(rewardMessage);
            return Result.succ(rewardMessage);
        }else {
            return Result.fail("学号与姓名不匹配");
        }
    }

}
