package com.example.bmg.service.impl;

import com.example.bmg.entity.User;
import com.example.bmg.mapper.UserMapper;
import com.example.bmg.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
