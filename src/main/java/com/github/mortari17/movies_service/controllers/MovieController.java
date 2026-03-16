package com.github.mortari17.movies_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @GetMapping()
    public String listMovies() {
        return "O Agente Secreto, Uma Batalha Após a Outra, Bugonia, F1: O Filme, Frankenstein, Hamnet, Pecadores, Marty Supreme, Valor Sentimental, Sonhos de Trem";
    }

    @GetMapping("/best")
    public String getBestMovie() {
        return "Uma Batalha Após a Outra";
    }
}