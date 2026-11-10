package com.dp.behavioural.b.observer_dp2;

public class Main {

    public static void main(String[] args) {

        StockMarket market = new StockMarket();

        Customer c1 = new Customer("Raj");
        Customer c2 = new Customer("Amit");
        Customer c3 = new Customer("Neha");

        market.addObserver(c1);
        market.addObserver(c2);
        market.addObserver(c3);

        // Updates
        market.setStock("TCS", 3850.50);
        market.setStock("INFY", 1520.75);

        // Remove one observer
        System.out.println("\n---- Amit unsubscribed ----");
        market.deleteObserver(c2);

        market.setStock("HDFC", 2780.00);
    }
}