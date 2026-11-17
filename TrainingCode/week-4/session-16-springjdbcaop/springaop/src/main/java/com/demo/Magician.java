package com.demo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component(value = "magician")
 public class Magician {

    public void doCalculatePerformance(){
       // long start=System.currentTimeMillis();
        System.out.println("Best perforqance with world compitition");
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){}
//        long end=System.currentTimeMillis();
//        System.out.println("time taken to ex doCalculatePerformance: "+ (end-start)+" ms");
    }

    public void doEating(){
        System.out.println("eating eating");
    }
    public void doDreaming(){
        System.out.println("doDreaming");
    }

    public void doMagic(){
        Random random = new Random();

        if (random.nextInt(2) == 1) {
            throw new FallFantedEx("Call doctor now");
        }

        System.out.println("Abra ka dabra");
    }
}
