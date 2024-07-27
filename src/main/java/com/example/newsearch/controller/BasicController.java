package com.example.newsearch.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class BasicController {

    private final String naverClientId;
    private final String naverClientSecret;

    @Autowired
    public BasicController(@Qualifier("naverClientId") String naverClientId,
            @Qualifier("naverClientSecret") String naverClientSecret) {
        this.naverClientId = naverClientId;
        this.naverClientSecret = naverClientSecret;
    }

    @GetMapping("/naver/data")
    public ResponseEntity<Map> naverData(
            @RequestParam(defaultValue = "") String search) {

        // RestTemplate 객체 생성
        RestTemplate restTemplate = new RestTemplate();

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);

        // HttpEntity 객체 생성 (헤더와 함께 요청)
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 요청 URL
        String url = "https://openapi.naver.com/v1/search/news?query=" + search + "&display=20&sort=sim";

        // exchange 메소드를 사용하여 GET 요청 보내기
        ResponseEntity<Map> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Map.class);

        // 응답 상태 코드와 본문 출력
        // if (response.getStatusCode() == HttpStatus.OK) {
        //     System.out.println("Response Body: " + response.getBody());
        // } else {
        //     System.out.println("Error: " + response.getStatusCode());
        // }

        return response;
    }

}
