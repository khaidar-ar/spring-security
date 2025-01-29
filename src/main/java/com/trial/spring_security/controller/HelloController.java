package com.trial.spring_security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        return "hello " + auth.getName();
    }

    @GetMapping("/java")
    public String java() {
        return "java spring";
    }

    @GetMapping("/all")
    public String all() {
        return "permit all users";
    }

}
