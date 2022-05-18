package com.springboot.admin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alexie
 * @since 2022-05-18
 */
@Data
public class SysUserRole{

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long roleId;


}
