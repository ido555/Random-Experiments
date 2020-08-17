package lesson.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // tell hibernate to map this entity to an SQL table
@Table(name = "planes") // optional - actual table name instead of default which is the class name
public class Plane {
	@Id // mark this as PK for Hibernate
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment // AI per table
	private int planeId;
	@Column(nullable = false)
	private String manufacturer;
	@Column(nullable = false)
	private String model;
	@Column
	private int numberOfSeats;
	@Column
	private boolean hasMultimedia;
	@Column
	private double topSpeed;
	@OneToMany(mappedBy = "plane", fetch = FetchType.EAGER) // one plane to many pilots
	private List<Pilot> pilots;

	public Plane() {
		// used by Hibernate. DO NOT FORGET TO ADD
		// without this - everything will work but SELECT
	}

	public Plane(String manufacturer, String model, int numberOfSeats, boolean hasMultimedia, double topSpeed) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.numberOfSeats = numberOfSeats;
		this.hasMultimedia = hasMultimedia;
		this.topSpeed = topSpeed;
	}

	@Override
	public String toString() {
		return "Plane [planeId=" + planeId + ", manufacturer=" + manufacturer + ", model=" + model + ", numberOfSeats="
				+ numberOfSeats + ", hasMultimedia=" + hasMultimedia + ", topSpeed=" + topSpeed +"]";
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public boolean isHasMultimedia() {
		return hasMultimedia;
	}

	public void setHasMultimedia(boolean hasMultimedia) {
		this.hasMultimedia = hasMultimedia;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}

	public int getId() {
		return planeId;
	}
	public List<Pilot> getPilots() {
		return pilots;
	}

}
