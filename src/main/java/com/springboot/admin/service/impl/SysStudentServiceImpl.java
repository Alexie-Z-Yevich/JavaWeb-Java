package com.springboot.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.admin.entity.SysRole;
import com.springboot.admin.entity.SysStudent;
import com.springboot.admin.mapper.SysStudentMapper;
import com.springboot.admin.service.SysStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alexie
 * @since 2022-05-29
 */
@Service
public class SysStudentServiceImpl extends ServiceImpl<SysStudentMapper, SysStudent> implements SysStudentService {
}
