package com.session3code.ex3;

public class D_NeverReturnAnyThingFromFinally {

	public static void main(String[] args) {
		int value=foo();
		System.out.println(value);
	}

	private static int foo() {
		try {
			return 10;//BL
		}finally {
			return 20;//Cleanup code
		}
	}
}
