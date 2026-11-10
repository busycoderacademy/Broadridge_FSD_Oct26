package com.solid.pattern.lsp1;
class Ak47{	
}
class SuperGun extends Ak47{	
}
class Don{
	public void shootAnyBody(Ak47 ak47) {
		System.out.println("shootAnyBody ");
	}
	public void enjoy() {
		System.out.println("enjoy");
	}
}
class DonSon{
	private Don don=new Don();

	public void enjoy() {
		don.enjoy();
	}
}
//class DonNextGen extends Don{
//	public void enjoy() {
//		System.out.println("enjoy enjoy super");
//	}
//}

public class DAExample {
	
	public static void main(String[] args) {
		DonSon donNextGen=new DonSon();
		donNextGen.enjoy();

	}

}
