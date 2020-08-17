package big_project.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import big_project.beans.Company;

public class CompanyDBDAO implements CompanyDAO {
	private ConnectionPool pool = ConnectionPool.getInstance();

	@Override
	public boolean isCompanyExists(String email, String password) throws SQLException {
		Connection con = pool.getConnection();
		try { // using try so finally always restores the connection even if something fails
				// use the connection to add a new company to the companies table in DB
			PreparedStatement ps = con.prepareStatement(
					"SELECT company_id FROM project.companies WHERE company.email = ?, company.password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.first();
		} finally {
			pool.restoreConnection(con);
		}
	}

	@Override
	public void addCompany(Company company) throws SQLException {
		Connection con = pool.getConnection();
		try { // using try so finally always restores the connection even if something fails
				// use the connection to add a new company to the companies table in DB
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

	@Override
	public void updateCompany(Company company) throws SQLException {
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE project.companies SET name = ?, password = ?, email = ? WHERE projects.companies.company_id = ?");
			ps.setString(1, company.getName());
			ps.setString(2, company.getPassword());
			ps.setString(3, company.getEmail());
			ps.setInt(4, company.getCompanyId());
			ps.execute();
		} finally {
			pool.restoreConnection(con);
		}
	}

	@Override
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

	@Override
	public ArrayList<Company> getAllCompanies() throws SQLException {
		ArrayList<Company> companies = new ArrayList<Company>();
		Connection con = pool.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM project.companies");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				companies.add(new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} finally {
			pool.restoreConnection(con);
		}
		return companies;
	}

	@Override
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
}
