package com.example.newsearch.vistor.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(unique = true)
    private Date date;

    private int count;

    public Visitor() {
    }

    public Visitor(Date date, int count) {
        this.date = date;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}