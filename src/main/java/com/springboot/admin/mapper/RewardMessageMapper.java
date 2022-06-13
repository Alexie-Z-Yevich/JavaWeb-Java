package com.springboot.admin.mapper;

import com.springboot.admin.entity.ChangeMessage;
import com.springboot.admin.entity.RewardMessage;
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
public interface RewardMessageMapper extends BaseMapper<RewardMessage> {

    List<RewardMessage> getList();

    List<RewardMessage> getByName(Integer s_id);

    RewardMessage getById(Long id);

    List<RewardMessage> getByClassId(Integer s_id);
}
