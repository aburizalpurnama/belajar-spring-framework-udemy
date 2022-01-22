package com.rizal.spring.aop.entity;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private String name;

    private void addFoo(){
        System.out.println(getClass() + " : addFoo");
    }

    public String getName() {
        System.out.println(getClass() + "getName() here");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass() + "setName() here");
    }
}
