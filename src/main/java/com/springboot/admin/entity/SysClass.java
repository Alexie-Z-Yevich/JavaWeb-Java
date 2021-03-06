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
public class SysClass{

    private static final long serialVersionUID = 1L;

    /**
     * 班级号
     */
    private Integer classId;

    /**
     * 班级名
     */
    private String className;

    /***
     * 班长学号
     */
    private Integer classMonitor;

    @TableField(exist = false)
    private Integer deptId;

    @TableField(exist = false)
    private String deptName;


}
