package com.example.demo.notify;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service()
@Qualifier("email")
public class EmailService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Отправка Email: " + message);
    }
}
