package com.example.demo.notify;

import lombok.Getter;

@Getter
public enum NotificationType {
  SMS("sms"), EMAIL("email");

  private final String type;

  NotificationType(String type) {
    this.type = type;
  }

}
