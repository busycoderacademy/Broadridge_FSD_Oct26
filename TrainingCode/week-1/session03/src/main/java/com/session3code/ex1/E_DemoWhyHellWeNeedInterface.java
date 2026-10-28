package com.session3code.ex1;
//Overrindg we can not reduce the visibility of the method
interface Jumpable{
	 void jump();
}
class Monkey implements Jumpable{
	public void jump() {
		System.out.println("monkey jump");
	}
	public void stayOnTree() {
		System.out.println("monkey stay on tree");
	}
	public void biteAGuys() {
		System.out.println("monkey bite a guy");
	}
}
//hey dev kid is not a monkey but it share a attribute with monkey hat is jumping
class Kid implements Jumpable{
	public void jump() {
		System.out.println("jumping from the wall hey monkey look me");
	}
	void study() {
		System.out.println("study and run away");
	}
}


public class E_DemoWhyHellWeNeedInterface {

	public static void main(String[] args) {
		Kid kid=new Kid();
		kid.jump();

		kid.study();
	}

}
