package com.rizal.spring.boot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String sayHello(){
        return "Wuuhu ";
    }

    @GetMapping("/ducek")
    public String hul(){
        return "ducek";
    }
}
