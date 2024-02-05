package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach salih;

    @Autowired
    public DemoController(Coach newSalih){
        this.salih=newSalih;
    }

    @GetMapping("/coachsalih")
    public String coachSalih(){
        return salih.getDailyWorkOut();
    }

}
