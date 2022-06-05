package com.springboot.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class ExcelEntity {

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
    private String birth;

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
    @TableField(exist = false)
    private String className;

    /***
     * 状态
     */
    private String statu;

    /***
     * 数学
     */
    @TableField(exist = false)
    private Integer math;

    /***
     * Java
     */
    @TableField(exist = false)
    private Integer java;

    /***
     * 英语
     */
    @TableField(exist = false)
    private Integer English;

    /***
     * 体育
     */
    @TableField(exist = false)
    private Integer ET;

    /***
     * 总分
     */
    @TableField(exist = false)
    private Integer COUNT;

}
