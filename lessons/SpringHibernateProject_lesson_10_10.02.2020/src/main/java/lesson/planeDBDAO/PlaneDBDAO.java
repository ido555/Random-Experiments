package lesson.planeDBDAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lesson.beans.Plane;

@Component
@Transactional // everything will be wrapped in a Transaction
public class PlaneDBDAO {
	@Autowired
	private SessionFactory getLocalSessionFactory;

	public void addPlane(Plane plane) {
		getLocalSessionFactory.getCurrentSession().save(plane);
		// opens connection does sql stuff closes connection and everything is wrapped
		// in a Transaction
	}

	public void updatePlane(Plane plane) {
		getLocalSessionFactory.getCurrentSession().update(plane);
	}

	public void deletePlane(int id) {
		getLocalSessionFactory.getCurrentSession().delete(getOnePlane(id));
	}

	public Plane getOnePlane(int id) {
		return getLocalSessionFactory.getCurrentSession().get(Plane.class, id);
	}

	public List<Plane> getAllPlanes() {
		TypedQuery<Plane> query = getLocalSessionFactory.getCurrentSession().createQuery("FROM Plane", Plane.class);
		// not SQL but HQL - Hibernate Query Language
		return query.getResultList();
	}
}
