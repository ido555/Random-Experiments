package reflections2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {

	public static void main(String[] args) {
		Class<Dessert> class1 = Dessert.class;
//		Dessert dessert = new Dessert();
		try {
			@SuppressWarnings("deprecation")
			Dessert myDessert = (Dessert) class1.newInstance(); // deprecated in java 11 but in 8 its fine
			Field caloriesField = class1.getDeclaredField("calories");
			caloriesField.setAccessible(true); // available only for this reflection - ignore private access modifier
			caloriesField.set(myDessert, 12345);
			System.out.println(myDessert);

			Method setPriceMethod = class1.getDeclaredMethod("setPrice2", double.class); // note that double.class is the
																							// primitive double type
			setPriceMethod.setAccessible(true);
			setPriceMethod.invoke(myDessert, 200.5);

			System.out.println(myDessert);
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException
				| NoSuchMethodException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
