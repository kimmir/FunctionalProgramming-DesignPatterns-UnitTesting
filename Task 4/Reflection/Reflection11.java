package experiments;

import java.lang.reflect.Method;

public class Reflection11 {

	public static void main(String[] args) {
		
		//Getting the declaring class for each method
		//Results show that regardless of public/private declaration
		//The API has no issue getting the declaring class and the package that it is in
		//Breaks data hiding?
		
		TestingClass testingClass = new TestingClass();
		
		Method[] methods = testingClass.getClass().getDeclaredMethods();
		
		for (Method m : methods) {
			System.out.println("Method Name: " + m.getName());
			System.out.println("Declaring Class: " + m.getDeclaringClass());
			System.out.println("");
		}
	}
}
