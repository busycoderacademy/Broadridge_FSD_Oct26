package com.bankapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService  implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("email is send to the customer "+ message);
    }
}
