package com.sona.gi.controller.notification;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;
import java.nio.charset.StandardCharsets;

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

    @GetMapping("/sendNotification")
    public ResponseEntity<String> sendNotification(@RequestParam("address") String address) {
        // 주소를 좌표로 변환
        String coordinates = convertAddressToCoordinates(address);

        // DB에서 모든 회원 정보 가져오기
        List<MemberDto> allMembers = memberService.findAll();

        // 5km 이내에 있는 회원들의 푸시 알림 토큰 수집
        List<String> tokens = getTokensWithin5km(allMembers, coordinates);

        // 알림 메시지 생성 및 전송
        sendPushNotification(tokens, coordinates);

        return new ResponseEntity<>("Successfully sent message to all members", HttpStatus.OK);
    }

    // 주소를 좌표로 변환하는 메서드
    private String convertAddressToCoordinates(String address) {
        // Geocoding API 호출 및 응답 받기
        RestTemplate restTemplate = new RestTemplate();
        String geocodingApiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK {db06c51425b99419a11f3881f8491642}");

        // 주소를 URL 인코딩하여 요청 보내기
        String encodedAddress = UriUtils.encode(address, StandardCharsets.UTF_8);
        String apiUrl = geocodingApiUrl + "?query=" + encodedAddress;

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity,
                String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String responseBody = responseEntity.getBody();
            String coordinates = extractCoordinatesFromResponse(responseBody);
            return coordinates;
        } else {
            throw new RuntimeException("Failed to convert address to coordinates");
        }
    }

    // Geocoding API 응답에서 좌표 정보 추출하는 메서드
    private String extractCoordinatesFromResponse(String responseBody) {
        // 응답 JSON 파싱하여 좌표 정보 추출
        // 실제 Geocoding API 응답에 따라 JSON 파싱 로직을 작성해주세요.
        // 예시로 주어진 응답 예시에서 "x"와 "y" 필드를 추출하는 로직을 작성합니다.
        // JSON 라이브러리를 사용하여 파싱합니다.
        JSONObject responseJson = new JSONObject(responseBody);
        JSONArray documents = responseJson.getJSONArray("documents");

        if (documents.length() > 0) {
            JSONObject document = documents.getJSONObject(0);
            String x = document.getString("x");
            String y = document.getString("y");
            return x + "," + y;
        } else {
            throw new RuntimeException("Failed to extract coordinates from Geocoding API response");
        }
    }

    // 5km 이내에 있는 회원들의 토큰 추출
    private List<String> getTokensWithin5km(List<MemberDto> members, String coordinates) {
        List<String> tokensWithin5km = new ArrayList<>();

        for (MemberDto member : members) {
            // 회원의 주소를 좌표로 변환하여 거리 계산
            String memberCoordinates = convertAddressToCoordinates(member.getAddress());
            double distance = calculateDistance(coordinates, memberCoordinates);

            // 5km 이내에 있는 회원의 토큰만 추출
            if (distance <= 5) {
                tokensWithin5km.add(member.getToken());
            }
        }

        return tokensWithin5km;
    }

    // 좌표 간 거리 계산
    private double calculateDistance(String coordinates1, String coordinates2) {
        // 좌표 간 거리 계산 로직 작성
        // 실제로 좌표 간 거리를 계산하는 방법에 따라 로직을 작성해주세요.
        // 예시로 유클리디안 거리를 계산하는 로직을 작성합니다.
        // 좌표를 파싱하여 좌표 간 거리를 계산하는 코드를 작성해주세요.
        String[] coord1 = coordinates1.split(",");
        double x1 = Double.parseDouble(coord1[0]);
        double y1 = Double.parseDouble(coord1[1]);
        String[] coord2 = coordinates2.split(",");
        double x2 = Double.parseDouble(coord2[0]);
        double y2 = Double.parseDouble(coord2[1]);
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

    // 푸시 알림 전송
    private void sendPushNotification(List<String> tokens, String coordinates) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        for (String token : tokens) {
            Map<String, Object> notification = new HashMap<>();
            notification.put("to", token);
            notification.put("title", "음식 등록 알림");
            notification.put("body", "5km 이내 식당에서 음식이 등록되었습니다!");
            notification.put("sound", "default");
            notification.put("data", Collections.singletonMap("withSome", "data"));
            notification.put("coordinates", coordinates); // 좌표 정보 추가

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(notification, headers);

            try {
                ResponseEntity<String> response = restTemplate.exchange(
                        "https://exp.host/--/api/v2/push/send",
                        HttpMethod.POST,
                        entity,
                        String.class);

                if (response.getStatusCode() == HttpStatus.OK) {
                    System.out.println("Successfully sent message to member with token: " + token);
                } else {
                    System.err.println("Failed to send message to member with token: " + token);
                }
            } catch (Exception e) {
                System.err
                        .println("Error sending message to member with token: " + token + ", error: " + e.getMessage());
            }
        }
    }

}