package com.springboot.admin.mapper;

import com.springboot.admin.entity.PunishMessage;
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
public interface PunishMessageMapper extends BaseMapper<PunishMessage> {

    List<PunishMessage> getByName(Integer s_id);

    List<PunishMessage> getList();

    PunishMessage getById(Long id);

    List<PunishMessage> getByClassId(Integer s_id);
}
