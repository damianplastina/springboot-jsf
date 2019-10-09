package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final String template = "Hello, %s!";

    @GetMapping("/ping")
    public String get() {
        return "pong";
    }

    @GetMapping("/hello-world")
    public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return String.format(template, name);
    }
}