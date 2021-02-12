package proj.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "artists")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment per table
	private int id;
	@Column
	private String name;
	@Column
	private String country;
	@OneToMany(mappedBy = "artist", fetch = FetchType.EAGER) // one artist to many albums
	private List<Album> albums;
	// empty CTOR DONT FORGET
	public Artist() {
	}
	public Artist(String name, String country, List<Album> albums) {
		this.name = name;
		this.country = country;
		this.albums = albums;
	}
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
}
