package com.dp.creational.d.factory2;

// Client
public class SimpleFactoryDemo {
    public static void main(String[] args) {

        Logistics logistics = new TruckLogistics();
        logistics.planDelivery();

        logistics = new ShipLogistics();
        logistics.planDelivery();
    }
}