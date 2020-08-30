package big_project.DAOs;

import java.sql.SQLException;
import java.util.ArrayList;

import big_project.beans.Company;
/**
 * This DAO (data access object) outlines
 * all the CRUD (create, read, update, delete) methods needed for 
 * the project
 * */
public interface CompanyDAO {
	boolean isCompanyExists(String email, String password) throws SQLException; // read
	ArrayList<Company> getAllCompanies() throws SQLException; // read
	Company getOneCompany(int companyId) throws SQLException, CompanyNotFoundException; // read
	void addCompany(Company company) throws SQLException; // create
	void updateCompany(Company company) throws SQLException; // update
	void deleteCompany(int companyId) throws SQLException; // delete
}
