package com.rizal.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {

    // create pointcut
    @Pointcut("execution(* add*(..))")
    private void forDaoPackage(){};

    // this is where we add all of our related for logging

    // create an aspect method with @Before annotation
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n===========>>>>>> Executing @Before advice on addAccount()");

    }
}
