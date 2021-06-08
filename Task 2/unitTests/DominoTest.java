package unitTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import mir008.Domino;

class DominoTest {

	@Test
	void testIsHighYEqualToLowY() { //Renamed Method Unit Test ishl() -> isHighYEqualToLowY()
						
		List<Domino> domino = new LinkedList<Domino>(); //Domino is used in list form in the program so i make it do the same
		Domino insertDomino = new Domino(1,1); 
		domino.add(insertDomino); //Adding test domino
		
		domino.get(0).ly = 5;
		domino.get(0).hy = 5;
						
		assertTrue("lowY and highY are equal",domino.get(0).isHighYEqualToLowY()); //Check if equal
		
		domino.get(0).ly = 5;
		domino.get(0).hy = 10;
		
		assertFalse("lowY and highY are not equal",domino.get(0).isHighYEqualToLowY()); //Check if not equal
		
	}
	

}
