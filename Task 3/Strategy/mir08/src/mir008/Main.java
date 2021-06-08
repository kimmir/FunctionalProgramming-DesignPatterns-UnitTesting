package mir008;
import java.awt.Dimension;
import java.io.*;
import java.net.InetAddress;
import java.text.DateFormat;
import java.util.*;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * If lost and subsequently found please inform K dot A dot Buckley at wlv.ac.uk
 * 
 * @author Kevan Buckley, maintained by Kim Michael Mir
 * @version 3.3, 2021
 */

public class Main extends GameLogic {
			 
	  Context context = new Context(new Algorithms());
	 	 	  
	  public void run() {
		  IOLibrary io = new IOLibrary();
		  int x = -9;
		  while (x != 0)
		  {
			  System.out.println();
			  System.out.println("Autoplay or Non-Autoplay?");
			  System.out.println("1) Autoplay");
			  System.out.println("2) Non-Autoplay");
			  System.out.println("3) Exit");
			  
			  x = -9;
			  while (x == -9) {
			        try {
			          String s1 = io.getString();
			          x = Integer.parseInt(s1);
			        } catch (Exception e) {
			          x = -9;
			        }
			  }
			  
			  switch(x) {
			  case 1:
				  context.AutoPlay();
				  break;
				  
			  case 2:
				  context.NonAutoPlay();
				  break;
				  
			  case 3:
				  System.out.println("Exiting..");
				  System.exit(0);			  	
			  }
		  }
		  
	  }
	  	  
	  public static void main(String[] args) {
	    new Main().run();
	  }
}
