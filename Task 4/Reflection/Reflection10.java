package experiments;

import java.lang.reflect.Method;

public class Reflection10 {

	public static void main(String[] args) {
		
		//Looking at modifiers of methods
		//Looking at the results, only integer versions of modifiers can be retrieved
		//1 == Public | 2 == Private
		//If unaware of the methods, this API can show you the modifier, providing you know what the integers mean
		
		TestingClass testingClass = new TestingClass();
		
		Method[] methods = testingClass.getClass().getDeclaredMethods();
		
		for (Method m : methods) {
			System.out.println("Method Name: " + m.getName());
			System.out.println("Number Of Modifiers: " + m.getModifiers());
			System.out.println();
		}
		
	}
}
