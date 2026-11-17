package com.demo1;

public class Main {
    public static void main(String[] args) {
        //we are manully create the object of MrfTyre ie a kaind of tyre into car
        //Spinng does it automatically create the object of Tyre and Car and then assign
        //tyre to the car
        Tyre tyre=new MrfTyre();
        Car car=new Car();
        car.setTyre(tyre);
        car.travel();
    }
}
