package unitTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import mir008.Domino;
import mir008.GameLogic;
import mir008.Location;
import mir008.Main;

class GameLogicTest {

	@Test
	void testPrintGrid() throws Exception { //pg() -> printGrid()
		
		//printGrid() uses main.grid[7][8] int array
		//It iterates and prints the grid to console
		//When done it returns 11
		//Should know if it works if 11 is returned as it says it will as well as if grid is printed in console
		
		GameLogic gameLogic = new GameLogic();
		
		//Parametized methods means this function now uses grid and gg
		//So both must be tested
		
		int[][] grid = new int[7][8];
		int[][] gg = new int[7][8];
		
		for (int are = 0; are < 7; are++) {
		      for (int see = 0; see < 8; see++) { //In console the grid will be printed as rows of 3's
		    	  //main.grid[are][see] = 3;
		    	  grid[are][see] = 3;
		      }		        
		}
		
		for (int are = 0; are < 7; are++) {
		      for (int see = 0; see < 8; see++) { //In console the grid will be printed as rows of 6's
		    	  //main.gg[are][see] = 6;
		    	  gg[are][see] = 6;
		      }		        
		}
		
		Method method = gameLogic.getClass().getDeclaredMethod("printGrid",int[][].class); 				
		method.setAccessible(true);	//Setting as accessible	
		
		//---------------------------------------------------------
		
		//Testing when grid is passed 
		
		boolean result = 11 == (int) method.invoke(gameLogic,grid);		
		assertTrue("11 has been outputted",result); //Checking if the function correctly returns 11
				
		boolean failureResult = 5 == (int) method.invoke(gameLogic,grid);
		assertFalse("Result is not equal to test value",failureResult); //Checking what happens if return value is not compared to 11
		
		//----------------------------------------------------------
		
		//Testing when gg is passed
		
		result = 11 == (int) method.invoke(gameLogic,gg);		
		assertTrue("11 has been outputted",result); //Checking if the function correctly returns 11
				
		failureResult = 5 == (int) method.invoke(gameLogic,gg);
		assertFalse("Result is not equal to test value",failureResult); //Checking what happens if return value is not compared to 11
				
		//Grid is correctly printed
		//Everything works in this test		
	}
	
	@Test
	void testFindDominoOrGuessAt() throws Exception //findDominoAt() -> renamed to findDominoOrGuessAt()
	{
		//The purpose of this function is to find a domino or guess based on the x/y coordinates given
		//Takes 2 int's x & y as well as a List<Domino>
		//It is a private method so it needs to be declared accessible
		
		//This is the code of the method
		/*
		 for (Domino d : dominoOrGuess) {
      		if ((d.lx == x && d.ly == y) || (d.hx == x && d.hy == y)) {
        		return d;
      		}
    	}
    	return null;
		*/
		
		//if in the list domino.lx and domino.ly or domino.hx and domino.hy -> Equal to x or y parameters
		//It should return the domino
		//Otherwise should return null
		
		//List<Domino> myList = new List();
		
		GameLogic gameLogic = new GameLogic();						
		Method method = gameLogic.getClass().getDeclaredMethod("findDominoOrGuessAt",int.class,int.class,java.util.List.class); 						
		method.setAccessible(true);	//Setting as accessible	
		
		Domino domino = new Domino(1,5);
		List<Domino> _d = new LinkedList<Domino>();
		
		domino.lx = 5;
		domino.ly = 10;		
		domino.hx = 3;
		domino.hy = 7;		
		domino.high = 1;
		domino.low = 1;		
		domino.placed = true;
				
		_d.add(domino);
							
		//Method giving x and y of 5,5 so it should return null as no dominos match
		Domino returnFalse = (Domino) method.invoke(gameLogic, 5,5,_d);
		assertNull(returnFalse);
		
		//Method giving x and y of 5,10 so it should be non null as there is a matching .lx and .ly
		Domino returnTrue = (Domino) method.invoke(gameLogic, 5,10,_d);
		assertNotNull(returnTrue);
		
		//Method giving x and y of 3,7 so it should be non null as there is a matching .hx and .hy
		returnTrue = (Domino) method.invoke(gameLogic, 3,7,_d);
		assertNotNull(returnTrue);
	}
	
