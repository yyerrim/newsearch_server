package com.example.newsearch.vistor.service;

import com.example.newsearch.vistor.entity.Visitor;
import com.example.newsearch.vistor.entity.VisitorSession;
import com.example.newsearch.vistor.repository.VisitorRepository;
import com.example.newsearch.vistor.repository.VisitorSessionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;
    private final VisitorSessionRepository visitorSessionRepository;

    public VisitorService(VisitorRepository visitorRepository, VisitorSessionRepository visitorSessionRepository) {
        this.visitorRepository = visitorRepository;
        this.visitorSessionRepository = visitorSessionRepository;
    }

    public Visitor incrementVisitorCount(String sessionId) {
        Date today = new Date();
        Optional<VisitorSession> sessionOpt = visitorSessionRepository.findByDateAndSessionId(today, sessionId);
        if (sessionOpt.isPresent()) {
            return getTodayVisitor();
        }
        visitorSessionRepository.save(new VisitorSession(today, sessionId));

        Optional<Visitor> visitorOpt = visitorRepository.findByDate(today);
        Visitor visitor;
        if (visitorOpt.isPresent()) {
            visitor = visitorOpt.get();
            visitor.setCount(visitor.getCount() + 1);
        } else {
            visitor = new Visitor(today, 1);
        }
        return visitorRepository.save(visitor);
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getTodayVisitor() {
        Date today = new Date();
        return visitorRepository.findByDate(today).orElse(new Visitor(today, 0));
    }
}