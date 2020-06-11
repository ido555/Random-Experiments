package com.example.ComputerServer.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoviesResult {
	@JsonProperty("Search")
	private Movie[] movies;
	private int totalResults;
	
	public MoviesResult() {}
	
	public MoviesResult(Movie[] movies, int totalResults) {
		super();
		this.movies = movies;
		this.totalResults = totalResults;
	}

	public Movie[] getMovies() {
		return movies;
	}

	public void setMovies(Movie[] movies) {
		this.movies = movies;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
	

}
