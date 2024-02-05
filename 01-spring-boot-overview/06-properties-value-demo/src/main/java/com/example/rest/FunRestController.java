package com.example.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${team.name}")
    private String teamName;
    @Value("${anchor.name}")
    private String anchorName;

    @GetMapping(path = "/hello")
    public String sayHello(){
        return "Hello, Worldd!"+teamName+anchorName;
    }

}
