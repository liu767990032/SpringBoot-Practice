package com.atguigu.boot.controller;

import com.atguigu.boot.entity.User;
import com.atguigu.boot.exception.UserToManyException;
import com.atguigu.boot.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @Author: liuXiang
 * @Date: 2021/1/16 17:17
 */
@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basicTable")
    public String basicTable(){
        //模拟500错误
        int a= 10/0;
        return "table/basic_table";
    }
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamicTable";
    }

    @GetMapping("/dynamicTable")
    public String dynamicTable(@RequestParam(value = "pn" ,defaultValue = "1") Integer pn, Model model){

//        List<User> list = userService.list();
//        model.addAttribute("userList",list);
        Page<User> userPage = new Page<>(pn,2);
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);
        return "table/dynamic_table";
    }

    @GetMapping("/responsiveTable")
    public String responsiveTable(){
        return "table/responsive_table";
    }

    @GetMapping("/editableTable")
    public String editableTable(){
        return "table/editable_table";
    }
}
