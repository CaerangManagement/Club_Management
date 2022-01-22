package com.management.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/") //메인페이지
    public String index(){
        return "/index";
    }

    @GetMapping("/login") //로그인 페이지
    public String login(){
        return "/login";
    }
    
    @GetMapping("/signup") //회원가입 페이지
    public String singup(){
        return "/signup";
    }


}
