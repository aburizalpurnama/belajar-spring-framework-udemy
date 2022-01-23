package com.rizal.spring.aop.dao;

import com.rizal.spring.aop.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class AccountDao {

    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account){
        System.out.println(getClass() + " : Doing DB work - Add an account");
        accounts.add(account);
    }

    public List<Account> findAccounts(){

        System.out.println(getClass() + " : Doing DB Work - find Accounts");

        // simulate delay
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public List<Account> findAccounts(boolean tripWire) {
        throw new RuntimeException("This is the exception message !!");
    }
}
