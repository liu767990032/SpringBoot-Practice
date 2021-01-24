package com.atguigu.boot.mapper;

import com.atguigu.boot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: liuXiang
 * @Date: 2021/1/19 13:46
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
