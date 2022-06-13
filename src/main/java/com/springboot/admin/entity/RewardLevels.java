package com.springboot.admin.entity;

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
public class RewardLevels{

    private static final long serialVersionUID = 1L;

    /**
     * 奖励号
     */
    private Integer rewardId;

    /**
     * 奖励
     */
    private String reward;


}
