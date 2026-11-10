package com.dp.creational.a.singleton;

import java.io.Serializable;

/*
 	" one object per application" ex logging , db connection etc

	=> lazy vs eager
	=> threading issue, double locking
	=> What if clonned
	=> What if deserilized?
	=> What if used java reflection?
	=> what if 2 class loader load that class twice
	=> best practices, effective java
	=> using enum
 */
//THERE are multiple way singleton dp may fail, best way to to not
//implement urself use framework like spring boot all "beans" are by default signton
final public class Singleton {
    private Singleton(){}
    private static Singleton instance=new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

	
}

//int i=5;
//long i=5;read in two step
















