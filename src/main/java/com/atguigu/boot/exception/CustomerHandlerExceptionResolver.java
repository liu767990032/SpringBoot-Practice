package com.atguigu.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: liuXiang
 * @Date: 2021/1/18 13:28
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)//值越小，优先级越高
@Component
@Slf4j
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {
        try {
            httpServletResponse.sendError(511,"我喜欢的错误");
        } catch (IOException e1) {
            log.error(e1.getMessage());
        }
        return new ModelAndView();
    }
}
