package boot.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import boot.DBDAOs.CourseDBDAO;
import boot.DBDAOs.LecturerDBDAO;
import boot.beans.Course;
import boot.beans.Lecturer;

@Component
public class ManagerFacade {
	@Autowired
	private LecturerDBDAO lecturerDBDAO;
	@Autowired
	private CourseDBDAO courseDBDAO;

	public void addLecturer(Lecturer lecturer) throws Exception {
		for (Lecturer lect : lecturerDBDAO.findAll()) {
			if (lect.getEmail().equals(lecturer.getEmail())) {
				throw new Exception("a lecturer with the same email already exists. new lecturer was not added");
			}
		}
		lecturerDBDAO.save(lecturer);
	}

	public void deleteLecturer(int id) {
//		for (Course course : getLecturerById(id).getCourses()) {
//			if (course.getLecturer().getId() == id) {
//				courseDBDAO.deleteById(course.getNumber());
//			}
//		}
		Lecturer lecturer = lecturerDBDAO.getOne(id);
		lecturer.getCourses().clear(); // but to work needs Cascade
		lecturerDBDAO.save(lecturer);
		lecturerDBDAO.delete(lecturer);
	}
	
	public List<Lecturer> getAllLecturers() {
		return lecturerDBDAO.findAll();
	}

	public Lecturer getLecturerById(int id) {
		return lecturerDBDAO.findById(id).orElse(null);
	}

	public void addCourse(Course course) throws Exception {
		for (Course tempCourse : courseDBDAO.findAll()) {
			if (tempCourse.getName().equals(course.getName())) {
				throw new Exception("a course with the same name already exists. new course was not added");
			}
		}
		courseDBDAO.save(course);
	}

	public void deleteCourse(int number) {
		courseDBDAO.deleteById(number);
	}

	public List<Course> getAllCourses() {
		return courseDBDAO.findAll();
	}

	public Course getCourseByNumber(int number) {
		return courseDBDAO.findById(number).orElse(null);
	}
}
