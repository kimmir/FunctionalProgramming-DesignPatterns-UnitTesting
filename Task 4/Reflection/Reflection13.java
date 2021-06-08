package experiments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection13 {

	public static void main(String[] args) {
		//After doing some research I have found out that integer modifiers can be converted to string versions
		//Using the method to get modifiers. I want to convert the integer modifiers to strings
		//Will convert methods and fields
		
		TestingClass testingClass = new TestingClass();
		
		Method[] methods = testingClass.getClass().getDeclaredMethods();
		Field[] fields = testingClass.getClass().getDeclaredFields();
		
		for (Method m : methods) {
			System.out.println("Method Name: " + m.getName());
			System.out.println("String Modifiers: " + Modifier.toString(m.getModifiers()));
			System.out.println("");
		}
		
		System.out.println("-----------------------------");
		
		for (Field f : fields) {
			System.out.println("Field Name: " + f.getName());
			System.out.println("String Modifiers:" + Modifier.toString(f.getModifiers()));
			System.out.println("");
		}
	}
}
