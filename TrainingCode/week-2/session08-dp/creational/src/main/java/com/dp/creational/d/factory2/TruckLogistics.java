package com.dp.creational.d.factory2;

public class TruckLogistics extends  Logistics{
    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