	@Test
	void testFindDominoOrGuessByLH() throws Exception
	{
		//Looks at x and y and checks if low and high || high and low matches in the list
		GameLogic gameLogic = new GameLogic();
		Method method = gameLogic.getClass().getDeclaredMethod("findDominoOrGuessByLH",int.class,int.class,java.util.List.class); 	
		method.setAccessible(true);
		
		List<Domino> _d = new LinkedList<Domino>();
		
		//First test case returns with a domino as it is present in the list
		Domino domino = new Domino(1,5);
		domino.low = 3;
		domino.high = 6;
		
		_d.add(domino);
		
		Domino returnDomino = (Domino) method.invoke(gameLogic,3,6,_d);
		assertNotNull(returnDomino);
		
		//Second test case returns with domino as it is still present in list as it checks both variations of 7,2 and 2,7
		Domino domino2 = new Domino(1,5);
		domino2.high = 7;
		domino2.low = 2;
		
		_d.add(domino2);
		
		Domino returnDomino2 = (Domino) method.invoke(gameLogic,2,7, _d);
		assertNotNull(returnDomino2);
		
		//Third test case should return null as no such domino is present in the list
		Domino domino3 = new Domino(1,5);
		domino3.low = 1;
		domino3.high = 1;
		
		_d.add(domino3);
		
		Domino returnDomino3 = (Domino) method.invoke(gameLogic,3,3, _d);
		assertNull(returnDomino3);
		
		
	}
	
	@Test
	void testPrintDominoesOrGuess() throws Exception
	{
		
		//Functions purpose is to print the list of dominoes into console
		GameLogic gameLogic = new GameLogic();
		Method method = gameLogic.getClass().getDeclaredMethod("printDominoesOrGuess", java.util.List.class);
		method.setAccessible(true);	//Setting as accessible	
		
		List<Domino> _d = new LinkedList<Domino>();
		
		Domino domino = new Domino(1,1);
		for (int i = 0; i < 5; i++)
		{						
			_d.add(domino);
		}
		
		//Will know if function works correctly if it prints the 5 Dominoes into console
		method.invoke(gameLogic,_d);
		
	}
	
	@Test
	void testTryToRotateDominoAt() throws Exception //This function uses the extracted method
	{
		
		
		GameLogic gameLogic = new GameLogic();
		Method method = gameLogic.getClass().getDeclaredMethod("tryToRotateDominoAt",int.class,int.class);
		method.setAccessible(true);
		
		gameLogic._d = new LinkedList<Domino>();
		Domino domino = new Domino(1,1);
		domino.lx = 5;
		domino.ly = 5;
		gameLogic._d.add(domino);
		
		int x,y;
		x = 5;
		y = 5;
		
		method.invoke(gameLogic,x,y);
		
	}
	
	@Test
	void testFindAllPossiblitiesOrCertainty() throws Exception
	{
		//Iterates through the grid and finds possibilites and certainties in the guest list
		
		GameLogic gameLogic = new GameLogic();
		Method method = gameLogic.getClass().getDeclaredMethod("findAllPossiblitiesOrCertainty", HashMap.class);
		
		gameLogic._g = new LinkedList<Domino>();
		Domino d = new Domino(1,1);
		d.high = 5;
		d.low = 5;
		gameLogic._g.add(d);
		
		gameLogic.grid[5][5] = 5;
		gameLogic.grid[5][6] = 5;
		
		HashMap<Domino, List<Location>> map = new HashMap<Domino, List<Location>>();
		
		method.setAccessible(true);
		
				
		map = (HashMap<Domino, List<Location>> ) method.invoke(gameLogic, map);
		
		
		
		
	}
	
	@Test
	void testErrorMessage() throws Exception 
	{
		GameLogic gameLogic = new GameLogic();
		Method method = gameLogic.getClass().getDeclaredMethod("errorMessage", int.class);
		method.setAccessible(true);
		
		//Should print if any number but 28 is entered
		//"something went wrong generating dominoes"
		
		//FUNCTION DOES WORK HOWEVER, IT HAS A System.Exit
		//IT MAKES IT UNABLE TO SEE OTHER CONSOLE OUTPUTS FROM OTHER FUNCTIONS
		//HENCE method.invoke(main, 10) IS COMMENTED OUT
		
		//method.invoke(main, 10);
		method.invoke(gameLogic, 28);
	}

}
