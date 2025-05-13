package com.example.demo.notify;

import com.fasterxml.jackson.databind.deser.BasicDeserializerFactory;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

  NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }


  @GetMapping("/sms")
  public void smsSender(@PathParam("message") String message) {
    var notificationService = new SmsService();
    notificationService.send(message);
  }

  @GetMapping("/email")
  public void emailSender(@PathParam("message") String message) {
    var notificationService = new EmailService();
    notificationService.send(message);
    BasicDeserializerFactory deserializerFactory;
  }
}
