package com.qa.cinema.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cinema.model.Movie;
import com.qa.cinema.service.MovieService;

@RestController
@RequestMapping("api/v1")
public class MovieController {
	
	@Autowired
	private MovieService repository;
	
	
	@RequestMapping(value = "movie", method = RequestMethod.GET)
	public List<Movie> list() {
		return repository.list();
	}

	@RequestMapping(value = "movie", method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie) {
		return repository.create(movie);
	}

	@RequestMapping(value = "movie/{id}", method = RequestMethod.GET)
	public Movie get(@PathVariable Long id) {
		return repository.get(id);
	}

	@RequestMapping(value = "movie/{id}", method = RequestMethod.PUT)
	public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
		Movie existingMovie = repository.get(id);
		BeanUtils.copyProperties(movie, existingMovie);
		return repository.create(existingMovie);
	}

	@RequestMapping(value = "movie/{id}", method = RequestMethod.DELETE)
	public Movie delete(@PathVariable Long id) {
		Movie existingMovie = repository.get(id);
		repository.delete(id);
		return existingMovie;
	}

}
