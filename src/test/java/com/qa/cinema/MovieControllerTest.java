package com.qa.cinema;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.qa.cinema.controller.MovieController;
import com.qa.cinema.model.Movie;
import com.qa.cinema.service.MovieService;

public class MovieControllerTest {

	@InjectMocks
	private MovieController controller;

	@Mock
	private MovieService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testEndpointGet() {
		Movie mockMovie = new Movie();
		mockMovie.setId(1l);
		when(service.get(1L)).thenReturn(mockMovie);
		Movie movie = controller.get(1L);
		verify(service).get(1l);
		assertThat(movie.getId(), is(1l));
	}
}
