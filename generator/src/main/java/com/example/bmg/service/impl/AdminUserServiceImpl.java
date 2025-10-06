package com.example.bmg.service.impl;

import com.example.bmg.entity.AdminUser;
import com.example.bmg.mapper.AdminUserMapper;
import com.example.bmg.service.IAdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author CW
 * @since 2025-10-05
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

}
