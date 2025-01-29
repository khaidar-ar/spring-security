package com.trial.spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        log.info("request from root");
        return "main.html";
    }

    @PostMapping("/test")
    @CrossOrigin("http://localhost:8080")
    @ResponseBody
    public String java() {
        log.info("request from test");
        return "test endpoint";
    }

}
