package big_project_phase1_partial_rewrite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import big_project_phase1_partial_rewrite.Company;

/**
 * This is the Company DAO (data access object) Implementation for a MySQL
 * database (called a DBDAO)
 */
@Component
@Scope("prototype")
public class CompanyDBDAO implements CompanyDAO {
	@Autowired
	private ConnectionPool pool;

	public boolean isCompanyExists(String email, String password) throws SQLException {
		Connection con = pool.getConnection();
		try { // using try so finally always restores the connection even if something fails
			PreparedStatement ps = con.prepareStatement(
					"SELECT company_id FROM project.companies WHERE companies.email = ? AND companies.password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.first();
		} finally {
			pool.restoreConnection(con);
		}
	}
	
	public Company getCompanyByLogin(String email, String password) throws SQLException, InvalidLoginException {
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT project.companies.company_id, companies.name FROM project.companies WHERE companies.email = ? AND companies.password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.first() == false) {
				throw new InvalidLoginException();
			}
			return new Company(rs.getInt(1), rs.getString(2), email, password);
		} finally {
			pool.restoreConnection(con);
		}
	}

	public void addCompany(Company company) throws SQLException {
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO project.companies(name, password, email) values(?,?,?)");
			ps.setString(1, company.getName());
			ps.setString(2, company.getPassword());
			ps.setString(3, company.getEmail());
			ps.execute();
		} finally {
			pool.restoreConnection(con);
		}
	}

	/**
	 * Update name, password, email by company id
	 */
	public void updateCompany(Company company) throws SQLException {
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE project.companies SET name = ?, password = ?, email = ? WHERE project.companies.company_id = ?");
			ps.setString(1, company.getName());
			ps.setString(2, company.getPassword());
			ps.setString(3, company.getEmail());
			ps.setInt(4, company.getCompanyId());
			ps.execute();
		} finally {
			pool.restoreConnection(con);
		}
	}

	public void deleteCompany(int companyId) throws SQLException {
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM project.companies WHERE project.companies.company_id = ?");
			ps.setInt(1, companyId);
			ps.execute();
		} finally {
			pool.restoreConnection(con);
		}
	}

	public ArrayList<Company> getAllCompanies() throws SQLException {
		ArrayList<Company> companies = new ArrayList<Company>();
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM project.companies");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				companies.add(new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return companies;
		} finally {
			pool.restoreConnection(con);
		}
	}

	public Company getOneCompany(int companyId) throws SQLException, CompanyNotFoundException {
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM project.companies WHERE project.companies.company_id = ?");
			ps.setInt(1, companyId);
			ResultSet rs = ps.executeQuery();

			while (rs.first()) {
				return new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			throw new CompanyNotFoundException();
		} finally {
			pool.restoreConnection(con);
		}
	}

	public boolean isEmailExists(String email) throws SQLException {
		Connection con = pool.getConnection();
		try { // using try so finally always restores the connection even if something fails
			PreparedStatement ps = con
					.prepareStatement("SELECT company_id FROM project.companies WHERE companies.email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			return rs.first();
		} finally {
			pool.restoreConnection(con);
		}
	}

	public boolean isNameExists(String name) throws SQLException {
		Connection con = pool.getConnection();
		try { // using try so finally always restores the connection even if something fails
			PreparedStatement ps = con
					.prepareStatement("SELECT company_id FROM project.companies WHERE companies.name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			return rs.first();
		} finally {
			pool.restoreConnection(con);
		}
	}
}
