package com.bankapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SmsNotificationService implements NotificationService{
    @Override
    public void notifyUser(String message) {
        System.out.println("sms is send");
    }
}
