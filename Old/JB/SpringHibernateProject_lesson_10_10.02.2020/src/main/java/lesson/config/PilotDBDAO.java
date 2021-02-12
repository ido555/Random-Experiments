package lesson.config;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lesson.beans.Pilot;

@Component
@Transactional // revertable - either its done or it isnt
public class PilotDBDAO {
	@Autowired
	private SessionFactory getLocalSessionFactory;

	public void addPilot(Pilot pilot) {
		getLocalSessionFactory.getCurrentSession().save(pilot);
	}

	public void updatePilot(Pilot pilot) {
		getLocalSessionFactory.getCurrentSession().update(pilot);
	}

	public void deletePilot(int id) {
		getLocalSessionFactory.getCurrentSession().delete(getOnePilot(id));
	}

	public Pilot getOnePilot(int id) {
		return getLocalSessionFactory.getCurrentSession().get(Pilot.class, id);
	}

	public List<Pilot> getAllPilots() {
		TypedQuery<Pilot> query = getLocalSessionFactory.getCurrentSession().createQuery("FROM Pilot", Pilot.class);
		return query.getResultList();
	}
}
