package experiments;

import java.lang.reflect.Method;

public class Reflection8 {

	public static void main(String[] args) throws Exception {
		
		//Looking at the usage of private string related methods/fields
		
		//Private methods
		//setStringA, concatinatePrivateString
		
		//Private fields
		//stringB
		
		TestingClass testingClass = new TestingClass();
		
		//A private method that manipulates a public field
		Method method = testingClass.getClass().getDeclaredMethod("setStringA", String.class);
		method.setAccessible(true); //Will have an IllegalAccessException without setting it accessible
		
		//Invoking the private method
		method.invoke(testingClass, "new string");
		//stringA is public hence it does not need to be set accessible
		System.out.println("StringA: " + testingClass.stringA);
		
		
		method = testingClass.getClass().getDeclaredMethod("concatinatePrivateString", String.class);
		method.setAccessible(true); //Will have an IllegalAccessException without setting it accessible -> Data hiding working as expected
		String returnStr = (String) method.invoke(testingClass, "String1");
		System.out.println("concatinatePrivateString: " + returnStr);
		
		
		
	}
}
