package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CoachSalih implements Coach{
    CoachSalih(){
        System.out.println("In constructor:"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Congratulations!! Your all skills are now perfect :::)))";
    }
}
