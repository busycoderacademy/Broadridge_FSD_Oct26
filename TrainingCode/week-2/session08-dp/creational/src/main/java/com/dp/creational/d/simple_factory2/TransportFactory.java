package com.dp.creational.d.simple_factory2;

// Simple Factory=> OCP X
class TransportFactory {
    public static Transport createTransport(String type) {
        if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        } else if (type.equalsIgnoreCase("ship")) {
            return new Ship();
        }
        throw new IllegalArgumentException("Unknown transport type");
    }
}
