package com.atguigu.boot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liuXiang
 * @Date: 2021/1/16 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
