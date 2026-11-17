package com.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//Advice + pointcut
@Component
@Aspect
public class AudianceAspect {

    @Around("execution(public void doCalculatePerformance())")
    public Object calculatingPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start=System.currentTimeMillis();

        Object val=proceedingJoinPoint.proceed();

        long end=System.currentTimeMillis();
        String methodName=proceedingJoinPoint.getSignature().getName();
        System.out.println("time taken to ex : "+ methodName +"() " + (end-start)+" ms");
        return val;
    }

//    @AfterReturning("execution(public void doMagic())")
//    @After("execution(public void doMagic())")
    @AfterReturning("execution( * com.demo.*.do*(..))")
    public void clapping(){
        System.out.println("mazza aa gaya");
    }

    @AfterThrowing(pointcut = "execution(public void doMagic())", throwing = "ex")
    public void callDr(FallFantedEx ex){
        System.out.println(ex.getMessage());
    }

//    @Pointcut("execution(public void doMagic())")
//    public void foo(){}
//
//    @Before("foo()")
//    public void clapping(){
//        System.out.println("mazza aa gaya");
//    }
}
