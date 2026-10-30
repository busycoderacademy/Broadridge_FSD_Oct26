package com.session3code.ex1;

import java.util.Scanner;

//class A{
//	static public void show() {
//		System.out.println("A");
//	}
//}
//class B extends A{
//	static public void show() {
//		System.out.println("B");
//	}
//}
abstract class Animal{
	int age;
	public Animal(){
		System.out.println("Animal constructor");
	}
	abstract public void sound() ;
	public void eat(){
		System.out.println("animal eating");
	}
}
//aka 100% abstraction ( upto java 7) aka promise
// interface Animal{
//	  void sound() ;
//}

class Dog extends Animal{
	public void sound() {
		System.out.println("Bark");
	}
}
class  Cat extends Animal{
	public void sound() {
		System.out.println("Meow");
	}
}
class Snake extends Animal{
	public void sound() {
		System.out.println("Hiss");
	}
}

public class B_DemoOverriding {
	public static void main(String[] args) {
		//What is the adv of run time polymorphism?  Loose coupling
		//Answer: code flexibility?
		Animal animal=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter 1 for cat, 2 for dog, 3 for snake");
		int value=scanner.nextInt();
		if(value==1){
			animal=new Cat();
		}else if(value==2){
			animal=new Dog();
		}else  if(value==3){
			animal=new Snake();
		}else {
			System.out.println("wrong choice");
		}
		if(animal!=null) {
			animal.sound();
		}
	}
}
