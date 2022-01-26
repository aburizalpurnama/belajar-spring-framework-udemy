package com.rizal.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/accessDenied")
    public String showAccessDeniedPage(){
        return "accessDenied";
    }
}
