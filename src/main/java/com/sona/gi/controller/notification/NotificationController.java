package com.sona.gi.controller.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.sona.gi.model.member.dto.MemberDto;
import com.sona.gi.service.member.MemberService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;


@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/sendNotification")
    public ResponseEntity<String> sendNotification() {
        // DB에서 모든 회원 정보 가져오기
        List<MemberDto> allMembers = memberService.findAll();

        // 모든 회원들의 푸시 알림 토큰 수집
        List<String> tokens = allMembers.stream()
                .map(MemberDto::getToken)
                .collect(Collectors.toList());

        // 알림 메시지 생성 및 전송
        sendPushNotification(tokens);

        return new ResponseEntity<>("Successfully sent message to all members", HttpStatus.OK);
    }

    // 푸시 알림 전송
    private void sendPushNotification(List<String> tokens) {
        // 알림을 전송하는 코드 변경 (Expo HTTP/2 API 직접 사용)

        // 주소를 포함한 알림 메시지 생성
        List<Map<String, Object>> notifications = new ArrayList<>();
        for (String token : tokens) {
            Map<String, Object> notification = new HashMap<>();
            notification.put("to", token);
            notification.put("title", "음식 등록 알림");
            notification.put("body", "5km 이내 식당에서 음식이 등록되었습니다!");
            notification.put("sound", "default");
            notification.put("data", Collections.singletonMap("withSome", "data"));
            notifications.add(notification);
        }

        try {
            // 메세지 전송
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<List<Map<String, Object>>> entity = new HttpEntity<>(notifications, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    "https://exp.host/--/api/v2/push/send",
                    HttpMethod.POST,
                    entity,
                    String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("Successfully sent messages to all members");
            } else {
                System.err.println("Failed to send messages to all members");
            }
        } catch (Exception e) {
            System.err.println("Error sending messages to all members: " + e.getMessage());
        }
    }
}