package com.example.newsearch.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NewsController {

//    @Value("${newsapi.key}")
//    private String apiKey;

    @GetMapping("/news")
    public ResponseEntity<Map> getNews(
            @RequestParam(defaultValue = "all") String category) {

        RestTemplate restTemplate = new RestTemplate();

        // 요청 URL 설정
        String cate = category.equals("all") ? "" : "&category=" + category;
        String url = "https://newsapi.org/v2/top-headlines?country=kr" + cate + "&apiKey=3edbe8fb44eb4142988957f180c08ef1";

        // 요청 보내기
        ResponseEntity<Map> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                Map.class);

        return response;
    }
}