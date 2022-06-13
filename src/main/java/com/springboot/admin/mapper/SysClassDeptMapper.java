package com.springboot.admin.mapper;

import com.springboot.admin.entity.SysClassDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alexie
 * @since 2022-06-10
 */
@Repository
public interface SysClassDeptMapper extends BaseMapper<SysClassDept> {

    Integer getDept(Integer classId);
}
