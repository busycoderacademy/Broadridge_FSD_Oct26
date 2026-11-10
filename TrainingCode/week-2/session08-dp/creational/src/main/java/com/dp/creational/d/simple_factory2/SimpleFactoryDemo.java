package com.dp.creational.d.simple_factory2;

// Client
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Transport t1 = TransportFactory.createTransport("truck");
        t1.deliver();

        Transport t2 = TransportFactory.createTransport("ship");
        t2.deliver();
    }
}