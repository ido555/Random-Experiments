package proj.DBDAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import proj.beans.Artist;

/* In layman terms, a Component is responsible for some operations */
/* the Repository annotation indicates that the class deals with CRUD operations,
 *  usually it’s used with DAO implementations that deal with database tables.*/

/* Spring uses Components for DI(dependency injections - Reflections)*/
@Component
//@Repository
@Transactional // revert-able
public class ArtistDBDAO {
	@Autowired
	private SessionFactory LocalSesh; // Hibernate SessionFactory not java
	// LocalSesh.getCurrentSession() - kind of like opening Connection - changing DB
	// stuff
	// - closing Connection. it does that by itself

	public void addArtist(Artist artist) {
		LocalSesh.getCurrentSession().save(artist);
	}

	public void updateArtist(Artist artist) {
		LocalSesh.getCurrentSession().update(artist);
	}

	public void deleteArtist(int id) {
		LocalSesh.getCurrentSession().delete(getOneArtist(id));
	}

	public Artist getOneArtist(int id) {
		return LocalSesh.getCurrentSession().get(Artist.class, id);
	}

	public List<Artist> getAllArtists() {
		TypedQuery<Artist> query = LocalSesh.getCurrentSession().createQuery("FROM Artist", Artist.class);
		return query.getResultList();
	}
}
