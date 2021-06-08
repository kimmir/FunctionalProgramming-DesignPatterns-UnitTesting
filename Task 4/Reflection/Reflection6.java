package experiments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection6 {

	public static void main(String[] args) {
		
		//This reflection is about using and manipulating private methods/fields
		//In previous reflections it was concluded that .getDeclaredMethods() would allow you to view them
		//However could not use them
		//Here I show changing the accessibility state in order to use them in the next reflection
		
		TestingClass testingClass = new TestingClass();
		
		Method[] methods = testingClass.getClass().getDeclaredMethods();
		Field[] fields = testingClass.getClass().getDeclaredFields();
		
		//Showing accessibility of each field/method beforehand
		System.out.println("Accessiblity Before");
		System.out.println("---Methods---");
		for (Method m : methods) {
			System.out.println("Method Name: " + m.getName() + " | Accessible: " + m.isAccessible());
		}
		
		System.out.println("---Fields---");
		
		for (Field f : fields) {
			System.out.println("Field Name: " + f.getName() + " | Accessible: " + f.isAccessible());
		}
		
		//Before changes -> All methods and fields regardless of public/private declaration
		//Have their accessibility set to false
		//This means that public methods/fields have this attribute but it is of no use to it
		//It only becomes relevant if it is something privately declared
						
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.println("Accessiblity After");
		
		for (Method m : methods) {
			m.setAccessible(true);
			System.out.println("Method Name: " + m.getName() + " | Accessible: " + m.isAccessible());
		}
		
		System.out.println("---Fields---");
		
		for (Field f : fields) {
			f.setAccessible(true);
			System.out.println("Field Name: " + f.getName() + " | Accessible: " + f.isAccessible());
		}
		//Have all been set to be accessible
		//Demonstrates that this property of methods/fields can be manipulated
		
		
		
	}
}
