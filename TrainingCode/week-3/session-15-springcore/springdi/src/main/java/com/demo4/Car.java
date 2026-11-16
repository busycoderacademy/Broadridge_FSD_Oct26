package com.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
  <bean id="car" class="com.demo3.Car" autowire="byType" >
        </bean>
 */
//OCP
@Component(value = "car")
public class Car {
    Tyre tyre;

    @Autowired
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
    public void travel(){
        System.out.println("travel in car");
        tyre.rotate();
    }
}
