package lesson;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lesson.beans.Pilot;
import lesson.beans.Plane;
import lesson.config.PilotDBDAO;
import lesson.config.SpringConfig;
import lesson.planeDBDAO.PlaneDBDAO;

public class Test {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			PlaneDBDAO planeDBDAO = ctx.getBean(PlaneDBDAO.class);
//			planeDBDAO.addPlane(new Plane("manu1", "model1", 5, true, 1253.123));
//			System.out.println(planeDBDAO.getAllPlanes());
//			Plane plane = planeDBDAO.getOnePlane(4);
//			plane.setModel("AAAAAAAAAAAAAAAAAAAAAA");
//			planeDBDAO.updatePlane(plane);
//			System.out.println();
//			planeDBDAO.deletePlane(2);
			PilotDBDAO pilotDBDAO = ctx.getBean(PilotDBDAO.class);
			Calendar cal = Calendar.getInstance();
			cal.set(1990, Calendar.APRIL, 1);
			Date date = new Date(cal.getTime().getTime());
//			pilotDBDAO.addPilot(new Pilot("jeff2", 15, date, 505050.5, planeDBDAO.getOnePlane(1)));
//			System.out.println(pilotDBDAO.getAllPilots());
//			System.out.println(pilotDBDAO.getOnePilot(1));
//			pilotDBDAO.addPilot(new Pilot("To be deleted", 16, date, 505050.5));
//			System.out.println(pilotDBDAO.getAllPilots());
//			pilotDBDAO.deletePilot(3);
			
//			for (Pilot pi : pilotDBDAO.getAllPilots()) {
//				System.out.println(pi);
//			}
			for (Plane pa : planeDBDAO.getAllPlanes()) {
				System.out.println(pa + "pilots: " + pa.getPilots());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
