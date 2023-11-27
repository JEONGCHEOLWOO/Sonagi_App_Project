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

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/sendNotification")
    public ResponseEntity<String> sendNotification(@RequestBody List<MemberDto> members) {
        // Extracting addresses from the provided list of MemberDto objects
        List<String> addresses = members.stream()
                .map(MemberDto::getAddress)
                .collect(Collectors.toList());

        // DB에서 해당 주소들의 회원 정보 가져오기
        List<MemberDto> allMembers = memberService.findAll();

        // 5km 이내에 있는 회원 필터링
        List<MemberDto> nearbyMembers = filterNearbyMembers(allMembers, members);

        // 필터링된 회원들의 푸시 알림 토큰 수집
        List<String> tokens = nearbyMembers.stream()
                .map(MemberDto::getToken)
                .collect(Collectors.toList());

        // 알림 메시지 생성 및 전송
        sendPushNotification(tokens);

        return new ResponseEntity<>("Successfully sent message", HttpStatus.OK);
    }

    // 현재 주소와 5km 이내에 있는 회원 필터링
    private List<MemberDto> filterNearbyMembers(List<MemberDto> allMembers, List<MemberDto> targetMembers) {
        // 여기서는 주소가 일치하는 회원을 5km 이내에 있다고 가정합니다.
        // 실제로는 주소를 좌표로 변환하여 거리를 계산하는 로직이 필요합니다.
        List<String> targetAddresses = targetMembers.stream()
                .map(MemberDto::getAddress)
                .collect(Collectors.toList());

        return allMembers.stream()
                .filter(member -> targetAddresses.contains(member.getAddress()))
                .collect(Collectors.toList());
    }

    // 푸시 알림 전송
    private void sendPushNotification(List<String> tokens) {
        // 알림을 전송하는 코드 (이미 작성한 코드 활용)
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 주소를 포함한 알림 메시지 생성
        Map<String, Object> body = new HashMap<>();
        body.put("title", "음식 등록 알림");
        body.put("body", "5km 이내 식당에서 음식이 등록되었습니다!");
        body.put("sound", "default");
        body.put("data", Collections.singletonMap("withSome", "data"));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        for (String token : tokens) {
            try {
                // 메세지 전송
                ResponseEntity<String> response = restTemplate.exchange(
                        "https://exp.host/--/api/v2/push/send",
                        HttpMethod.POST,
                        entity,
                        String.class);

                if (response.getStatusCode() == HttpStatus.OK) {
                    System.out.println("Successfully sent message to token " + token);
                } else {
                    System.err.println("Failed to send message to token " + token);
                }
            } catch (Exception e) {
                System.err.println("Error sending message to token " + token + ": " + e.getMessage());
            }
        }
    }
}