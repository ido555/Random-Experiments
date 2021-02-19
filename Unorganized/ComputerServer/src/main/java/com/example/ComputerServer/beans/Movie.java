package com.example.ComputerServer.beans;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie{
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Year")
	private String year;
	@JsonProperty("Runtime")
	private String runtime;
	@JsonProperty("Plot")
	private String plot;
	@JsonProperty("Actors")
	private String actors;
	@JsonProperty("Poster")
	private String poster;
	
	public Movie() {}

	public Movie(String title, String year, String runtime, String plot, String actors, String poster) {
		super();
		this.title = title;
		this.year = year;
		this.runtime = runtime;
		this.plot = plot;
		this.actors = actors;
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", runtime=" + runtime + ", plot=" + plot + ", actors="
				+ actors + ", poster=" + poster + "]";
	}
	
	
	
	
	

}
