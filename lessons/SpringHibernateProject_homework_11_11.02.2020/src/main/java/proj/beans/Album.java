package proj.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "albums")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment per table
	private int id;
	@Column
	private String title;
	@Column
	private int year;
	@ManyToOne // many albums to one artist
	private Artist artist;
	// empty CTOR DONT FORGET
	public Album() {
	}
	public Album(String title, int year, Artist artist) {
		this.title = title;
		this.year = year;
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", year=" + year + ", artist=" + artist + "]";
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getYear() {
		return year;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
