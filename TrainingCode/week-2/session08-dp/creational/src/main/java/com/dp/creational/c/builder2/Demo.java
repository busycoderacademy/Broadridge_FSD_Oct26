package com.dp.creational.c.builder2;

public class Demo {

	public static void main(String[] args) {
		Vehicle  vehicle= Vehicle.builder()
				.name("Bike")
				.price("10000")
				.engine("100cc")
				.wheel(2)
				.airbags(2)
				.color("Red")
				.weight("100kg")
				.build();
	}
}
