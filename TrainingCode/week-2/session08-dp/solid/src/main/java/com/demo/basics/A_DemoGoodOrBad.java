package com.demo.basics;
//"seprate what varies"


class Bird {
	void sound() {
		System.out.println("bird sound");
	}
	void fly(){
		System.out.println("flying");
	}
	void swim(){
		System.out.println("swimming");
	}
}

class Eagle extends Bird {

	@Override
	public void fly() {
		System.out.println("flying high...");
	}
	
}

class Emu extends Bird {
}

class Duck extends Bird {

	@Override
	public void swim() {
		System.out.println("swimming :)");
	}

}

public class A_DemoGoodOrBad {

	public static void main(String[] args) {

	}
}
