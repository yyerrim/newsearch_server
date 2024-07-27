package com.example.newsearch.vistor.repository;

import com.example.newsearch.vistor.entity.VisitorCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorCounterRepository extends JpaRepository<VisitorCounter, Long> {
}