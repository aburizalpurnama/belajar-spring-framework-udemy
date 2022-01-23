package com.rizal.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TuningAspect {

    /**
     * This aspect will run before and after target object running.
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.rizal.spring.aop.dao.AccountDao.findAccounts(..))")
    public Object getDuration(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute method
        Object result = proceedingJoinPoint.proceed();

        // get duration
        double duration = System.currentTimeMillis() - begin;
        System.out.println("\n===========>>>>>>> Duration: " + duration / 1000 + "second");

        return result;
    }
}
