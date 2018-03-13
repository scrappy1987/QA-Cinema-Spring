package com.qa.cinema.service;

import java.util.List;

import com.qa.cinema.model.Movie;

public interface MovieService {

	List<Movie> list();

	Movie create(Movie movie);

	Movie get(Long id);

	Movie update(Long id, Movie movie);

	Movie delete(Long id);

}