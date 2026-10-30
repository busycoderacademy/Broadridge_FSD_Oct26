package com.session05.topic.generics;

import java.util.LinkedList;
import java.util.List;

// super vs extends : generics 
public class B_Extends_Super {

	public static void main(String[] args) {
		//
		List<Integer> list = new LinkedList<>();
		list.add(8);
		list.add(19);
		list.add(22);
		list.add(21);

		print(list);
		
		List<Double> list2 = new LinkedList<>();
		list2.add(8.9);
		list2.add(19.7);
		list2.add(22.4);
		list2.add(21.0);

		print(list2);
		
		List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(101, "Raj", 95000));
        employees.add(new Employee(102, "Amit", 75000));
        employees.add(new Employee(103, "Neha", 120000));
        employees.add(new Employee(104, "Kiran", 85000));
        
        print(employees);

	}
	//hey compiler i can pass any list whose memember have something to do with Number 
	//i promise u i will iterate and never change it
	
	private static void print(List<?> list) {
		//list.add(new Cat());
		for (Object data : list) {
			System.out.println(data);
		}
	}
	
	
	
	
	
//Erasure of method print(List<Double>) is the same as another method in type B_Extends_Super
	//DRY algo datatype change ho raha hey 
	


}




