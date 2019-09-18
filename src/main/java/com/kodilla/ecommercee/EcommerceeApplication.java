package com.kodilla.ecommercee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kodilla.ecommercee.repositories")
public class EcommerceeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceeApplication.class, args);
    }
}

