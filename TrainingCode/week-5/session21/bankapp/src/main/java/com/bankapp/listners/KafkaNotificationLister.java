package com.bankapp.listners;

import com.bankapp.events.TransferEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationLister {

    @KafkaListener(topics = "fund-transfer-events",groupId = "notification-group")
    void notification(TransferEvent transferEvent){
        System.out.println(transferEvent);
        System.out.println("--------$$$$$$$$$$$notification is called using kafka$$$$$$$$$$$$$ ----------");
    }
}
