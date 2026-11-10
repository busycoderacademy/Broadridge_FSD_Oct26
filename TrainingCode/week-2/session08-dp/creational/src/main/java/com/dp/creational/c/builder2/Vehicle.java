package com.dp.creational.c.builder2;

import lombok.*;
import lombok.Builder;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class Vehicle {
	private String name;
	private String price;
	private String engine;
	private int wheel;
	private int airbags;
	//add more fields
	private String color;
	public String weight;

}
