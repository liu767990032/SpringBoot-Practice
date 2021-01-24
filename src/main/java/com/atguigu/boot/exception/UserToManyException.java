package com.atguigu.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: liuXiang
 * @Date: 2021/1/18 13:09
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户太多")
public class UserToManyException extends RuntimeException {

    public UserToManyException(){

    }

    public UserToManyException(String message){
        super(message);
    }

}
