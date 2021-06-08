package experiments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection5 {
	
	public static void main(String[] args) {
		
		//Rather than using .getMethods() & .getFields()
		//Using getDeclaredMethods() & getDeclatedFields()
		
		//The first 2 methods would only return public information
		//Now seeing the results of using the second method instead
		//Is the data still hidden after the usage of the methods
		
		TestingClass testingClass = new TestingClass();
		
		Method[] methods = testingClass.getClass().getDeclaredMethods();
		Field[] fields = testingClass.getClass().getDeclaredFields();
		
		for (Method m : methods) {
			System.out.println("Name: " + m.getName() + " | Type: " + m.getReturnType());
		}
		
		System.out.println("----------------------------");
		
		for (Field f : fields) {
			System.out.println("Name: " + f.getName() + " | Type: " + f.getType());
			
			if (f.getType() == float.class) { //Testing if the value can be obtained (it can't as it is private)
				//System.out.println(f.getFloat(testingClass));
			}
			
		}
		
		// .getDeclaredMethods() & .getDeclaredFields() allows you to see public and private methods/fields.
		// Accessing private fields to see the values is unavailable
		// For floats the .getFloat() is there but cannot be used on a private field
		// For Strings there is no such method, probably due to that it is not a primitive data type unlike floats
		// Conclusion: Data hiding is still strong
		
	}

}
