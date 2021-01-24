package com.atguigu.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: liuXiang
 * @Date: 2021/1/18 10:24
 */
@Controller
@Slf4j
public class FormTestController {

    @GetMapping("/formLayouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息:email={},username={},headerImg={},photos={}",email,username,headerImg.getSize(),photos.length);
        log.info("getName={},getOriginalFilename={}",headerImg.getName(),headerImg.getOriginalFilename());
        if (!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\Test\\"+originalFilename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                String originalFilename = photo.getOriginalFilename();
                photo.transferTo(new File("D:\\Test\\"+originalFilename));
            }
        }
        return "main";
    }
}
