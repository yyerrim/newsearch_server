package com.example.newsearch.vistor.task;

import com.example.newsearch.vistor.service.VisitorCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VisitorCounterScheduler {

    @Autowired
    private VisitorCounterService service;

    @Scheduled(cron = "0 0 0 * * ?")
    public void resetTodayVisitorCount() {
        service.resetTodayVisitorCount();
        System.out.println("오늘의 방문자 수가 초기화되었습니다.");
    }
}
