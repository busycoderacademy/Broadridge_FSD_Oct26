package com.session3code.ex3;

public class D2_NeverThrowsAnyExFromFinally {

	//raj
	public static void main(String[] args) {
		try{
			foo();
		}catch (Exception e){
			System.out.println(e);
		}
	}

	//Pawan
	private static void foo() {
		try {
			if(1==1)
				throw new ArithmeticException("some arthmatic ex");
		}finally {
			throw new IllegalArgumentException("some arg are not legal");
		}
	}
}
