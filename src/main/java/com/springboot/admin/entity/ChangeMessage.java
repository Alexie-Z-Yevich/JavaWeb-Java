package com.springboot.admin.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class ChangeMessage{

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
     * 状态号
     */
    private Integer changeId;

    @TableField(exist = false)
    private String statu;

    /**
     * 记录时间
     */
    private LocalDateTime recTime;

    /**
     * 描述
     */
    private String description;


}
