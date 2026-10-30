package com.session05.topic.generics;

import java.util.LinkedList;
import java.util.List;

// extends : upper bound
// super : lower bound: super se upper
class Animal {
}

class Cat extends Animal {
}

class CostlyCat extends Cat {
}

class Dog extends Animal {
}

class CostlyDog extends Dog {
}

class YetAnotherCostlyDog extends CostlyDog {
}

public class B_Extends_SuperEx2 {

	public static void main(String[] args) {
//		List<Dog> list=new ArrayList<Dog>();
//		list.add(new Dog());
//		list.add(new CostlyDog());
//		list.add(new YetAnotherCostlyDog());
		
		
//		Animal[]animals=new Dog[5];
		// super ya super se uper
		
		// The method add(capture#1-of ? super CostlyDog) in the
		// type List<capture#1-of ? super CostlyDog>
		// is not applicable for the arguments (Animal)
		
		//super se uper
		List<Object> dogs = new LinkedList<Object>();
	
		//foo(dogs);
		
		System.out.println(dogs);

		
		

		// List<Dog> dogs=new LinkedList<>();
//		dogs.add(new Dog());
//		dogs.add(new CostlyDog());
//		foo(dogs);
		// super se upper
//		List<? super Dog> dogs=new LinkedList<CostlyDog>();

	}

//	static void foo(List<Object> dogs) {
//		 for(Dog d: dogs) {
//			 System.out.println(d);
//		 }
//		dogs.add(new Dog());
//	}
}
