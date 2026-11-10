package com.dp.creational.a.singleton;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//oops--ex handling--colletion and threads

public class DemoSingletonPattern {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton==singleton1);


		//java
//		Runtime r=Runtime.getRuntime();
//		Runtime r1=Runtime.getRuntime();
//
//		System.out.println(r==r1);
	
		
		
	}
}
