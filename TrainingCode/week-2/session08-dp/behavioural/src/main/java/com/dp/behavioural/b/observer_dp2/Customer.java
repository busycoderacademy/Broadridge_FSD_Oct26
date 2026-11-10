package com.dp.behavioural.b.observer_dp2;

import java.util.Observable;
import java.util.Observer;

class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof StockMarket) {
            StockMarket market = (StockMarket) o;

            System.out.println(name + " notified → "
                    + market.getCompanyCode()
                    + " price: ₹" + market.getPrice());
        }
    }
}