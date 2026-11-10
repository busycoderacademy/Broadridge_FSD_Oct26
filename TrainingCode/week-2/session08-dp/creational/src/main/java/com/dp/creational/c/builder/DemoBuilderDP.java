package com.dp.creational.c.builder;

public class DemoBuilderDP {
	
	public static void main(String[] args) {
		//public Food1(String name, int unit, int vitC, int vitA, int vitB12, int vitB5, int vitD)
//		Food1 food1=new Food1("PG",80,1,1, 12,5,50);
		Food food=new Food.Builder("PG",80)
				.vitC(1)
				.vitA(1)
				.vitB12(12)
				.vitB5(5)
				.vitD(50)
				.build();
		//StringBuilder
		
		String a="foo"+"bar"+"jar"+"car";//good code or bad code
		//it polute string pool?
		
		
		String b=new StringBuffer().append("foo").append("bar").append("jar").append("car").toString();
		
		
		
//		String hello="i love java";
//	
//		String helloRev=new StringBuilder().append(hello).reverse().toString();
//		
		
		
		//fluent api design : mockito, mock testing
		//java 8 
		String builder=new StringBuilder().append("foo").append("bar").append("jar").toString();
		
		
	}

}
