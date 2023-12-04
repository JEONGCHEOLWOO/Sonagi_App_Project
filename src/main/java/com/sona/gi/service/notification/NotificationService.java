package com.sona.gi.service.notification;

import com.sona.gi.model.notification.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    int regist(NotificationDto notificationDto);
    List<NotificationDto> findAll();
}
