package com.springboot.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alexie
 * @since 2022-05-29
 */
@Data
public class SysStudentCourse{

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    private Integer sId;

    private Integer cId;

    private Integer grade;

    @TableField(exist = false)
    private String sName;

    @TableField(exist = false)
    private int math;

    @TableField(exist = false)
    private int java;

    @TableField(exist = false)
    private int English;

    @TableField(exist = false)
    private int ET;

    @TableField(exist = false)
    private int classId;

}
