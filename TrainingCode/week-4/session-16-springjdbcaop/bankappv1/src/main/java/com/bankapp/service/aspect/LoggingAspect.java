package com.bankapp.service.aspect;

import com.bankapp.dto.Account;
import com.bankapp.service.AccountServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingAspect {

    private Logger logger= LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution(* com.bankapp.service..*.*(..))")
    //@Around("execution( * com.bankapp.service..*.*(..))")
    public  Object doCalculatePerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start=System.currentTimeMillis();

        Object val=proceedingJoinPoint.proceed();

        long end=System.currentTimeMillis();
        String methodName=proceedingJoinPoint.getSignature().getName();
        logger.info("time taken to execute  is :"+methodName +"() "+ (end-start)+" ms");
        return val;
    }
}
