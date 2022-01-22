package com.rizal.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class SecurityAspect {

    @Pointcut("execution(* com.rizal.spring.aop.*.*.*(..))")
    private void fooPointcut(){}

    @Before("fooPointcut()")
    public void doSecurity(){
        System.out.println("\n=========>>>> do some security stuff");
    }
}
