package com.example.newsearch.vistor.controller;

import com.example.newsearch.vistor.entity.Visitor;
import com.example.newsearch.vistor.service.VisitorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@CrossOrigin
public class VisitorController {
    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public Visitor addVisitor(HttpSession session) {
        String sessionId = session.getId();
        if (session.getAttribute("VISITED") == null) {
            session.setAttribute("VISITED", true);
            return visitorService.incrementVisitorCount(sessionId);
        }
        return null; // 이미 방문한 세션은 null 반환
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("/today")
    public Visitor getTodayVisitor() {
        return visitorService.getTodayVisitor();
    }
}