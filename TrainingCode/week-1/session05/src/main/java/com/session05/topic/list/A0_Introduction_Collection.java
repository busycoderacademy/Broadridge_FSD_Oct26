package com.session05.topic.list;
//1. java util package is a lib which container readymade dsa : collection api
import java.net.CookieHandler;
import java.util.*;

public class A0_Introduction_Collection {

	public static void main(String[] args) {
		//Wath is collection api?
		// List, how to create list and display all elements
		//Car c=new Car();
		//Vehical v=new Car();
		//ArrayList interally use growable array
		List<String> list=new ArrayList<>(); //generics make ur ds typesafe
		list.add("foo");
		list.add("bar");
		list.add("abc");
		list.add("jar");
		list.add("jar");
		list.add("apple");
		System.out.println(list.get(2));//o(1)

		//Collections : class that have all the algo packaged togather
		//sort the data
		System.out.println("before sorting....");
		System.out.println(list);

		Collections.sort(list);
		//Collections.reverse(list);
		System.out.println("after sorting... ");
		System.out.println(list);
		//Binary search
		int index=Collections.binarySearch(list, "raj");
		System.out.println(index);

		//something ie called custom sort : comprable and comparator*





		//how to print the list
		//System.out.println(list);
		//How to print but u can not do other operator: delete update add
//		for(String data: list){
//			System.out.println(data);
//		}
		//Using iterator: it is a way to move in a ds  : Iterator(Read  and delete) vs ListIterator (CRUD

//		Iterator<String> it=list.iterator();
//		while(it.hasNext()){
//			String data=it.next();
//			it.remove();
//		}
//		System.out.println(list);

		//ListIterator vs Iterator
//		ListIterator<String> lit=list.listIterator();
//		while(lit.hasPrevious()){
//			System.out.println(lit.previous());
//		}

		//binary search

		//sort

		//using ListIterator

	}
}
