package com.atguigu.boot.controller;

import com.atguigu.boot.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: liuXiang
 * @Date: 2021/1/16 16:02
 */
@Controller
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping({"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.isNotBlank(user.getUserName())&&"123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","密码不对");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //配置完拦截器，所以不需要了
        /*Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/

        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String s = opsForValue.get("/main.html");
        String s1 = opsForValue.get("/sql");
        model.addAttribute("mainCount",s);
        model.addAttribute("sqlCount",s1);

        return "main";
    }
}
