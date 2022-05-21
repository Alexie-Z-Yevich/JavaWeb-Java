package com.springboot.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.admin.entity.SysMenu;
import com.springboot.admin.entity.SysRole;
import com.springboot.admin.entity.SysUser;
import com.springboot.admin.mapper.SysUserMapper;
import com.springboot.admin.service.SysMenuService;
import com.springboot.admin.service.SysRoleService;
import com.springboot.admin.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alexie
 * @since 2022-05-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysMenuService sysMenuService;

    @Override
    public SysUser getByUsername(String username) {
        return getOne(new QueryWrapper<SysUser>().eq("username", username));
    }

    @Override
    public String getUserAuthorityInfo(Long userId) {

        String authority = "";

        // 获取角色
        List<SysRole> roles = sysRoleService.list(new QueryWrapper<SysRole>()
                .inSql("id", "select role_id from sys_user_role where user_id = " + userId));

        if(roles.size() > 0) {
            String roleCodes = roles.stream().map(r -> "ROLE_" + r.getCode()).collect(Collectors.joining(","));
//            authority += roleCodes.concat(",");
            authority += roleCodes;
        }

        // 获取菜单操作编码
        List<Long> menuIds = sysUserMapper.getNavMenuIds(userId);
        if (menuIds.size() > 0) {
            List<SysMenu> menus = sysMenuService.listByIds(menuIds);
            String menuPerms = menus.stream().map(m -> m.getPerms()).collect(Collectors.joining(","));
//            authority.concat(menuPerms);
            authority += "," + menuPerms;
        }

        return authority;

    }
}
