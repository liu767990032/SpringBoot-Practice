package com.atguigu.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Author: liuXiang
 * @Date: 2021/1/18 18:35
 */
//@SpringBootConfiguration
//@Slf4j
  @Deprecated
public class MyDataSourceConfig {

/*    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            //开启sql监控,防火墙,可在yml配置
            druidDataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            log.error("druidDataSource.setFilters报错！");
        }
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> r = new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        r.addInitParameter("loginUsername","admin");
        r.addInitParameter("loginPassword","123456");
        return r;
    }

    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> f = new FilterRegistrationBean<>(webStatFilter);
        f.setUrlPatterns(Arrays.asList("/*"));
        f.addInitParameter("exclusions",".js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return f;
    }*/
}
