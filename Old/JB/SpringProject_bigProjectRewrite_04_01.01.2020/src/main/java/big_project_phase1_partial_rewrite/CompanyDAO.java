package big_project_phase1_partial_rewrite;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import big_project_phase1_partial_rewrite.Company;
/**
 * This DAO (data access object) outlines
 * all the CRUD (create, read, update, delete) methods needed for 
 * the project
 * */
@Component
public interface CompanyDAO {
	boolean isCompanyExists(String email, String password) throws SQLException; // read
	boolean isEmailExists(String email) throws SQLException; // read
	boolean isNameExists(String name) throws SQLException; // read
	ArrayList<Company> getAllCompanies() throws SQLException; // read
	Company getOneCompany(int companyId) throws SQLException, CompanyNotFoundException; // read
	void addCompany(Company company) throws SQLException; // create
	void updateCompany(Company company) throws SQLException; // update
	void deleteCompany(int companyId) throws SQLException; // delete
}
