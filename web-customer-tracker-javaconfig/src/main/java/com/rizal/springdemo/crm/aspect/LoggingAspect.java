package com.rizal.springdemo.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    // setup logger
    Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration
    @Pointcut("execution(* com.rizal.springdemo.crm.controller.*.*(..))")
    public void controllerPointcut(){};

    @Pointcut("execution(* com.rizal.springdemo.crm.service.*.*(..))")
    public void servicePointcut(){};

    @Pointcut("execution(* com.rizal.springdemo.crm.dao.*.*(..))")
    public void daoPointcut(){};

    @Pointcut("controllerPointcut() || servicePointcut() || daoPointcut()")
    private void loggingPointcut(){};

    // add @Before advice
    @Before("loggingPointcut()")
    public void before(JoinPoint joinPoint){
        // display method
        logger.info("=====>> @Before Advice - Target Method : " + joinPoint.getSignature().toShortString());

        // display argument
        Object[] args = joinPoint.getArgs();
        for (Object arg : args){
            logger.info("=====>> @Before Advice - Arg : " + arg);
        }
    }


    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "loggingPointcut()",
            returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue){

        // display method
        logger.info("=====>> @AfterReturning Advice - Target Method : " + joinPoint.getSignature().toShortString());

        logger.info("=====>> @AfterReturning  Advice - Return Value : " + returnValue);
    }
}
