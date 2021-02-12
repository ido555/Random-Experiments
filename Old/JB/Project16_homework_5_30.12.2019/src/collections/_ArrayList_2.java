package collections;

import java.util.ArrayList;
import java.util.Random;

public class _ArrayList_2 {
	public static void main(String[] args) {
		ArrayList<Geolocation> geoLocs = new ArrayList<Geolocation>();
		Random rand = new Random();

		for (int i = 0; i < 10; i++) {
			Geolocation geoLoc = new Geolocation(rand.nextDouble() * 20, rand.nextDouble() * 20);
			geoLocs.add(geoLoc);
		}
		System.out.println(geoLocs.size() + " locations " + geoLocs);

		for (int i = 0; i < geoLocs.size(); i++) {
			if (geoLocs.get(i).getLongitude() > 10.0) {
				geoLocs.remove(i);
			}
		}
		System.out.println(geoLocs.size() + " locations " + geoLocs);

	}

}
