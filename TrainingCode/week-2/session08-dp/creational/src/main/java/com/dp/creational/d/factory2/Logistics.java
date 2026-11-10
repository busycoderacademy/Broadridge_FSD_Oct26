package com.dp.creational.d.factory2;

// Creator (abstract)
abstract class Logistics {
    public void planDelivery() {
        // Factory Method
        Transport transport = createTransport();
        transport.deliver();
    }

    // Factory Method (to be overridden)
    protected abstract Transport createTransport();
}