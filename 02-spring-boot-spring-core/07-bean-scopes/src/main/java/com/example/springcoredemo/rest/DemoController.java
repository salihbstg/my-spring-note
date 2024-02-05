package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach salih;
    private final Coach anotherSalih;

    @Autowired
    public DemoController(Coach salih,Coach anotherSalih) {
        this.salih = salih;
        this.anotherSalih=anotherSalih;
    }

    @GetMapping("/coachsalih")
    public String coachSalih() {
        return "True or false:"+(salih==anotherSalih);
    }

}
