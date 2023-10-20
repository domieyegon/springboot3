package com.unify.springboot3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class HelloController {


    @GetMapping("/greet")
    public GreetResponse hello(){
        return new GreetResponse(
                "Hello Sir!",
                List.of("Java", "Golang", "JavaScript"),
                new Person("Henry", 38, 90_000)
        );
    }

    record Person(
            String name,
            int age,
            double savings
    ){}

    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ){}
}
