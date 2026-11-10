package com.bankapp.service;

public class EmailNotificationService implements NotificationService{
    @Override
    public void notifyUser(String message) {
        System.out.println("email is send");
    }
}
