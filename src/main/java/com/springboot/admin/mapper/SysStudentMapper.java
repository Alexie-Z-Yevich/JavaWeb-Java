package com.springboot.admin.mapper;

import com.springboot.admin.entity.ExcelEntity;
import com.springboot.admin.entity.SysStudent;
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
public interface SysStudentMapper extends BaseMapper<SysStudent> {

    List<SysStudent> getAll();

    SysStudent getById(Long id);

    List<SysStudent> getByName(String s_name);

    Integer getClassNum(Integer class_id);

    Long[] getSIdByIds(Long[] ids);

    List<ExcelEntity> getExcelBySId(Integer s_id);

    List<ExcelEntity> getAllExcel();
}
