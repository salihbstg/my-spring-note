package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach swimCoach;


    @Autowired
    public DemoController(@Qualifier("swimCoach")Coach swimCoach) {
        this.swimCoach = swimCoach;
    }


    @GetMapping("/swimcoach")
    public String coachSalih() {
        return swimCoach.getDailyWorkOut();
    }

}
