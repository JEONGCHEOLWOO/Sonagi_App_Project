package com.sona.gi.model.notification.mapper;

import com.sona.gi.model.notification.dto.NotificationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {
    int regist(NotificationDto notificationDto);
    List<NotificationDto> findAll();
}
