package com.example.ComputerServer.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ComputerServer.beans.Movie;
import com.example.ComputerServer.beans.MoviesResult;

@RestController
@RequestMapping("seret")
public class MovieController {

	@GetMapping("{name}")
	public Movie getMovieByName(@PathVariable String name) {
		RestTemplate template = new RestTemplate();
		//Movie m = template.getForObject("http://www.omdbapi.com/?apikey=ec5c7079&t=" + name, 
		//		Movie.class);
		//return m;
		ResponseEntity<Movie> movie = template.getForEntity("http://www.omdbapi.com/?apikey=ec5c7079&t=" + name, Movie.class);
		System.out.println(movie.getBody());
		return movie.getBody();
	}
	
	@GetMapping("search/{name}")
	public Movie[] getMoviesByName(@PathVariable String name){
		RestTemplate template = new RestTemplate();
		MoviesResult result = template.getForObject("http://www.omdbapi.com/?apikey=ec5c7079&s="+name, 
				MoviesResult.class);
		return result.getMovies();
	}
	
}
