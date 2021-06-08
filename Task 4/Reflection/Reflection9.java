package experiments;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection9 {

	public static void main(String[] args) {
		
		//Parameters
		//This reflection gets method parameters
		//Interestingly, public/private methods do not change the results
		//Regardless of public/private declaration, reflection API can get the number of parameters and their types
		//One thing to note is that parameter names do not return the actual parameter name
		//Parameter names are a variation of arg + number, for example arg0,arg1,arg2, etc
		
		TestingClass testingClass = new TestingClass();
		
		Method[] methods = testingClass.getClass().getDeclaredMethods();
		
		for (Method m: methods) {
			System.out.println("Method Name -> " + m.getName());
			System.out.println("Number Of Parameters -> " + m.getParameterCount());
			for (Parameter p : m.getParameters()) {
				System.out.println("Parameter Name: " + p.getName());
				System.out.println("Parameter Type: " + p.getType());
			}
			System.out.println("");
		}		
	}
}
