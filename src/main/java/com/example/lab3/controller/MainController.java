package com.example.lab3.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {
    @GetMapping
    public String index(){
        return "Hello World!";
    }

    @GetMapping("/persons")
    public List<Person> persons(){
        return Arrays.asList(new Person(1, "sds"), new Person(1, "sds"));
    }

    @GetMapping(value = "/person", produces = {"application/json", "application/xml"})
    public Person person(){
        return new Person(1, "sds");
    }


    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    private class Person {
        Integer id;
        String name;
    }
}
