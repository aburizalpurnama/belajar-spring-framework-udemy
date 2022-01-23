package com.rizal.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {

    public void addMember(){
        System.out.println(getClass() + " : Do some db stuff - add member");
        throw new RuntimeException("Got some ptoblem here..");
    }
}
