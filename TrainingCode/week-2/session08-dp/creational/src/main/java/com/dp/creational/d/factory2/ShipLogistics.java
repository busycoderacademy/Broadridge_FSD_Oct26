package com.dp.creational.d.factory2;

public class ShipLogistics extends  Logistics{
    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
