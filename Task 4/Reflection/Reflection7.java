package experiments;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection7 {

	public static void main(String[] args) throws Exception {
		
		//This reflection will build upon the last reflection
		//Will specifically look at using private methods & fields after being set as accessible
		//Specifically looking at the floats
		//Strings will be the next reflection
		
		TestingClass testingClass = new TestingClass();
		
		//Private Methods
		//squareB, setFloatA
		//Private Field
		//floatB
		
		//To get the private method this main function must throw an exception
		//Otherwise it will not work
		Method method = testingClass.getClass().getDeclaredMethod("squareB");
		method.setAccessible(true);
		
		method.invoke(testingClass);
		//Unable to directly access floatB as it is not accessible but have to use the public method instead
		System.out.println("(Uses public method to return a private field) Field Access == False: 7.0^2 is: "+ testingClass.getFloatB()); 
		
		//Getting the field and setting it as accessible to see if it can be accessed directly
		Field field = testingClass.getClass().getDeclaredField("floatB");
		field.setAccessible(true);
		//Does not allow direct access via using testingClass.getValue or something of that sort
		//Must return it to a field locally in the reflection
		float returnFloat = field.getFloat(testingClass); 
		
		System.out.println("Field Access == True: 7.0^2 is: " + returnFloat);		
		System.out.println("-----------------------------------------");
		
		//This method is private however it manipulates a public field
		//Must give it the parameter type to help it identify the correct method
		//Otherwise it will give a NoSuchMethodException
		method = testingClass.getClass().getDeclaredMethod("setFloatA",float.class); 
		method.setAccessible(true);
		
		method.invoke(testingClass, 10f);
		System.out.println("setFloatA Result: " + testingClass.floatA); //Unlike floatB this can be directly accessed as it is public
		
		//Conclusion: Shows that the rules of encapsulation/data hiding can be bent/broken for the float related methods/fields
		
	}
}
