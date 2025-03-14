package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        String hello = "Hello World and welcome to this amazing application that provides insightful AI solutions for Africa's development challenges and opportunities";
        return hello;
    }
}
