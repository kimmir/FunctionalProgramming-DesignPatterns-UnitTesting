package unitTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import mir008.Domino;
import mir008.GameLogic;
import mir008.Location;
import mir008.Main;

class MainTest {

	

	@Test
	void testResetUserInput() { //gecko() -> resetUserInput()
		
		//55, 98, 64 -> this function is called 3 times in the program
		//Those 3 times use the numbers above
		//The expected output for all of those numbers is -7
		//As it resets user input so they can enter another number until the expected result is given
		//Should test if this is still the case
						
		int $ = 55;
		boolean result1 = -7 == Main.resetUserInput($);
		assertTrue("first function call returns same value as before",result1);
		
		$ = 98;
		boolean result2 = -7 == Main.resetUserInput($);
		assertTrue("second function call returns same value as before",result2);
		
		$ = 64;
		boolean result3 = -7 == Main.resetUserInput($);
		assertTrue("third function call returns same value as before",result3);
	}
								
	@Test
	void testGetUserInputInt() throws Exception
	{
		GameLogic main = new Main();
		Method method = main.getClass().getDeclaredMethod("getUserInputInt", int.class,int.class,int.class);
		method.setAccessible(true);
		
		//Method should only return an integer that is within the confines of the bounds given
		//Will repeat if incorrect values are given
		
		int lowerBound = 3;
		int upperBound = 10; //Values returned should be between 3 and 10
		int count = -3;
		
		int intReturn;
		intReturn = (int) method.invoke(main,lowerBound,upperBound,count);
		
		assertTrue("Method is lower than the upperBound",upperBound >= intReturn);
		assertTrue("Method is higher than the lowerBound",lowerBound <= intReturn);
		
	}
	
	
	

}
