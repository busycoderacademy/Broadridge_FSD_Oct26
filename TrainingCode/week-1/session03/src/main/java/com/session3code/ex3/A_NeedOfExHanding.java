package com.session3code.ex3;
import java.util.InputMismatchException;
import java.util.Scanner;

//EX handing : robust
public class A_NeedOfExHanding {
	public static void main(String[] args) {
		//java 7: ARM automatic resouce mgt
		//try with resouce then u dont have to close explicity i will do on behalf of u


		//A R M=> try with resouces => Java 7 long back
		try(Scanner scanner = new Scanner(System.in)){
			int a;int b;
			System.out.println("pe 2 nos");
			a = scanner.nextInt();
			b = scanner.nextInt();
			int c = a / b;
			System.out.println(c);
			System.out.println("inside catch");
		}catch (InputMismatchException e) {
			System.out.println("dont enter char or something else only int are allowed");
		} catch (ArithmeticException e) {
			System.out.println("dont do divide by zero");
		}catch (Exception e) {
			System.out.println("some other ex");
		}
		System.out.println("end");







//		Scanner scanner=null;
//		try{
//			int a;int b;
//			scanner = new Scanner(System.in);
//			System.out.println("pe 2 nos");
//			a = scanner.nextInt();
//			b = scanner.nextInt();
//			int c = a / b;
//			System.out.println(c);
//			System.out.println("inside catch");
//		}catch (InputMismatchException e) {
//			System.out.println("dont enter char or something else only int are allowed");
//		} catch (ArithmeticException e) {
//			System.out.println("dont do divide by zero");
//		}catch (Exception e) {
//			System.out.println("some other ex");
//		}finally {
//			scanner.close();
//		}
//		System.out.println("end");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner scanner = null;
//		try {
//			int a;
//			int b;
//			scanner = new Scanner(System.in);
//			System.out.println("pe 2 nos");
//			a = scanner.nextInt();
//			b = scanner.nextInt();
//
//			int c = a / b;
//			System.out.println(c);
//
//		} catch (ArithmeticException e) {
//			System.out.println("dont do divide by zero");
//		} catch (InputMismatchException e) {
//			System.out.println("only enter int only");
//
//		} catch (Exception e) {
//			System.out.println("only enter int only");
//
//		} finally {
//			scanner.close();
//		}

		//System.out.println("-------------");
	}
}
