package unitTesting;

import static testFramework.UnitFramework.*;

import java.lang.reflect.Field;

public class TestUnitTest {
	TestingClass testingClass = new TestingClass("string1","string2", 10f, 25f);
	
	void testConstructorAndAccess() {
		
		//TestingClass testingClass = new TestingClass("string1","string2", 10f, 25f);
		
		checkFloatEquals(testingClass.getFloatA(),10f);
		checkFloatNotEquals(testingClass.getFloatA(),10f);
		
		checkFloatEquals(testingClass.getFloatB(),25f);
		checkFloatNotEquals(testingClass.getFloatB(),25f);
		
		checkStringEquals(testingClass.getStringA(),"string1");
		checkStringNotEquals(testingClass.getStringA(),"string1");
		
		checkStringEquals(testingClass.getStringB(),"string2");
		checkStringNotEquals(testingClass.getStringB(),"string2");
		
	}
	
	void testCompareFloats() {
		//TestingClass testingClass = new TestingClass();
		checkFloatEquals(1f,1f);
		checkFloatNotEquals(2f,1f);
		
		checkFloatEquals(testingClass.floatA,testingClass.getFloatB());
				
		//Field field = testingClass.getClass().getDeclaredField("floatB");
		//field.setAccessible(true);		
		//checkFloatEquals(testingClass.floatA,field.getFloat(testingClass));
		
	}
	
	void testCompareStrings() {
		//TestingClass testingClass = new TestingClass();
		checkStringEquals("Hello","Hello");
		checkStringNotEquals("hello","hello");
	}
	
	void notTestCompare() { //Incorrect method name -> Will not work as prefix is wrong
		//TestingClass testingClass = new TestingClass();
		checkFloatEquals(1f,1f);
	}
	
	void testMethod() { //Forcefully throwing an exception to check if the other tests still run	
		throw new RuntimeException();
	}
	
	private void testParameters(String s) { 
		checkFloatEquals(1f,1f);
		//Testing what happens when a parameter is given. For context parameters are not meant to be given
		//Also this is a private method so this will determine if they can be accessed
		//Running this will return a warning saying that parameters cannot be taken in tests
	}
	
	private void testPrivateMethod() {
		checkFloatEquals(2f,2f);
	}
		
}
