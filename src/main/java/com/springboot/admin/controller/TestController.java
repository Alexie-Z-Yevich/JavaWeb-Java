package com.springboot.admin.controller;

import com.springboot.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    SysUserService userService;
    @GetMapping("/test")
    public Object test() {
        return userService.list();
    }
}