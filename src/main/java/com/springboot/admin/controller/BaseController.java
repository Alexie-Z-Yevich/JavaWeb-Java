package com.springboot.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.admin.service.*;
import com.springboot.admin.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    SysUserRoleService sysUserRoleService;

    @Autowired
    SysRoleMenuService sysRoleMenuService;

    // 获取页码
    public Page getPage() {
        int current = ServletRequestUtils.getIntParameter(req, "current", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 1);

        return new Page(current, size);
    }
}