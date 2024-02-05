package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CoachSalih implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Congratulations!! Your all skills are now perfect :::)))";
    }
}
