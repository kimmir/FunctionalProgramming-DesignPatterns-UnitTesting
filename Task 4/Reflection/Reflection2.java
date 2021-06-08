package experiments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection2 {

	public static void main(String[] args) throws Exception {
		
		//Creating an instance of TestingClass
		//Attempting to square both public and private floats using public and private methods		
		TestingClass testingClass = new TestingClass();
		
		//Float A can be squared as it is a public method
		testingClass.squareA();
		
		//Float A field can be accessed as it is public
		float outputA = testingClass.floatA; 
		
		System.out.println("floatA Squared: " + outputA);
		
		//Float B cannot be squared directly as it is a private method and FloatB cannot be directly accessed as it is private field
		//To square the float, the method needs to be set accessible via the usage of reflection
		//To then get data from field FloatB, the field must be set accessible via reflection
		//The alternative is to use .getFloatB() as it is a public method
		
		//2 Lines below will not work due to the above reasons
		//testingClass.squareB();
		//float outputB = testingClass.floatB;
				
		Method method = testingClass.getClass().getDeclaredMethod("squareB");
		method.setAccessible(true);
		method.invoke(testingClass);
		
		//Float B cannot be accessed via testingClass.floatB -> It is a private field -> Hence is not accessible unless reflection is used
		Field field = testingClass.getClass().getDeclaredField("floatB");
		field.setAccessible(true);		
		float outputB = field.getFloat(testingClass);
		
				
		System.out.println("floatB Squared: " + outputB);
	}
}