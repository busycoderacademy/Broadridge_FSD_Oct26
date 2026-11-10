package com.dp.behavioural.b.observer_dp2;

import java.util.Observable;

class StockMarket extends Observable {

    private String companyCode;
    private double price;

    public void setStock(String companyCode, double price) {
        this.companyCode = companyCode;
        this.price = price;

        System.out.println("\nStock Update → " + companyCode + " : ₹" + price);

        setChanged(); // VERY IMPORTANT (without this notify won't work)
        notifyObservers(); // notify all observers
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public double getPrice() {
        return price;
    }
}