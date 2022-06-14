package com.springboot.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.admin.common.lang.Result;
import com.springboot.admin.entity.ApplyMessage;
import com.springboot.admin.entity.SysRole;
import com.springboot.admin.entity.SysUser;
import com.springboot.admin.entity.SysUserRole;
import com.springboot.admin.mapper.ApplyMessageMapper;
import com.springboot.admin.service.ApplyMessageService;
import com.springboot.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Alexie
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/apply/message")
public class ApplyMessageController{

    @Autowired
    ApplyMessageService applyMessageService;

    @Autowired
    ApplyMessageMapper applyMessageMapper;

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/list")
    public Result list(Principal principal){

        String s_id = principal.getName();
        Integer a;
        if(s_id.matches("[0-9]+")){
            a = Integer.parseInt(s_id);
        }else{
            return Result.fail("您的账号不是学生账号，请联系管理员");
        }
//        List<ApplyMessage> result = applyMessageService.list();
        List<ApplyMessage> result =applyMessageMapper.getBySId(a);
        return Result.succ(result);
    }

    @PostMapping("/push")
    public Result push(@RequestBody ApplyMessage applyMessage, Principal principal) {
        String s_id = principal.getName();
        Integer a = Integer.parseInt(s_id);
        applyMessage.setSId(a);
        applyMessage.setStatuId(0);
        applyMessageService.save(applyMessage);
        return Result.succ("");
    }

    @GetMapping("/all")
    public Result all(String statu){
        List<ApplyMessage> result;
        if (statu == null || statu.equals("")) {
            result =applyMessageMapper.getAll();
        }else {
            Integer statuId = applyMessageMapper.getByStatu(statu);
            result =applyMessageMapper.getByStatuId(statuId);
        }
        return Result.succ(result);
    }

    @PostMapping("/submit")
    public Result submit(@Validated @RequestBody ApplyMessage applyMessage){
        Integer id = applyMessage.getId();
        Integer statusId = applyMessage.getStatuId();
        applyMessageMapper.update(id, statusId);
        return Result.succ("");
    }

    @Transactional
    @PostMapping("/delete")
    public Result delete(@RequestBody Long[] ids) {
        applyMessageService.removeByIds(Arrays.asList(ids));
        return Result.succ("");
    }


}
