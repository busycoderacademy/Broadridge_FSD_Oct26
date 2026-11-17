package com.demo2;

//OCP
public class Car {
    Tyre tyre;
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
    public void travel(){
        System.out.println("travel in car");
        tyre.rotate();
    }
}
