package com.dp.creational.d.factory2;

// Concrete Products
class Truck implements Transport {
    public void deliver() {
        System.out.println("Deliver by land in a box");
    }
}