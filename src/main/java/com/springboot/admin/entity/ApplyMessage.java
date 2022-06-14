package com.springboot.admin.entity;

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
 * @since 2022-06-13
 */
@Data
public class ApplyMessage{

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学号
     */
    private Integer sId;

    /**
     * 状态id
     */
    private Integer statuId;

    /**
     * 请假类型
     */
    private String emp;

    /**
     * 理由
     */
    private String description;

    @TableField(exist = false)
    private String sName;


}
