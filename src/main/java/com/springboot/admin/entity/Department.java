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
public class Department{

    private static final long serialVersionUID = 1L;

    /**
     * 院系id
     */
    private Integer deptId;

    /**
     * 院系名称
     */
    private String deptName;


}
