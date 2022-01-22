package com.rizal.spring.aop.dao;

import com.rizal.spring.aop.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount(Account account){
        System.out.println(getClass() + ": Doing DB work - Add an account");
    }
}
