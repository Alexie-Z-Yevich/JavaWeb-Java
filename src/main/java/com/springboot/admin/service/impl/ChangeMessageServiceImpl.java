package com.springboot.admin.service.impl;

import com.springboot.admin.entity.ChangeMessage;
import com.springboot.admin.mapper.ChangeMessageMapper;
import com.springboot.admin.service.ChangeMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alexie
 * @since 2022-06-10
 */
@Service
public class ChangeMessageServiceImpl extends ServiceImpl<ChangeMessageMapper, ChangeMessage> implements ChangeMessageService {

}
