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

        convertAccountNamesToUpperCase(accounts);
    }

    @AfterThrowing(
            pointcut = "execution(* com.rizal.spring.aop.dao.AccountDao.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception){

        System.out.println("\n\n============>>>>>> Executing @AfterThrowing advice on findAccounts()");
        // print out the method signature of target method
        String methodSig = joinPoint.getSignature().toShortString();
        System.out.println("Method : " + methodSig);

        // do something on exception
        System.out.println("Throwable Cought : " + exception);
    }

    private void convertAccountNamesToUpperCase(List<Account> accounts) {

        // iterate the accounts
        accounts.forEach(account -> {

            // change each account name to upper case
            account.setName(account.getName().toUpperCase());
        });

    }

}
