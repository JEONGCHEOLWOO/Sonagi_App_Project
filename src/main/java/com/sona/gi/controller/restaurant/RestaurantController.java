package com.sona.gi.controller.restaurant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sona.gi.model.restaurant.dto.RestaurantDto;
import com.sona.gi.service.restaurant.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/boot/restaurant")
public class RestaurantController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RestaurantService restaurantService;


    @PostMapping("/regist")
    public HashMap<String, Object> regist(@RequestBody RestaurantDto restaurantDto){
        HashMap<String,Object> mv = new HashMap<>();

        int resultCnt = restaurantService.regist(restaurantDto);
        mv.put("result",resultCnt);
        return mv;
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    // 아래랑 동일
    @GetMapping("/findAll")
    public HashMap<String,Object> findAll(){
        HashMap<String,Object> mv = new HashMap<>();
        List<RestaurantDto> list = restaurantService.findAll();
        mv.put("list",list);
        return mv;
    }

    //검색 get, 수정 삭제 post
    @PostMapping("/modify")
    public HashMap<String,Object> modify(@RequestBody RestaurantDto restaurantDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= restaurantService.modify(restaurantDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/delete")
    public HashMap<String,Object> delete(@RequestBody RestaurantDto restaurantDto){
        HashMap<String,Object> mv = new HashMap<>();
        int resultCnt= restaurantService.delete(restaurantDto);
        mv.put("resultCnt",resultCnt);
        return mv;
    }

    @PostMapping("/checkRegist")
    public boolean check(@RequestBody String number) throws IOException {
        // 사업자 등록 번호: 000-00-00000
        // 앞에 3자리: 국세청 / 세무서별 코드
        // 2자리: 개인 법인 구분코드
        // 마지막 4자리: 과세/면세/법인 사업자 등록/지정일자 일련번호
        // 마지막 1자리: 검증번호
        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/nts-businessman/v1/status");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=t2qs2a1o15tXR1NhKWY%2FTplsMnvey2e3kTFt8BIlR8dJ6JsaALNvYI6%2B5dKPSJbl%2FJ9C0dF7%2Boi2NwGJKHikSQ%3D%3D"); /*Service Key*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");

        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = number.toString().getBytes("UTF-8");
            os.write(input, 0, input.length);
        }

        // JSON 응답 받기
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;

        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        String jsonResponse = sb.toString();

        // JSON 파싱
        ObjectMapper responseMapper = new ObjectMapper();
        JsonNode responseJson = responseMapper.readTree(jsonResponse);
        System.out.println(responseJson.toString());
        // JSON에서 필요한 데이터 추출
        JsonNode dataNode = responseJson.get("data");

        if (dataNode != null && dataNode.isArray() && dataNode.size() > 0) {
            String b_stt_cd = dataNode.get(0).get("b_stt_cd").asText();

            if ("01".equals(b_stt_cd)) {
                System.out.println("현재 사업 중인 사업자 번호입니다.");
                return true;
            } else if ("02".equals(b_stt_cd)) {
                System.out.println("휴/폐업한 사업자 번호입니다.");
                return false;
            } else if ("03".equals(b_stt_cd)) {
                System.out.println("등록되지 않은 사업자 번호입니다.");
                return false;
            }
        } else {
            System.out.println("데이터가 없거나 잘못된 형식입니다.");
            return false;
        }

        return false;
    }

//    @PostMapping("/checkRegistrationNumber")
//    public boolean checkRegistrationNumber(@RequestBody String number){
//        // 사업자 등록 번호: 000-00-00000
//        // 앞에 3자리: 국세청 / 세무서별 코드
//        // 2자리: 개인 법인 구분코드
//        // 마지막 4자리: 과세/면세/법인 사업자 등록/지정일자 일련번호
//        // 마지막 1자리: 검증번호
//        String sanitizedNumber = number.replaceAll("-", "");
//
//        if (sanitizedNumber.length() == 10) {
//            // 문자열을 스트림으로 변환 후 숫자로 매핑해서 정수 스트림으로 바꾸고 정수 스트림을 정수 배열로 변환
//            int[] numberMap = sanitizedNumber.chars()
//                    .mapToObj(Character::getNumericValue)
//                    .mapToInt(Integer::intValue)
//                    .toArray();
//
//            int[] keyArr = {1, 3, 7, 1, 3, 7, 1, 3, 5};
//            int chk = 0;
//
//            for (int i = 0; i < keyArr.length; i++) {
//                chk += keyArr[i] * numberMap[i];
//            }
//
//            chk += keyArr[8] * numberMap[8] / 10;
//            return numberMap[9] == (10 - (chk % 10)) % 10;
//        }
//
//        return false;
//    }
}
