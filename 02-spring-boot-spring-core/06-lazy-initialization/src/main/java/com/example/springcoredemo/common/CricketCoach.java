package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    CricketCoach(){
        System.out.println("In constructor:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
    return "Practice fast bowling for 15 minutes!!!!!!!!!! :~)";
    }
}
