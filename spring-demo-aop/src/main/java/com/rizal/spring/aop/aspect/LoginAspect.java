package com.rizal.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoginAspect {

    // create pointcut
    @Pointcut("execution(* com.rizal.spring.aop.*.*.*(..))")
    private void forDaoPackage(){};

    @Pointcut("execution(* *.get*())")
    private void getter(){}

    @Pointcut("execution(* *.set*())")
    private void setter(){}

    // this is where we add all of our related for logging

    // create an aspect method with @Before annotation
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n===========>>>>>> Executing @Before advice on addAccount()");

    }

    @After("forDaoPackage() && (!getter() || setter())")
    public void afterDoSomeStruff(){
        System.out.println("\n============>>>>> Executing @After advice");
    }
}
