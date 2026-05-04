package com.github.mortari17.movies_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.mortari17.movies_service.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
