package experiments;

import java.lang.reflect.Field;

public class Reflection12 {

	public static void main(String[] args) {
		
		//Getting Field Modifiers
		//Applying the same method of getting modifiers for methods to fields
		//Returns the same integers -> 1 == public, 2 == private
		
		TestingClass testingClass = new TestingClass();
		
		Field[] fields = testingClass.getClass().getDeclaredFields();
		
		for (Field f : fields) {
			System.out.println("Field Name: " + f.getName());
			System.out.println("Field Modifier: " + f.getModifiers());
			System.out.println("");
		}
	}
}
