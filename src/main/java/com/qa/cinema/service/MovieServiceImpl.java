package com.qa.cinema.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.qa.cinema.model.Movie;
import com.qa.cinema.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	public List<Movie> list() {
		return repository.findAll();
	}
	
	public Movie create(@RequestBody Movie movie) {
		return repository.saveAndFlush(movie);
	}

	public Movie get(@PathVariable Long id) {
		return repository.findOne(id);
	}

	public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
		Movie existingMovie = repository.findOne(id);
		BeanUtils.copyProperties(movie, existingMovie);
		return repository.saveAndFlush(existingMovie);
	}
	
	public Movie delete(@PathVariable Long id) {
		Movie existingMovie = repository.findOne(id);
		repository.delete(existingMovie);
		return existingMovie;
	}

}
