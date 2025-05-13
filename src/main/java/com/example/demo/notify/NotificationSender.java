package com.example.demo.notify;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {

  private final Map<String, NotificationService> servicesSenders;

  // Автоматическое внедрение через конструктор
  @Autowired
  public NotificationSender(
      @Qualifier("email") NotificationService emailService,
      @Qualifier("sms") NotificationService smsService
  ) {
    this.servicesSenders = new HashMap<>();
    servicesSenders.put("email", emailService);
    servicesSenders.put("sms", smsService);
  }

  public void notifyUser(String message, NotificationType type) {
    var methodSender = type.name().toLowerCase();
    var service = servicesSenders.get(methodSender);

    if (service == null) {
      throw new RuntimeException("Такого способа отправки нет");
      // сделал так чтоб не обрабатывать исключение,
      // по правильному да, BadRequest кидать надо
    }

    service.send(message);
  }

}