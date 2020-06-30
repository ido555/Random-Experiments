package reflection_annotation1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException {
		// 1> use Class.forname()
//			Class class1 = Class.forName("reflection_annotation1.Dessert");

		// 2> use obj.getClass()
		Dessert d1 = new Dessert("cake", 2000);
//		Class class1 = d1.getClass();

		// 1> use ClassName.class
		Class class1 = Dessert.class;

		System.out.println("Dessert Fields:");

		// declared - things not inherited from superclass
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}

		System.out.println("\n=================\nDessert Constructors:");
		Constructor<?>[] constructors = class1.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}

		System.out.println("\n=================\nDessert Methods:");
		Method[] methods = class1.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		System.out.println("\n===============\nDessert Methods with annotation1:");
		// Method[] methods2 = class1.getDeclaredMethods();
		for (Method meth : methods) {
			annotation1 anno = meth.getAnnotation(annotation1.class);
			if (anno != null) {
				System.out.println(meth.toString() + " value= " + anno.value() + ", isRunnable = " + anno.isRunnable());
			}
		}

	}

}
