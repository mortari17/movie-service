package com.github.mortari17.movies_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}