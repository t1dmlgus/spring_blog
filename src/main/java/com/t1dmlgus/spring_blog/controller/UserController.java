package com.t1dmlgus.spring_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/joinForm")
    public String joinForm(){

        return "/user/joinForm";
    }

}
