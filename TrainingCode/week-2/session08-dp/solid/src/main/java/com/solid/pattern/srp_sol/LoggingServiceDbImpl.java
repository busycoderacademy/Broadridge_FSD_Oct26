package com.solid.pattern.srp_sol;

public class LoggingServiceDbImpl implements  LoggingService {
    @Override
    public void log(String message) {
        System.out.println("DB Log: " + message);
    }
}
