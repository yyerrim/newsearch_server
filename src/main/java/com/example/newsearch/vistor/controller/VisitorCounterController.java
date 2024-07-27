package com.example.newsearch.vistor.controller;

import com.example.newsearch.vistor.entity.VisitorCounter;
import com.example.newsearch.vistor.service.VisitorCounterService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update-visitor-count")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class VisitorCounterController {
    @Autowired
    private VisitorCounterService service;

    @PostMapping
    public VisitorCounter updateVisitorCount(HttpSession session) {
        if (session.isNew()) {
            return service.updateVisitorCount();
        }
        return service.getVisitorCount();
    }
}