package com.oopsmails.gradlebasics.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GradleBasicsController {

    @GetMapping("/")
    public String getGradleBasics() {
        log.info("calling ............... getGradleBasics.");
        return "Hello, from gradle basics project !";
    }
}
