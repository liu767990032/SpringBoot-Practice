package com.atguigu.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: liuXiang
 * @Date: 2021/1/18 13:01
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleArithException(Exception e){
        log.error("异常是: {}",e);
        return "login";
    }
}
