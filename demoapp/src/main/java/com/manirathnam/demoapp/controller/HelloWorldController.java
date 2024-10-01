package com.manirathnam.demoapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/helloapi")
public class HelloWorldController {


    @GetMapping("/msg")
    public String sayHello() {
        return "Message from HELLO REST API ";
    }


    @GetMapping("/messages")
    public List<String> showMessages() {
        return Arrays.asList("WELCOME", "GOOD MORNING", "GOOD EVENING", "GOOD NIGHT");
    }

}
