package mir008;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameLogic {

	public List<Domino> _d;
	public List<Domino> _g;
	public int[][] grid = new int[7][8];
	public int[][] gg = new int[7][8];

	public GameLogic() {
		super();
	}

	protected void generateDominoes() { 
	    _d = new LinkedList<Domino>();
	    int count = 0;
	    int x = 0;
	    int y = 0;
	    for (int l = 0; l <= 6; l++) {
	      for (int h = l; h <= 6; h++) {
	        Domino d = new Domino(h, l);
	        _d.add(d);
	        d.place(x, y, x + 1, y);
	        count++;
	        x += 2;
	        if (x > 6) {
	          x = 0;
	          y++;
	        }
	      }
	    }
	    errorMessage(count); //Extracted method   
	  }

	protected void generateGuesses() { 
	    _g = new LinkedList<Domino>();
	    int count = 0;
	    int x = 0;
	    int y = 0;
	    for (int l = 0; l <= 6; l++) {
	      for (int h = l; h <= 6; h++) {
	        Domino d = new Domino(h, l);
	        _g.add(d);
	        count++;
	      }
	    }
	    errorMessage(count); //Extracted method
	  }

	protected void collateGrid() {
	    for (Domino d : _d) {
	      if (!d.placed) {
	        grid[d.hy][d.hx] = 9;
	        grid[d.ly][d.lx] = 9;
	      } else {
	        grid[d.hy][d.hx] = d.high;
	        grid[d.ly][d.lx] = d.low;
	      }
	    }
	  }

	protected void collateGuessGrid() {
	    for (int r = 0; r < 7; r++) {
	      for (int c = 0; c < 8; c++) {
	        gg[r][c] = 9;
	      }
	    }
	    for (Domino d : _g) {
	      if (d.placed) {
	        gg[d.hy][d.hx] = d.high;
	        gg[d.ly][d.lx] = d.low;
	      }
	    }
	  }

	protected int printGrid(int[][] outputGrid) { //Parametize method grid
	    for (int are = 0; are < 7; are++) {
	      for (int see = 0; see < 8; see++) {
	        if (outputGrid[are][see] != 9) {
	          System.out.printf("%d", outputGrid[are][see]);
	        } else {
	          System.out.print(".");
	        }
	      }
	      System.out.println();
	    }
	    return 11;
	  }

	protected void shuffleDominoesOrder() {
	    List<Domino> shuffled = new LinkedList<Domino>();
	
	    while (_d.size() > 0) {
	      int n = (int) (Math.random() * _d.size());
	      shuffled.add(_d.get(n));
	      _d.remove(n);
	    }
	
	    _d = shuffled;
	  }

	protected void invertSomeDominoes() {
	    for (Domino d : _d) {
	      if (Math.random() > 0.5) {
	        d.invert();
	      }
	    }
	  }

	protected void placeDominoes() {
	    int x = 0;
	    int y = 0;
	    int count = 0;
	    for (Domino d : _d) {
	      count++;
	      d.place(x, y, x + 1, y);
	      x += 2;
	      if (x > 6) {
	        x = 0;
	        y++;
	      }
	    }
	    errorMessage(count); //Extracted method
	  }

	protected void rotateDominoes() {
	    // for (Domino d : dominoes) {
	    // if (Math.random() > 0.5) {
	    // System.out.println("rotating " + d);
	    // }
	    // }
	    for (int x = 0; x < 7; x++) {
	      for (int y = 0; y < 6; y++) {
	
	        tryToRotateDominoAt(x, y);
	      }
	    }
	  }

	private void tryToRotateDominoAt(int x, int y) { //Duplicate code -> Extract method
	    Domino d = findDominoOrGuessAt(x, y, _d);
	    if (thisIsTopLeftOfDomino(x, y, d)) {
	      if (d.isHighYEqualToLowY()) {
	    	  
	        boolean weFancyARotation = Math.random() < 0.5;
	        if (weFancyARotation) {
	          if (theCellBelowIsTopLeftOfHorizontalDomino(x, y)) {
	            Domino e = findDominoOrGuessAt(x, y + 1, _d);
	            
	            tryToRotateDominoChanges(d,e,1,0,x,y);
	           
	          }
	        }
	        
	      } else {
	    	  
	        boolean weFancyARotation = Math.random() < 0.5;
	        if (weFancyARotation) {
	          if (theCellToTheRightIsTopLeftOfVerticalDomino(x, y)) {
	            Domino e = findDominoOrGuessAt(x + 1, y, _d);
	            
	            tryToRotateDominoChanges(d,e,0,1,x,y);
	                       
	          }
	        }
	      }
	    }
	  }

	private void tryToRotateDominoChanges(Domino d, Domino e, int a, int b, int x,
			int y) {
				  e.hx = x;
			      e.lx = x + b;
			      d.hx = x + a;
			      d.lx = x + a + b;
			      e.ly = y + a + b;
			      e.hy = y + b;
			      d.ly = y + a;
			      d.hy = y;
			  }

	private boolean theCellToTheRightIsTopLeftOfVerticalDomino(int x, int y) {
	    Domino e = findDominoOrGuessAt(x + 1, y, _d);
	    return thisIsTopLeftOfDomino(x + 1, y, e) && !e.isHighYEqualToLowY();
	  }

	private boolean theCellBelowIsTopLeftOfHorizontalDomino(int x, int y) {
	    Domino e = findDominoOrGuessAt(x, y + 1, _d);
	    return thisIsTopLeftOfDomino(x, y + 1, e) && e.isHighYEqualToLowY();
	  }

	private boolean thisIsTopLeftOfDomino(int x, int y, Domino d) {
	    return (x == Math.min(d.lx, d.hx)) && (y == Math.min(d.ly, d.hy));
	  }

	protected Domino findDominoOrGuessAt(int x, int y, List<Domino> dominoOrGuess) { //Parametize method 
	    for (Domino d : dominoOrGuess) {
	      if ((d.lx == x && d.ly == y) || (d.hx == x && d.hy == y)) {
	        return d;
	      }
	    }
	    return null;
	  }

	protected Domino findDominoOrGuessByLH(int x, int y, List<Domino> dominoOrGuess) { //Parametize method 
	    for (Domino d : dominoOrGuess) {
	      if ((d.low == x && d.high == y) || (d.high == x && d.low == y)) {
	        return d;
	      }
	    }
	    return null;
	  }

	protected void printDominoesOrGuess(List<Domino> dominoOrGuess) { //Parametize method 
	    for (Domino d : dominoOrGuess) {
	      System.out.println(d);
	    }
	  }

	protected void findAllPossiblitiesOrCertainty(HashMap<Domino, List<Location>> map) { //Extracted method
	  
		  for (int r = 0; r < 6; r++) {
	          for (int c = 0; c < 7; c++) {
	            Domino hd = findDominoOrGuessByLH(grid[r][c], grid[r][c + 1], _g);
	            Domino vd = findDominoOrGuessByLH(grid[r][c], grid[r + 1][c], _g);
	            List<Location> l = map.get(hd);
	            if (l == null) {
	              l = new LinkedList<Location>();
	              map.put(hd, l);
	            }
	            l.add(new Location(r, c));
	            l = map.get(vd);
	            if (l == null) {
	              l = new LinkedList<Location>();
	              map.put(vd, l);
	            }
	            l.add(new Location(r, c));
	          }
	        }
		  
	  }

	private void errorMessage(int count) { //Extracted method
		  if (count != 28) {
		      System.out.println("something went wrong generating dominoes"); 
		      System.exit(0);
		    }
	  }

}