package mir008;
import java.awt.*;
import java.util.List;

import javax.swing.*;
/**
 * @author Kevan Buckley, maintained by Kim Michael Mir
 * @version 3.3, 2021
 */

public class PictureFrame {
  public int[] reroll = null;
  public NonAutoPlay master = null;
  public AutoPlay master2 = null;

  class DominoPanel extends JPanel {
    private static final long serialVersionUID = 4190229282411119364L;

    public void drawGrid(Graphics g) {
      for (int are = 0; are < 7; are++) {
        for (int see = 0; see < 8; see++) {
        	
        	if (master != null) {
        		drawDigitGivenCentre(g, 30 + see * 20, 30 + are * 20, 20,
        	              master.grid[are][see]);
        	} else {
        		 drawDigitGivenCentre(g, 30 + see * 20, 30 + are * 20, 20,
                         master2.grid[are][see]);
        	}
                                       
        }
      }
    }

    public void drawHeadings(Graphics g) {
      for (int are = 0; are < 7; are++) {
        fillDigitGivenCentre(g, 10, 30 + are * 20, 20, are+1);
      }

      for (int see = 0; see < 8; see++) {
        fillDigitGivenCentre(g, 30 + see * 20, 10, 20, see+1);
      }
    }

    public void drawDomino(Graphics g, Domino d) { //Remove assignments to parameter
      if (d.placed) {
    	  
    	Graphics graphicVariable = g;  
    	  
        int y = Math.min(d.ly, d.hy);
        int x = Math.min(d.lx, d.hx);
        int w = Math.abs(d.lx - d.hx) + 1;
        int h = Math.abs(d.ly - d.hy) + 1;
        graphicVariable.setColor(Color.WHITE);
        graphicVariable.fillRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
        graphicVariable.setColor(Color.RED);
        graphicVariable.drawRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
        drawDigitGivenCentre(g, 30 + d.hx * 20, 30 + d.hy * 20, 20, d.high,
            Color.BLUE);
        drawDigitGivenCentre(g, 30 + d.lx * 20, 30 + d.ly * 20, 20, d.low,
            Color.BLUE);
      }
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) { //Extract method | Remove assignments to parameter
      int radius = diameter / 2;
      
      Graphics graphicVariable = g;
      
      graphicVariable.setColor(Color.BLACK);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      drawDigitDrawString(graphicVariable,x,y,n);
      /*
      FontMetrics fm = g.getFontMetrics();
      // convert the string to an integer
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
      */
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n, 
        Color c) { // Extract method | Remove assignment to parameter
    	
      int radius = diameter / 2;
      
      Graphics graphicVariable = g;
      
      graphicVariable.setColor(c);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      drawDigitDrawString(graphicVariable,x,y,n);
      /*
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
      */
    }
    
    void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) { //Extract method | Remove assignment to parameter
      int radius = diameter / 2;
      
      Graphics graphicVariable = g;
      
      graphicVariable.setColor(Color.GREEN);
      graphicVariable.fillOval(x - radius, y - radius, diameter, diameter);
      graphicVariable.setColor(Color.BLACK);
      graphicVariable.drawOval(x - radius, y - radius, diameter, diameter);
      drawDigitDrawString(graphicVariable,x,y,n);
      /*
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
      */
    }
    
    void drawDigitDrawString(Graphics g, int x, int y, int n) //Extracted method | Remove assignment to parameter
    {
    	
    	Graphics graphicVariable = g;
    	
    	FontMetrics fm = g.getFontMetrics();
        String txt = Integer.toString(n);
        graphicVariable.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    protected void paintComponent(Graphics g) { //Consolidate duplicate fragment | Remove assignment to parameter
    	
      Graphics graphicVariable = g;
    	
      graphicVariable.setColor(Color.YELLOW);
      graphicVariable.fillRect(0, 0, getWidth(), getHeight());

      // numbaz(g);
      //
      // if (master!=null && master.orig != null) {
      // drawRoll(g, master.orig);
      // }
      // if (reroll != null) {
      // drawReroll(g, reroll);
      // }
      //
      // drawGrid(g);
      Location l = new Location(1,2);

      //l.drawGridLines(g);
      drawGridLines(graphicVariable);
      drawHeadings(graphicVariable);
      drawGrid(graphicVariable);
      
      if (master != null) {
    	  if (master.mode == 1) {
        	  
    	        master.pf.drawDominoOrGuesses(master, graphicVariable, master._g); //Parameterised Method
    	        
    	      }
    	      if (master.mode == 0) { 
    	    	  
    	        master.pf.drawDominoOrGuesses(master, graphicVariable,master._d); //Parameterised Method
    	        
    	      }
      } else {
    	  if (master2.mode == 1) {
        	  
    	        master2.pf.drawDominoOrGuesses(master2, graphicVariable, master2._g); //Parameterised Method
    	        
    	      }
    	      if (master2.mode == 0) { 
    	    	  
    	        master2.pf.drawDominoOrGuesses(master2, graphicVariable,master2._d); //Parameterised Method
    	        
    	      }
      }
      
      
    }

    public Dimension getPreferredSize() {
      // the application window always prefers to be 202x182
      return new Dimension(202, 182);
    }
  }

  public DominoPanel dp;

  public void PictureFrame(NonAutoPlay sf) {
    master = sf;
    if (dp == null) {
      JFrame f = new JFrame("Abominodo");
      dp = new DominoPanel();
      f.setContentPane(dp);
      f.pack();
      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      f.setVisible(true);
    }
  }
  
  public void PictureFrame2(AutoPlay sf) {
	    master2 = sf;
	    if (dp == null) {
	      JFrame f = new JFrame("Abominodo");
	      dp = new DominoPanel();
	      f.setContentPane(dp);
	      f.pack();
	      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	      f.setVisible(true);
	    }
	  }

  public void reset() {
    // TODO Auto-generated method stub

  }

  public void drawDominoOrGuesses(GameLogic main, Graphics g, List<Domino> dominoOrGuess) { //Parameterised Method | Moved method
	  for (Domino d : dominoOrGuess) {
		  dp.drawDomino(g, d);
	  }
  }

  public void drawGridLines(Graphics g) { //Move Method. Is not used in location. Used in PictureFrame
	    g.setColor(Color.LIGHT_GRAY);
	    for (int tmp = 0; tmp <= 7; tmp++) {
	      g.drawLine(20, 20 + tmp * 20, 180, 20 + tmp * 20);
	    }
	    for (int see = 0; see <= 8; see++) {
	      g.drawLine(20 + see * 20, 20, 20 + see * 20, 160);
	    }
  }


}
