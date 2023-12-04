package com.sona.gi.service.notification;

import com.sona.gi.model.notification.dto.NotificationDto;
import com.sona.gi.model.notification.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    private NotificationMapper notificationMapper;


    @Override
    public int regist(NotificationDto notificationDto) { return notificationMapper.regist(notificationDto);}

    @Override
    public List<NotificationDto> findAll() { return notificationMapper.findAll();}
}
