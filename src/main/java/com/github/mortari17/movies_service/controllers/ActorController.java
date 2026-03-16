package com.github.mortari17.movies_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @GetMapping("/best")
    public String getBestActor() {
        return "Michael B. Jordan";
    }
}