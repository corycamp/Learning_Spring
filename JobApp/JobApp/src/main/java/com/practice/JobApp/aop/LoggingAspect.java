package com.practice.JobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class name, args
    //execution(* *.*(..)) this means execute the log for all return types, all classes and there methods with any argument
    //com.practice.JobApp.service.JobService.*(..) this for the job service class and method and the .. is for any argument
    @Before("execution(* com.practice.JobApp.service.JobService.*(..))")
    public void logMethodCall(){
        LOGGER.info("Method called");
    }

    @Before("execution(* com.practice.JobApp.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called"+jp.getSignature().getName());
    }

    @After("execution(* com.practice.JobApp.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

}