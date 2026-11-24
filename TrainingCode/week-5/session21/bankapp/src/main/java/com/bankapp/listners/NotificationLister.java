package com.bankapp.listners;

import com.bankapp.events.TransferEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationLister {

    @EventListener
    void notification(TransferEvent transferEvent){
        System.out.println(transferEvent);
        System.out.println("--------notification is called ----------");
    }
}
