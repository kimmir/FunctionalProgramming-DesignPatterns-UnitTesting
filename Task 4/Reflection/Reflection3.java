package experiments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection3 {

	public static void main(String[] args) {
		
		//Looking at exactly what methods and fields are available and what kind of information can be obtained without using reflection to set anything to be accessible
		//Will show the extent of private fields/methods and how they are hidden
		
		TestingClass testingClass = new TestingClass();
		
		Method[] method = testingClass.getClass().getMethods();
		Field[] field = testingClass.getClass().getFields();
		
		for (Method m : method)
		{
			System.out.printf("Method Name: %s | Method Return Type: %s",m.getName(),m.getReturnType());
			System.out.println();
		}
		
		System.out.println("------------------------");
		
		for (Field f : field)
		{
			System.out.printf("Field Name: %s | Field Type: %s", f.getName(), f.getType());
			System.out.println();
		}
		
		//Results show that the getMethods() & getFields() will only return public methods/fields
		//The methods also return methods that I haven't declared but are included in the java language
		//Shows that the Java data hiding is effective and working as intended
		
	}
}
