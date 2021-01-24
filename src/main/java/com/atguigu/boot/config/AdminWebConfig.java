package com.atguigu.boot.config;

import com.atguigu.boot.interceptor.LoginInterceptor;
import com.atguigu.boot.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: liuXiang
 * @Date: 2021/1/17 17:33
 * 1.编写一个拦截器实现HandlerInterceptor
 * 2.拦截器注册到容器中（实现WebMvcConfigurer接口）
 * 3.指定拦截规则（拦截哪些，排除哪些）
 */
@SpringBootConfiguration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        /*匹配一级，/**匹配多级
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/","/login")
                .excludePathPatterns("/css/**","/fonts/**","/images/**","/js/**");

        registry.addInterceptor(redisUrlCountInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/","/login")
                .excludePathPatterns("/css/**","/fonts/**","/images/**","/js/**");
    }
}
