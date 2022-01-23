package com.rizal.spring.aop.aspect;

import com.rizal.spring.aop.entity.Account;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
public class ExceptionHandlingAspect {

    @Around("execution(* *.findAccounts(*))")
    public Object handleSomeException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception exc){

            // log exception
            System.out.println("\n==========>>>>>>> @Around advice : we have a problem " + exc );

            // handle and give empty account list
            List<Account> accounts = new ArrayList<>();

            result = accounts;
        }

        return result;
    }

    @Around("execution(* addMember(..))")
    public Object rethrowingSomeException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        try {
            Object result = proceedingJoinPoint.proceed();

            return result;
        }catch (Exception exc){
            System.out.println("\n=======>>>>>>> @Around advice : We have some problem " + exc);

            //rethrow it
            throw exc;
        }
    }
}
