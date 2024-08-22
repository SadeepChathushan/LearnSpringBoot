package com.springboot.study.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @GetMapping(path = "/get-my-text")
    public void getMyText(){
        String myText = "This is my first springboot app";
        System.out.println(myText);

    }

    @GetMapping(path = "/get-my-text-1")
    public String getMyText1(){
        return "this my first app";
    }
}
