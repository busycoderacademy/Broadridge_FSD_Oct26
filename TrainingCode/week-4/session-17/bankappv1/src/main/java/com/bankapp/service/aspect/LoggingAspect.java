package com.bankapp.service.aspect;

import com.bankapp.service.AccountServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect //advice + pointcut
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution( * com.bankapp.service..*.*(..))")
    public  Object applyTimingCalLogic(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start =System.currentTimeMillis();
    //somehow i need to call the target method, and that target method may also return some values
        Object val=proceedingJoinPoint.proceed();

        long end =System.currentTimeMillis();
        String methodName=proceedingJoinPoint.getSignature().getName();

        logger.info("time taken for execution of " +methodName +"()"+ (end-start)+" ms");
        return val;
    }

//    @Pointcut("execution( * com.bankapp.service..*.*(..))")
//    public void foo(){}
//
//    @After("foo()")
//    public  void log() {
//        System.out.println("something happens");
//    }
}
