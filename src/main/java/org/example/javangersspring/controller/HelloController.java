package org.example.javangersspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hallo, Welt!";
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return "Hallo, " + name + "!";
    }
}
