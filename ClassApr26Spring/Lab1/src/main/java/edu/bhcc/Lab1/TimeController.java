package edu.bhcc.Lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

/****************************
 *  @Author : Matthew Dobler"
 *  @Date    : 4/26/24"
 *  @File   : TimeController"
 *  @Class   : CSC-"
 *****************************/
@RestController
public class TimeController {

    @GetMapping("/")
    public String index()
    {
        return "It is currently: " + LocalTime.now().toString().substring(0,5) + "I'm just testing some things I am continuing to test some things";
    }
}
