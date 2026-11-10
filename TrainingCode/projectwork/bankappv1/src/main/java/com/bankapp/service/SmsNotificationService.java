package com.bankapp.service;

public class SmsNotificationService implements NotificationService{
    @Override
    public void notifyUser(String message) {
        System.out.println("sms is send");
    }
}
