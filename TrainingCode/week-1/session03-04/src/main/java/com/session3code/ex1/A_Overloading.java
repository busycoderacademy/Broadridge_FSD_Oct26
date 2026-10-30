package com.session3code.ex1;

import java.util.Scanner;

class Cal{
//	int add(int a, int b){
//		System.out.println("2 parameters");
//		return a+b;
//	}
//	int add(int a, int b, int c){
//		System.out.println("3 parameters");
//		return a+b+c;
//	}
	double add(double a, int b) {
		System.out.println("double, int");
		return a+b;
	}
	double add(int a, double b) {
		System.out.println("int, double");
		return a+b;
	}
}

public class A_Overloading {
	public static void main(String[] args) {


		Cal c=new Cal();
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();

//		int temp=a+b;

//		String str1="Hello";
//		String str2="Hello";
//		String temp2=str1+str2;


		//System.out.println(c.add(a, (double) b));
	}

}
