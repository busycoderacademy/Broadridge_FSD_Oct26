package com.session05.topic.generics;

import java.lang.reflect.Array;

//class Bar<T extends Comparable<T>> {
//	T i;
//	T j;
//
//	public T getI() {
//		return i;
//	}
//
//	public void setI(T i) {
//		this.i = i;
//	}
//
//	public T getJ() {
//		return j;
//	}
//
//	public void setJ(T j) {
//		this.j = j;
//	}
//
//}
//
//class Foo<T> {
//	T i;
//
//	public T getI() {
//		return i;
//	}
//
//	public void setI(T i) {
//		this.i = i;
//	}
//
//}

class UnderFlowEx extends RuntimeException {
}

class OverFlowEx extends RuntimeException {
}

//What is generic class?
/* also template class in c++ Stack s=new Stack(); i u create a genric stack u dont have to create multiple version

 */

class MyClass <T>{
	private T i;

	public T getI() {
		return i;
	}

	public void setI(T i) {
		this.i = i;
	}
}



class Stack<T> {
	private T x[];
	private final int SIZE;
	private int top;

	public Stack(Class<T> clazz, int capacity) {
		x = (T[]) Array.newInstance(clazz, capacity);
		SIZE = capacity;
		top = -1;
	}

	public void push(T element) {
		if (top >= SIZE)
			throw new OverFlowEx();
		else
			x[++top] = element;
	}

	public T pop() {
		if (top == -1)
			throw new UnderFlowEx();
		else
			return x[top--];
	}
}

//Template classes
//gen classs
//stack int, stack double , stack employee
public class D_Generic_Class {

	public static void main(String[] args) {

//		MyClass<Integer> myClass=new MyClass<>();
//		myClass.setI(3);
//		System.out.println(myClass.getI());
//
//		MyClass<Double> doubleMyClass=new MyClass<>();
//		doubleMyClass.setI(3.14);
//		System.out.println(doubleMyClass.getI());




//		Stack<Integer> s=new Stack<>(Integer.class, 10);
//		s.push(2);
//		System.out.println(s.pop());

		Stack<String> s=new Stack<>(String.class, 10);
		s.push("foo");
		System.out.println(s.pop());

//		Foo<String> foo=new Foo<>();
//		foo.setI("foo");
//		System.out.println(foo.getI());
//		

//		Foo<Integer> foo=new Foo<>();
//		foo.setI(3);
//		System.out.println(foo.getI());
	}
}
