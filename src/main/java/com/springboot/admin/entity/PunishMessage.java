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
public class PunishMessage{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer sId;

    @TableField(exist = false)
    private String sName;

    private Integer punishId;

    @TableField(exist = false)
    private String punish;

    private LocalDateTime recTime;

    /**
     * 描述
     */
    private String description;


}
