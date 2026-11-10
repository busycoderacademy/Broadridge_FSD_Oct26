package com.bankapp.controller;

import java.util.concurrent.*;

/*
Create a simple concurrency example using Runnable or ExecutorService.
 */
//1. logic to be executed on top of thead pool. Runnable vs  Callable<Long>: can the return the processing result
class FactorialService implements Callable<Long> {
    private int number;

    public FactorialService(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {

        System.out.println(
                "Calculating factorial of " + number +
                        " using " + Thread.currentThread().getName()
        );

        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }

        return factorial;
    }
}
public class DemoMultithreading {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Spring Boot and tomcat (web container ): thread pool

        //it is aka job that have to provide to Thread Callable is same as runnable
        //we can not use thread directly we have to use a concept of thread pool
        //ie u dont need to mange the thread u just ask java to give u thread pool so all life cycle mgt of thread is
        //not ur responsiblity
        FactorialService factorialService=new FactorialService(5);
        ExecutorService executorService= Executors.newFixedThreadPool(1);// this thrad pool has 1 thread only
        //i want to assign a job to the thread pool
        Future<Long> longFuture=executorService.submit(factorialService);
        System.out.println("job is submitted");
        //i want get the job done
        Long l = longFuture.get();
        System.out.println("job is done: "+ l);
        executorService.shutdown();

    }
}
