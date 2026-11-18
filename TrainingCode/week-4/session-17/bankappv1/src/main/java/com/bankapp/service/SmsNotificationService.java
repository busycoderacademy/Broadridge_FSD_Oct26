package com.bankapp.service;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("sms is send to the customer "+ message);
    }
}
