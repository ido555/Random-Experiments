package proj.tests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import proj.DBDAO.AlbumDBDAO;
import proj.DBDAO.ArtistDBDAO;
import proj.beans.Album;
import proj.beans.Artist;
import proj.config.SpringConfig;

public class Test {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			Artist artist = new Artist("jeff123", "kazakhsAAtan", new ArrayList<Album>());
			Artist artist2 = new Artist("321ffej", "kazakhsBBtan", new ArrayList<Album>());
			AlbumDBDAO albumDBDAO = ctx.getBean(AlbumDBDAO.class);
			ArtistDBDAO artistDBDAO = ctx.getBean(ArtistDBDAO.class);
			artistDBDAO.addArtist(artist);
			artistDBDAO.addArtist(artist2);
			Album album = new Album("title1231", 123554, artistDBDAO.getOneArtist(1));
			Album album2 = new Album("titl123e1231", 111, artistDBDAO.getOneArtist(2));
			albumDBDAO.addAlbum(album);
			albumDBDAO.addAlbum(album2);
			System.out.println(artistDBDAO.getOneArtist(1) + " " + artistDBDAO.getOneArtist(1).getAlbums());
			System.out.println(artistDBDAO.getOneArtist(2) + " " + artistDBDAO.getOneArtist(2).getAlbums());
//			albumDBDAO.deleteAlbum(3);
		}
	}
}
