package com.example.newsearch.vistor.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VisitorSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String sessionId;

    public VisitorSession() {
    }

    public VisitorSession(Date date, String sessionId) {
        this.date = date;
        this.sessionId = sessionId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}