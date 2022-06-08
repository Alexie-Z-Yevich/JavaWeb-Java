package com.springboot.admin.entity;

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
public class SysCourse{

    private static final long serialVersionUID = 1L;

    /**
     * 课程号
     */
    private Integer cId;

    /**
     * 课程名
     */
    private String cName;


}
