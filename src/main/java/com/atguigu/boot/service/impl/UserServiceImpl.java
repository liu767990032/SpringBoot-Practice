package com.atguigu.boot.service.impl;

import com.atguigu.boot.entity.User;
import com.atguigu.boot.mapper.UserMapper;
import com.atguigu.boot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: liuXiang
 * @Date: 2021/1/19 13:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
