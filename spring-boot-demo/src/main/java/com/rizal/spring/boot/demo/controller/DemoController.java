package com.rizal.spring.boot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${info.app.name}")
    String name;

    @GetMapping("/")
    public String sayHello(){

        return name;
    }

    @GetMapping("/ducek")
    public String hul(){
        return "ducek";
    }
}
