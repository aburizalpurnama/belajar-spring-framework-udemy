package com.rizal.spring.aop.aspect;

import com.rizal.spring.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoginAspect {

    // create pointcut
    @Pointcut("execution(* com.rizal.spring.aop.*.*.*(..))")
    public void forDaoPackage(){};

    @Pointcut("execution(* *.get*(..))")
    public void getter(){}

    @Pointcut("execution(* *.set*(..))")
    public void setter(){}

    // this is where we add all of our related for logging

    // create an aspect method with @Before annotation
    @Before("forDaoPackage() && !(getter() || setter())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("\n===========>>>>>> Executing @Before advice on addAccount()");

        // get method signature of target method
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method signature : " + methodSig);

        // get argument passed by target method
        Object[] args = joinPoint.getArgs();

        for (Object arg : args){
            System.out.println("Argument : " + arg);
            if (arg instanceof Account){

                // downcast the arg object
                Account account = (Account) arg;

                System.out.println("Account Argument : Account{name='" + account.getName() + "'}" );
            }
        }

    }

}
