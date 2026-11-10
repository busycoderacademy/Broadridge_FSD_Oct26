package com.dp.behavioural.c.strategy_dp;

//Strategy Interface
interface PaymentStrategy {
	void pay(int amount);
}
//Concrete Strategies
class PayPalStrategy implements PaymentStrategy {
	private String email;

	public PayPalStrategy(String email) {
		this.email = email;
	}

	public void pay(int amount) {
		System.out.println("Paid ₹" + amount + " using PayPal (" + email + ")");
	}
}
//Context – ShoppingCart

public class Main {

}
