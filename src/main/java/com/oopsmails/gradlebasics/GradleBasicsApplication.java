package com.oopsmails.gradlebasics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oopsmails.gradlebasics")
@Slf4j
public class GradleBasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleBasicsApplication.class, args);
    }
}
