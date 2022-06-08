package com.springboot.admin.mapper;

import com.springboot.admin.entity.AVGEntity;
import com.springboot.admin.entity.SysStudent;
import com.springboot.admin.entity.SysStudentCourse;
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
public interface SysStudentCourseMapper extends BaseMapper<SysStudentCourse> {

    List<SysStudentCourse> getList();

    List<SysStudentCourse> getByName(Integer s_id);

    List<SysStudentCourse> getByClassId(Integer class_id);

    List<AVGEntity> getAvg(Integer s_id);

    void setMath(Integer s_id, int grade);

    void setJava(Integer s_id, int grade);

    void setEnglish(Integer s_id, int grade);

    void setET(Integer s_id, int grade);
}
