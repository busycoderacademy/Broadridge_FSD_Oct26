package com.bankapp.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService{
    @Override
    public void notifyUser(String message) {
        System.out.println("email is send");
    }
}
