package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach salih;


    @Autowired
    public DemoController(Coach salih, Coach anotherSalih) {
        this.salih = salih;
    }

    //define your init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff():" + getClass().getSimpleName());
    }

    //define your destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff():" + getClass().getSimpleName());
    }

    @GetMapping("/coachsalih")
    public String coachSalih() {
        return salih.getDailyWorkOut();
    }

}
