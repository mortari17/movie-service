package com.github.mortari17.movies_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    private Long id;

    @Column(name = "name", length = 100, columnDefinition = "char(100)", nullable = false)
    private String name;

    @Column(name = "birth_year", nullable = true)
    private Integer birthYear;

    @Column(name = "nationality", length = 50, columnDefinition = "char(50)", nullable = true)
    private String nationality;

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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}