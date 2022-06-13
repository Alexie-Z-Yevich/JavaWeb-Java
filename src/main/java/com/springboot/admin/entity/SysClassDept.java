package com.springboot.admin.entity;
;
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
public class SysClassDept{

    private static final long serialVersionUID = 1L;

    /**
     * 班级编号
     */
    private Integer classId;

    /**
     * 院系编号
     */
    private Integer deptId;


}
