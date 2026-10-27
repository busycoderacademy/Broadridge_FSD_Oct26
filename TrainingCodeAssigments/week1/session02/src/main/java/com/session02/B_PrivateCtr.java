package com.session02;
//Sometime we want to control no of object of class: Singleton Design Pattern

class MyClass{
    private static MyClass myClass=new MyClass();

    private MyClass(){
        System.out.println("dare to call me");
    }

    public static MyClass getInstance(){
        return myClass;
    }

    public void display(){
        System.out.println("this is a display method ");
    }
}
public class B_PrivateCtr {

    public static void main(String[] args) {
//        MyClass myClass=new MyClass();
        MyClass myClass=MyClass.getInstance();
        myClass.display();
    }

}
