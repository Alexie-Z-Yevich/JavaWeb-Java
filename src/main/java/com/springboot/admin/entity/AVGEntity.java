package com.springboot.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class AVGEntity {

    /***
     * 班级平均分
     */
    @TableField(exist = false)
    private double avgAll;

    /***
     * 班级数学平均分
     */
    @TableField(exist = false)
    private double avgMath;

    /***
     * 班级Java平均分
     */
    @TableField(exist = false)
    private double avgJava;

    /***
     * 班级英语平均分
     */
    @TableField(exist = false)
    private double avgEnglish;

    /***
     * 班级体育平均分
     */
    @TableField(exist = false)
    private double avgET;


}
