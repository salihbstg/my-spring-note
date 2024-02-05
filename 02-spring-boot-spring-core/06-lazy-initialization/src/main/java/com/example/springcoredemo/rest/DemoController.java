package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach salih;
    private Coach football;
    private Coach cricket;
    private Coach tennis;
    @Lazy
    @Autowired
    public void setFootball(@Qualifier("footballCoach") Coach newFootball) {
        this.football = newFootball;

    }
    @Lazy
    @Autowired
    public void setSalih(@Qualifier("coachSalih") Coach newSalih) {
        this.salih = newSalih;
    }

    @Lazy
    @Autowired
    public void setTennis(@Qualifier("tennisCoach") Coach newTennis) {
        this.tennis = newTennis;
    }

    @Lazy
    @Autowired
    public void setCricket(@Qualifier("cricketCoach") Coach newCricket) {
        this.cricket = newCricket;
    }
    
    @GetMapping("/coachsalih")
    public String coachSalih() {
        return salih.getDailyWorkOut();
    }


    @GetMapping("/football")
    public String football() {
        return football.getDailyWorkOut();
    }

    @GetMapping("/tennis")
    public String tennis() {
        return tennis.getDailyWorkOut();
    }

    @GetMapping("/cricket")
    public String cricket() {
        return cricket.getDailyWorkOut();
    }

}
