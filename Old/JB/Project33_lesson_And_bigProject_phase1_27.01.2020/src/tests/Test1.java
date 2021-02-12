package tests;

import java.sql.SQLException;
import big_project.DAOs.CompanyDBDAO;
import big_project.DAOs.CompanyNotFoundException;
import big_project.DAOs.ConnectionPool;
import big_project.beans.Company;

public class Test1 {

	public static void main(String[] args) {
		CompanyDBDAO compDBDAO = new CompanyDBDAO();
//		try {
//			compDBDAO.addCompany(new Company("Google", "google.google.@gmail", "123456"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			compDBDAO.deleteCompany(2);
//		} catch (SQLException e) {
//			// 
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.println(compDBDAO.getAllCompanies());
//		} catch (SQLException e) {
//			// 
//			e.printStackTrace();
//		}
		try {
			System.out.println(compDBDAO.getOneCompany(3));
		} catch (SQLException | CompanyNotFoundException e) { // same handling for both exceptions so multi-catch is better
			e.printStackTrace();
		}
		ConnectionPool.getInstance().closeAllConnections();
	}
}
