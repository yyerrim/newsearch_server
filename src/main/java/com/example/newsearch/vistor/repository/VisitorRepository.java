package com.example.newsearch.vistor.repository;

import com.example.newsearch.vistor.entity.Visitor;
import com.example.newsearch.vistor.entity.VisitorSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Optional<Visitor> findByDate(Date date);
}