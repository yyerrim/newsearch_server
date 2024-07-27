package com.example.newsearch.vistor.service;


import com.example.newsearch.vistor.entity.VisitorCounter;
import com.example.newsearch.vistor.repository.VisitorCounterRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorCounterService {
    @Autowired
    private VisitorCounterRepository repository;

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            VisitorCounter counter = new VisitorCounter();
            counter.setTodayVisitor(0);
            counter.setTotalVisitor(0);
            repository.save(counter);
        }
    }

    public VisitorCounter updateVisitorCount() {
        VisitorCounter counter = repository.findAll().get(0);
        counter.setTodayVisitor(counter.getTodayVisitor() + 1);
        counter.setTotalVisitor(counter.getTotalVisitor() + 1);
        return repository.save(counter);
    }

    public VisitorCounter getVisitorCount() {
        return repository.findAll().get(0);
    }

    public void resetTodayVisitorCount() {
        VisitorCounter counter = repository.findAll().get(0);
        counter.setTodayVisitor(0);
        repository.save(counter);
    }
}