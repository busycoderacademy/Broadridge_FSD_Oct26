package com.threads.session1.classical_threads;

//C_UsingAnnInnerClass vs labmbda
public class C_UsingAnnInnerClass {
	public static void main(String[] args) {

		//java 8: ann inner class vs lambda expression

		Thread thread = new Thread(()-> System.out.println("thread is doing the job :"+ Thread.currentThread().getName()), "A");
		thread.start();



	}


}
