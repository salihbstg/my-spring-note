package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach cricketCoach;
    private Coach tennisCoach;
    private Coach footballCoach;
    private final Coach salih;

    @Autowired
    public DemoController(@Qualifier("coachSalih")Coach newSalih){
        this.salih=newSalih;
    }

    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach crickecCoach, @Qualifier("tennisCoach") Coach tennisCoach, @Qualifier("footballCoach") Coach footballCoach) {
        this.cricketCoach = crickecCoach;
        this.tennisCoach = tennisCoach;
        this.footballCoach=footballCoach;
    }

    @GetMapping("/coachsalih")
    public String coachSalih(){
        return salih.getDailyWorkOut();
    }
    @GetMapping("/cricketworkout")
    public String cricketTraining() {
        return cricketCoach.getDailyWorkOut();
    }

    @GetMapping("/tennisworkout")
    public String tennisTraining() {
        return tennisCoach.getDailyWorkOut();
    }
    @GetMapping("/footballworkout")
    public String footballTraining(){
        return footballCoach.getDailyWorkOut();
    }
}
