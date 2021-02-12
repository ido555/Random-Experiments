package big_project_phase1_partial_rewrite;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// regular java attempt
		try (AnnotationConfigApplicationContext ctx // the Spring "sandbox" within regular Java. Singleton
				= new AnnotationConfigApplicationContext(SpringConfig.class)) {
			CompanyDBDAO compDB = ctx.getBean(CompanyDBDAO.class);
			ArrayList<Company> comps = compDB.getAllCompanies();
			for (Company company : comps) {
				System.out.println(company);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
