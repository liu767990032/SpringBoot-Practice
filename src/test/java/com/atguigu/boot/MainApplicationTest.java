package com.atguigu.boot;

import com.atguigu.boot.entity.User;
import com.atguigu.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author: liuXiang
 * @Date: 2021/1/18 17:24
 */
@SpringBootTest
@Slf4j
public class MainApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private RedisTemplate redisTemplate;

    @Test
    public void test01(){
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from payment ");
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql.toString());
        log.info("maps={}",maps);
    }

    @Test
    public void test02(){
        User user = userMapper.selectById(1L);
        log.info("user={}",user);
    }

    @Test
    public void test03(){
        ValueOperations<String, String> o = stringRedisTemplate.opsForValue();
        o.set("hello","hello");
        String hello = o.get("hello");
        log.info("hello={}",hello);
    }
}
