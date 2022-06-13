package com.springboot.admin.service.impl;

import com.springboot.admin.entity.Department;
import com.springboot.admin.mapper.DepartmentMapper;
import com.springboot.admin.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alexie
 * @since 2022-06-10
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
