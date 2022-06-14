package com.springboot.admin.mapper;

import com.springboot.admin.entity.ApplyMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alexie
 * @since 2022-06-13
 */
@Repository
public interface ApplyMessageMapper extends BaseMapper<ApplyMessage> {

    List<ApplyMessage> getBySId(Integer s_id);

    List<ApplyMessage> getAll();

    void update(Integer id, Integer statusId);

    Integer getByStatu(String statu);

    List<ApplyMessage> getByStatuId(Integer statuId);
}
