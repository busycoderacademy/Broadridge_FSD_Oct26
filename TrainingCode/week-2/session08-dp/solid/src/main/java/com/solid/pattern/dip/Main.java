package com.solid.pattern.dip;


public class Main {

	public static void main(String[] args) {
		//me assign aka manual dp... Car need to pull the tyre
		//how geat it would if rather then car ask for tyre ...tyre should be injected to car
		// this DI dependency injection:
		Tyre tyre=new MrfTyre();

		Car car=new Car(tyre);
		car.move();
	}
}
