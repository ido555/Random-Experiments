import java.util.ArrayList;

public class School {
	ArrayList<Classroom> classRooms;

	public School(ArrayList<Classroom> classRooms) {
		this.classRooms = classRooms;
	}

	public ArrayList<Classroom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(ArrayList<Classroom> classRooms) {
		this.classRooms = classRooms;
	}

	@Override
	public String toString() {
		return "School [classRooms=" + classRooms + "]";
	}
	

}
