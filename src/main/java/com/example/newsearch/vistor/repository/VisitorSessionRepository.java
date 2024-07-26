package com.example.newsearch.vistor.repository;

import com.example.newsearch.vistor.entity.VisitorSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface VisitorSessionRepository extends JpaRepository<VisitorSession, Long> {
    Optional<VisitorSession> findByDateAndSessionId(Date date, String sessionId);
}