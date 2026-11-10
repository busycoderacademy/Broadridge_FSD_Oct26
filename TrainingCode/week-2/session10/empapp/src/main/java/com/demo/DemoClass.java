package com.demo;

class Dog{
    public void sound(){
        System.out.println("bark");
    }
}
public class DemoClass {
    public static void main(String[] args) {

        Dog dog=new Dog();//here too java must have loaded this class in the memory somewhere
        dog.sound();
        //hey java can u give me the info of that class loader who did this job?
        ClassLoader classLoader = Dog.class.getClassLoader();
        System.out.println(classLoader);
    }
}
