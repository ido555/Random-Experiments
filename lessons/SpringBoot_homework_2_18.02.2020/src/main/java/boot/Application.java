package boot;
//@Repository / for DB stuff / speaks with db
//@Service - for BL - business logic - facades
//@Controller - web
//all of these are just @Component
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import boot.DBDAOs.CourseDBDAO;
import boot.DBDAOs.LecturerDBDAO;
import boot.beans.Course;
import boot.beans.Lecturer;
import boot.facades.ManagerFacade;
//  spring.jpa.hibernate.ddl-auto=update ask why create-drop cannot do any ALTER actions on db.
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		try {
			System.out.println("====================================================================================================================");
			ManagerFacade managerFacade = ctx.getBean(ManagerFacade.class);
//			managerFacade.addLecturer(new Lecturer("Italian Chef", "pasta@spaghetti.com"));
//			managerFacade.addLecturer(new Lecturer("Mexican Chef", "taco@burrito.com"));
//			managerFacade.addCourse(new Course("special course", 15, managerFacade.getLecturerById(2)));
//			managerFacade.addCourse(new Course("main course", 100, managerFacade.getLecturerById(1)));
//			managerFacade.addCourse(new Course("side course", 25, managerFacade.getLecturerById(1)));
//			
//			System.out.println(managerFacade.getLecturerById(2) + " " + managerFacade.getLecturerById(2).getCourses());
//			System.out.println(managerFacade.getLecturerById(1) + " " + managerFacade.getLecturerById(1).getCourses());
			System.out.println("====================================================================================================================");
		} catch (Exception e) { // not ideal but this is just to get a point across
			e.printStackTrace();
		}
	}

}
