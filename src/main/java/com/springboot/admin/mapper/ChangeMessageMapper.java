package com.springboot.admin.mapper;

import com.springboot.admin.entity.ChangeMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alexie
 * @since 2022-06-10
 */
@Repository
public interface ChangeMessageMapper extends BaseMapper<ChangeMessage> {

    List<ChangeMessage> getList();

    List<ChangeMessage> getByName(Integer s_id);

    List<ChangeMessage> getByClassId(Integer s_id);

    ChangeMessage getById(Long id);
}
