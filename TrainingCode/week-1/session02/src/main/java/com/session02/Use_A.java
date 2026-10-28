package com.session02;
//a passanger named raj moving from Bangargatta to BTM using car/bike/cycle/Bus of ola

//a module should not talk to another
// moudule directly rather it shoiuld talk via "abstract" => can be achive in 2 ways : interface vs abstract class

//abstract class Vehicle {
//    abstract void move(String source , String destination);
//}

interface Vehicle {
    abstract void move(String source , String destination);
}

class Car implements   Vehicle {
   public void move(String source , String destination){
        System.out.println("moving in a car: from "+ source +" to "+ destination);
    }
}
class Bike implements   Vehicle {
   public void move(String source , String destination){
        System.out.println("moving in a bike: from "+ source +" to "+ destination);
    }
}
class Bus implements   Vehicle {
    public void move(String source , String destination){
        System.out.println("moving in a bus: from "+ source +" to "+ destination);
    }
}
class Passanger {
    private String name;
    public Passanger(String name){
        this.name=name;
    }
    public void travel(String source , String destination, Vehicle vehicle){
        vehicle.move(source,destination);
    }
}
public class Use_A {
    public static void main(String[] args) {
        //polymorphism
        Vehicle car=new Car();
        Vehicle bike=new Bike();
        Vehicle bus=new Bus();
        Passanger passanger=new Passanger("Raj");
        passanger.travel("Bangargatta","BTM",bus);
    }
}
