package testFramework;

import java.util.*;
import unitTesting.TestUnitTest;
import java.lang.reflect.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UnitFramework {
	//Framework for strings and floats unit tests
	//Requirements
	//Simple assertions positive and negative
	//Handles exceptions. Should be handled properly (Incorrect parameter types etc)
	//Complex assertions. Private/Public methods/fields. Should be handled
	//Logging
			
	private static List<String> checks = new ArrayList<String>();
	
	private static int testsAttempted = 0;
	private static int testsCompleted = 0;
	private static int testErrors = 0;
	
	
	private static int checksAttempted = 0;
	private static int checksCompleted = 0;
	private static int checksPassed = 0;
	private static int checksFailed = 0;
	
	private static final Logger logger = LogManager.getLogger(UnitFramework.class);
	
					
	public static void checkFloatEquals(float arg0, float arg1)  //Floats
	{
		//Try Catch -> Throw exception
		//Get parent method data to add to report
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		checksAttempted++;							
		try {
			if (arg0 == arg1)
			{
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " == " + arg1 +" : Passed - Floats are equal");
				checksPassed++;
			} else {
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " == " + arg1 +" : Failed - Floats are not equal");
				checksFailed++;
			}
			checksCompleted++;
		} catch (RuntimeException ex) {
			
		}				
	}
	
	public static void checkFloatNotEquals(float arg0, float arg1) 
	{
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		checksAttempted++;
		try {
			if (arg0 != arg1)
			{
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " != " + arg1 +" : Passed - Floats are not equal");
				checksPassed++;
			} else {
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " != " + arg1 +" : Failed - Floats are equal");
				checksFailed++;
			}
			checksCompleted++;
		} catch (RuntimeException ex) {
			
		}
	}
			
	public static void checkStringEquals(String arg0, String arg1) //Strings
	{
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		checksAttempted++;
		try {
			if (arg0 == arg1)
			{
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " == " + arg1 +" : Passed - Strings are identical");
				checksPassed++;
			} else {
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " == " + arg1 +" : Failed - Strings are not identical");
				checksFailed++;
			}
			checksCompleted++;
		} catch (RuntimeException ex) {
			
		}
	}
	
	public static void checkStringNotEquals(String arg0, String arg1)  //Strings
	{
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		checksAttempted++;		
		try {
			if (arg0 != arg1)
			{
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " != " + arg1 +" : Passed - Strings are not identical");
				checksPassed++;
			} else {
				checks.add(stackTraceElements[2].getMethodName() + "()" + ": " + arg0 + " != " + arg1 +" : Failed - Strings are identical");
				checksFailed++;
				throw new RuntimeException("Intentional");
			}
			checksCompleted++;
		} catch (RuntimeException ex) {
			
		}
	}
	
	public static void report() 
	{
		for (String check: checks) {
			logger.info(check);
			//System.out.println(check);
		}
		logger.info("----------------------------------------------");
		logger.info("Number of unit test methods attempted:" + testsAttempted);
		logger.info("Number of unit test methods completed: " + testsCompleted);
		logger.info("Number of unit test method errors: " + testErrors);
		logger.info("----------------------------------------------");
		logger.info("Number of individual checks attempted: " + checksAttempted);
		logger.info("Number of individual checks completed: " + checksCompleted);
		logger.info("Number of individual checks successful: " + checksPassed);
		logger.info("Number of individual checks failed: " + checksFailed);
	}
	
	private static boolean prefixCheck(String methodName)
	{
		if (methodName.startsWith("test")) {
			return true;
		}
		return false;
	}
	
	public static void runChecks(TestUnitTest c)
	{
		Method[] methods = c.getClass().getDeclaredMethods();
				
		for (Method m : methods) {
			m.setAccessible(true);
			try {
				testsAttempted++;
				if (m.getParameterCount() > 0) { //Getting parameter count
					//Checking for parameter error -> Unit tests cannot have parameters
					logger.error(m.getName() + "()" + ":  Method parameter error. Unit test methods cannot have parameters");					
					testErrors++;
					
				} else if (!prefixCheck(m.getName())) { //Getting method name
					//Checking method name -> Methods must have the correct prefix
					logger.error(m.getName() + "()" + ": Method Prefix Error");				
					testErrors++;
					
				} else {		
					//Will work for public or private methods			
					m.invoke(c);										
					testsCompleted++;					
				} 
				
			} catch (IllegalAccessException e) {
				logger.error("Something went wrong... : " + m.getName() + "()" + " : IllegalAccessException");
				//e.printStackTrace();
			} catch (IllegalArgumentException e) {
				logger.error("Something went wrong... : " + m.getName() + "()" + " : IllegalArgumentException");
				//e.printStackTrace();
			} catch (InvocationTargetException e) {		
				logger.error("Something went wrong... : " + m.getName() + "()" + " : InvocationTargetException");
				//e.printStackTrace();
			}
		}
	}
	
}
