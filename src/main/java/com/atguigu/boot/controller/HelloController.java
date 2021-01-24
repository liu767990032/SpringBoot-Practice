package com.atguigu.boot.controller;

import com.atguigu.boot.entity.Account;
import com.atguigu.boot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: liuXiang
 * @Date: 2021/1/9 15:48
 */
@Controller
public class HelloController {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String handle1(){
        return "hello world springboot";
    }

    @GetMapping("/hello2")
    public String handle2() {
        return "forward:/hello";//转发
    }

    @GetMapping("/hello3")
    public String handle3() {
        return "redirect:http://www.qq.com";
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("msg","深田咏美");
        model.addAttribute("link","http://www.huya.com");
        return  "success";
    }

    @GetMapping("/sqlTest")
    @ResponseBody
    public Account sqlTest(@RequestParam("id") Long id){
        Account acct = accountMapper.getAcct(id);
        return acct;

    }
}
