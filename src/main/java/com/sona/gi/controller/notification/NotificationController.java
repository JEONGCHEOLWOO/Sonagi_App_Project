package com.sona.gi.controller.notification;

import com.sona.gi.model.notification.dto.NotificationDto;
import com.sona.gi.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boot/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/regist") //
    public int regist(@RequestBody NotificationDto notificationDto){
        int resultCnt = notificationService.regist(notificationDto);
        return resultCnt;
    }

    @GetMapping("/findAll")
    public List<NotificationDto> findAll(){
        List<NotificationDto> list = notificationService.findAll();
        return list;
    }

}