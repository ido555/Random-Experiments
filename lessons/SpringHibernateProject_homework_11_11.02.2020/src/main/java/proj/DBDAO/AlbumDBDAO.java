package proj.DBDAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/* In layman terms, a Component is responsible for some operations */
/* the Repository annotation indicates that the class deals with CRUD operations,
 *  usually it’s used with DAO implementations that deal with database tables.*/

import proj.beans.Album;

/* Spring uses Components for DI(dependency injections - Reflections)*/
@Component
//@Repository
@Transactional // revert-able
public class AlbumDBDAO {
	@Autowired
	private SessionFactory LocalSesh; // Hibernate SessionFactory not java
	// LocalSesh.getCurrentSession() - kind of like opening Connection - changing DB stuff - closing Connection. it does that by itself

	public void addAlbum(Album album) {
		LocalSesh.getCurrentSession().save(album);
	}

	public void updateAlbum(Album album) {
		LocalSesh.getCurrentSession().update(album);
	}

	public void deleteAlbum(int id) {
		LocalSesh.getCurrentSession().delete(getOneAlbum(id));
	}

	public Album getOneAlbum(int id) {
		return LocalSesh.getCurrentSession().get(Album.class, id);
	}

	public List<Album> getAllAlbums() {
		TypedQuery<Album> query = LocalSesh.getCurrentSession().createQuery("FROM Album", Album.class);
		return query.getResultList();
	}
}
