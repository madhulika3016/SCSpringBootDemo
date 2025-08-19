package com.firstspringbootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    //@ResponseBody
    public String hello(){
        return "Hello Welcome to Spring Boot!";
    }


}
