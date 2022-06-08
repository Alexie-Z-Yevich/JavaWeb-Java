package com.springboot.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SysStudent{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学号
     */
    private Integer sId;

    /**
     * 姓名
     */
    private String sName;

    /**
     * 出生年月日
     */
    private LocalDate birth;

    /***
     * 性别
     */
    private String sex;

    /***
     * 籍贯
     */
    private String nativePlace;


    /**
     * 班级号
     */
    private Integer classId;

    @TableField(exist = false)
    private String className;

    @TableField(exist = false)
    private int label;

    private String statu;

}
