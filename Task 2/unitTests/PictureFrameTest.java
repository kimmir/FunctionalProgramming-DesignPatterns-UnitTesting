package unitTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import mir008.PictureFrame;

class PictureFrameTest {

	@Test
	void testDrawDigitDrawString() throws Exception {
		
		PictureFrame pictureFrame = new PictureFrame();
		//Graphics g, int x, int y, int n
				
		Method method = pictureFrame.getClass().getDeclaredMethod("drawDigitDrawString", java.awt.Graphics.class,int.class,int.class,int.class);
		
		//Method method = gameLogic.getClass().getDeclaredMethod("printGrid",int[][].class); 				
		//method.setAccessible(true);	//Setting as accessible	
		
	
		
		//boolean result = 11 == (int) method.invoke(gameLogic,grid);		
		//assertTrue("11 has been outputted",result); //Checking if the function correctly returns 11
	}

}
