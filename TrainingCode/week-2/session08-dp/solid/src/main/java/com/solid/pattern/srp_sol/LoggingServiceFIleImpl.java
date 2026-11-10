package com.solid.pattern.srp_sol;

public class LoggingServiceFIleImpl implements  LoggingService {
    @Override
    public void log(String message) {
        System.out.println("File Log: " + message);
    }
}
