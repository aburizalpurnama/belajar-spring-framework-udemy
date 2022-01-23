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

    @Before("com.rizal.spring.aop.aspect.LoginAspect.forDaoPackage() " +
            "&& !(com.rizal.spring.aop.aspect.LoginAspect.getter() " +
            "|| com.rizal.spring.aop.aspect.LoginAspect.setter()" +
            "|| com.rizal.spring.aop.aspect.LoginAspect.tostring())")
    public void doSecurity(){
        System.out.println("\n=========>>>> do some security stuff");
    }
}
