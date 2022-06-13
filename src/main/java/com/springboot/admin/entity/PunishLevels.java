package com.springboot.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alexie
 * @since 2022-06-10
 */
@Data
public class PunishLevels{

    private static final long serialVersionUID = 1L;

    /**
     * 处罚号
     */
    private Integer punishId;

    /**
     * 处罚
     */
    private String punish;


}
