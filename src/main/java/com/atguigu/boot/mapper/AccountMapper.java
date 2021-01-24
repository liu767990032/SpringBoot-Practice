package com.atguigu.boot.mapper;

import com.atguigu.boot.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: liuXiang
 * @Date: 2021/1/18 20:36
 */
@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
