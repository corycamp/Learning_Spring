package com.practice.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    //Use && args(argName) if you want to monitor the argument
    @Around("execution(* com.practice.JobApp.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
        if(postId < 0){
            LOGGER.info("PostId:"+postId);
            postId = -postId;
            LOGGER.info("New PostId:"+postId);
        }
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }
}
