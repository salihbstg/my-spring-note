package com.example.springcoredemo.config;

import com.example.springcoredemo.common.Coach;
import com.example.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //@Bean("aquatic") -->>>  Call --->> @Qualifier("aquatic")
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
