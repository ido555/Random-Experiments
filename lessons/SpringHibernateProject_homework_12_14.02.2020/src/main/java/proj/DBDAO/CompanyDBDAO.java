package proj.DBDAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import proj.beans.Company;

/* In layman terms, a Spring Component is responsible for some operations*/
/* the Repository annotation indicates that the class deals with CRUD operations,
 *  usually it’s used with DAO implementations that deal with database tables.*/

/* Spring uses Components for DI(dependency injections - Reflections)*/
@Component
//@Repository
@Transactional // reverts if something goes wrong
public class CompanyDBDAO {
	@Autowired
	private SessionFactory LocalSesh; // Hibernate SessionFactory not java
	// LocalSesh.getCurrentSession() - kind of like opening Connection - changing DB stuff - closing Connection. it does that by itself

	public void addCompany(Company company) {
		LocalSesh.getCurrentSession().save(company);
	}

	public void updateCompany(Company company) {
		LocalSesh.getCurrentSession().update(company);
	}

	public void deleteCompany(int id) {
		LocalSesh.getCurrentSession().delete(getOneCompany(id));
	}

	public Company getOneCompany(int id) {
		return LocalSesh.getCurrentSession().get(Company.class, id);
	}
	
	public Company getFirstCompanyByEmail(String email) {
		for (Company company: getAllCompanies()) {
			if (company.getEmail().equals(email)) {
				return company;
			}
		}
		return null;
	}
	public List<Company> getAllCompanies() {
		TypedQuery<Company> query = LocalSesh.getCurrentSession().createQuery("FROM Company", Company.class);
		return query.getResultList();
	}
}
