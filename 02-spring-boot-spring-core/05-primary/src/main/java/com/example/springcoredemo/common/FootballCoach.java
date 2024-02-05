package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "30 shoot training once a two day and 20 passes once a week";
    }
}
