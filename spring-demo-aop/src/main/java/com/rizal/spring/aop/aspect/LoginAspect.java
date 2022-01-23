package com.rizal.spring.aop.aspect;

import com.rizal.spring.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(2)
public class LoginAspect {

    // create pointcut
    @Pointcut("execution(* *.*(..))")
    public void forDaoPackage(){};

    @Pointcut("execution(* *.get*(..))")
    public void getter(){}

    @Pointcut("execution(* *.set*(..))")
    public void setter(){}

    @Pointcut("execution(* *.toString())")
    public void tostring(){}

    // this is where we add all of our related for logging

    // create an aspect method with @Before annotation
    @Before("forDaoPackage() && !(getter() || setter() || tostring())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("\n===========>>>>>> Executing @Before advice on addAccount()");

        // get method signature of target method
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method signature : " + methodSig);

        // get argument passed by target method
        Object[] args = joinPoint.getArgs();

        for (Object arg : args){
            System.out.println("Argument : " + arg);
        }

    }

    // create aspect method ( returning value must same with object parameter name )
    @AfterReturning(
            pointcut = "execution(* com.rizal.spring.aop.dao.AccountDao.findAccounts(..))",
            returning = "accounts")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> accounts){
        // print out method signature of target method
        String methodSign = joinPoint.getSignature().toShortString();
        System.out.println("\n=============>>>>>> Executing @AfterReturning on method : " + methodSign);

        // print out result or return value of target method
        System.out.println("=============>>>>>> Return value is : " + accounts);

    }

}
