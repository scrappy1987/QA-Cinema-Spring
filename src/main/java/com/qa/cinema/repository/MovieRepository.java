package com.qa.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.cinema.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
