package com.MakeUC.MakeUC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MakeUcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakeUcApplication.class, args);
    }
    /*
    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    */
}

