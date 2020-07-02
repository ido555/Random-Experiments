package reflection_excercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import nir.MyClass;

public class Program {

	public static void main(String[] args) {
		Class<MyClass> nir = MyClass.class;

		System.out.println("ctors");
		for (Constructor<?> c : nir.getDeclaredConstructors()) {
			System.out.println(c);
		}
		System.out.println("======================================");
		System.out.println("annotations");
		for (Annotation a : nir.getDeclaredAnnotations()) {
			System.out.println(a);
		}
		System.out.println("======================================");
		System.out.println("methods");
		for (Method m : nir.getDeclaredMethods()) {
			System.out.print("isAccessible: " + m.isAccessible() + "  ");
			System.out.println(m);
		}
		System.out.println("======================================");
		System.out.println("fields");
		for (Field f : nir.getDeclaredFields()) {
			System.out.println(f);
		}
		System.out.println("====================================================================");
		try {
			Class<MyClass> nirClass = MyClass.class;
			MyClass class1 = nirClass.newInstance();
			Method setTitle = nirClass.getDeclaredMethod("setTitle", String.class);
			setTitle.setAccessible(true);
			setTitle.invoke(class1 ,"no title here");
			System.out.println(class1);
			Method fillValues = nirClass.getDeclaredMethod("fillValues");
			fillValues.setAccessible(true);
			fillValues.invoke(class1);
			System.out.println(class1);
			
			
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
