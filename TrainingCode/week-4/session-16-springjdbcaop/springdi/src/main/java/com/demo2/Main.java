package com.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //we are manully create the object of MrfTyre ie a kaind of tyre into car
        //Spinng does it automatically create the object of Tyre and Car and then assign
        //tyre to the car
//        Tyre tyre=new MrfTyre();
//        Car car=new Car();
//        car.setTyre(tyre);//rather then i create and assign the object myself
//        //we have a framework ie called spring framework can do this job
//        car.travel();

        //Spring create the dep and assign them rather then i am doing it
        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo2.xml");
        Car car=ctx.getBean("car",Car.class);
        //All the beans that is create by spring are singleton object
//        Car car2=(Car )ctx.getBean("car");
//        System.out.println(car==car2);
        car.travel();

    }
}
