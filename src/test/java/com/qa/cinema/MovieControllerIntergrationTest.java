package com.qa.cinema;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.cinema.model.Movie;
import com.qa.cinema.service.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class MovieControllerIntergrationTest {
	
	@Autowired
	private MovieService service;

	@Test
	public void testFindAll() {
		List<Movie> wrecks = service.list();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}

}
