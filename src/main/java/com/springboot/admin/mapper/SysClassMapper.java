package com.springboot.admin.mapper;

import com.springboot.admin.entity.SysClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alexie
 * @since 2022-05-29
 */
@Repository
public interface SysClassMapper extends BaseMapper<SysClass> {

    List<SysClass> getAllClass();

    Integer getByClassName(String class_name);

    List<SysClass> getDeptClass();

    void updateMonitor(int s_id, Integer classId);
}
