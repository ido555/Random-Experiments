package oop_Big_Targil_Preperation_for_Matala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		ArrayList<Circuit> circuits = new ArrayList<Circuit>();
		ArrayList<Car> cars = new ArrayList<Car>(); // do this in static method
		Random rand = new Random();
		for (int i = 0; i < 15; i++) { // 15 random cars not the most efficient way to do this dont care right now.
			//  optimize later

			Driver driver1 = new Driver(("Name " + (rand.nextInt(90) + 1)), rand.nextInt(70) + 20);// shortify 
			Driver driver2 = new Driver(("Name " + (rand.nextInt(90) + 1)), rand.nextInt(70) + 20);
			for (int j = 0; j < 4; j++) {	// shortify and fix
				Medal medal1 = new Medal(rand.nextInt(3) + 1, String.valueOf(rand.nextInt(59) + 1960));
				driver1.addMedals(medal1);
				Medal medal2 = new Medal(rand.nextInt(3) + 1, String.valueOf(rand.nextInt(59) + 1960));// shortify
				driver2.addMedals(medal2);
			}
			ArrayList<Driver> drivers = new ArrayList<Driver>();
			drivers.add(driver1);
			drivers.add(driver2);// shortify and beautify
			Car car = new Car(String.valueOf("Brand " + (rand.nextInt(40) + 1)), rand.nextInt(59) + 1960, drivers);
			cars.add(car); // shortify and fix
			// String.valueOf(rand.nextInt(4) + 1)), (rand.nextInt(59) + 1960)
		}
		// circuits.add(Circuit cir1 = new Circuit("circuit 1", "Italy", 10, // CAR
		// ARR)
		/*
		 * for (Car car : cars) { System.out.println(car); System.out.println(); }
		 */

		for (int i = 0; i < 4; i++) {// shortify and beautify
			ArrayList<Car> carsRandom = new ArrayList<Car>();
			for (int j = 0; j < 2; j++) {
				carsRandom.add(cars.get(rand.nextInt(cars.size())));// shortify and beautify
			}
			Circuit circuit = new Circuit(("Circuit Name " + (rand.nextInt(90) + 1)),// shortify and beautify
					("Country " + (rand.nextInt(90) + 1)), (rand.nextInt(26) + 5), carsRandom);
			circuits.add(circuit);
		}
		for (Circuit circuit : circuits) { // shortify 
			System.out.println(circuit);
		}
		int avg = 0, sum = 0;
		for (Circuit circuit : circuits) { //  move down to main foreach loop // shortify 
			avg++;
			sum += circuit.getLength();
		}
		System.out.println(sum / avg);

		avg = 0;
		sum = 0;
		ArrayList<String> firstPlaceDates = new ArrayList<String>();
		int minYear = 2020, count = 0;
		for (Circuit circuit : circuits) {
			int firstPlace = 0, thirdPlace = 0;
			count++;
			for (Car car : circuit.getCars()) {
				Driver tmpDriver1 = car.getDrivers().get(0);
				Driver tmpDriver2 = car.getDrivers().get(1);
				sum += tmpDriver1.getAge();// do this when creating the driver 
				sum += tmpDriver2.getAge();// do this when creating the driver 
				avg += 2;
				if (car.getYear() < minYear) {
					minYear = car.getYear();// do this when creating the car 
				}
				for (Driver drivers : car.getDrivers()) {
					for (Medal medal : drivers.getMedals()) {
						if (medal.getPosition() == 1) {
							firstPlace++;// do this when creating the driver medals 
							firstPlaceDates.add(medal.getDate());
						} else if (medal.getPosition() == 3) {
							thirdPlace++;
						}
					}
				}

			}
			System.out.println("for circuit " + count + ": age average: " + (sum / avg)
					+ ", oldest car production year: " + minYear);
			System.out.println("num of first place: " + firstPlace + ", num of third place: " + thirdPlace);
			System.out.println();
			System.out.println("Dates of first places" + firstPlaceDates);
			System.out.println();
		}
	}

}
