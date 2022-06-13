package com.springboot.admin.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alexie
 * @since 2022-06-10
 */
@Data
public class RewardMessage{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学号
     */
    private Integer sId;

    @TableField(exist = false)
    private String sName;

    /**
     * 奖励号
     */
    private Integer rewardId;

    @TableField(exist = false)
    private String reward;

    private LocalDateTime recTime;

    /**
     * 描述
     */
    private String description;


}
