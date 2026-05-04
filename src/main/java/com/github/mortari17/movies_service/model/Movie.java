package com.github.mortari17.movies_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private Long id;

    @Column(name = "name", length = 100, columnDefinition = "char(100)", nullable = false)
    private String name;

    @Column(name = "genre", length = 50, columnDefinition = "char(50)", nullable = false)
    private String genre;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @Column(name = "rating", nullable = true)
    private Double rating;
}