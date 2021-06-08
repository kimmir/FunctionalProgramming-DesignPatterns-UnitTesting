package mir008;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class AutoPlay extends GameLogic {
	
	private String playerName;
	int mode = -1;
	int cf;
	int score;
	long startTime;

	PictureFrame pf = new PictureFrame();
	
	 public final int ZERO = 0;
	 public final int ONE = 1;
	 public final int TWO = 2;
	 public final int THREE = 3;
	 public final int FOUR = 4;
	 public final int FIVE = 5;
	 public final int SIX = 6;
	 public final int SEVEN = 7;
	 public final int EIGHT = 8;
	 public final int NINE = 9;
	
	public void run()
	{
		IOLibrary io = new IOLibrary(); //Acts as a middleman to IOLibrary. Changed to IOLibrary so it calls the method directly

	    System.out
	        .println("Welcome To Abominodo - The Best Dominoes Puzzle Game in the Universe");
	    System.out.println("Version 2.1 (c), Kevan Buckley, 2014");
//	    System.out.println("Serial number " + Special.getStamp());

	    System.out.println();
	    System.out.println(MultiLingualStringTable.getMessage(0));
	    playerName = "Computer";

	    System.out.printf("%s %s. %s", MultiLingualStringTable.getMessage(1),
	        playerName, MultiLingualStringTable.getMessage(2));

	    try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    int _$_ = -9;
	    while (_$_ != ZERO) {
	      System.out.println();
	      String h1 = "Main menu";
	      String u1 = h1.replaceAll(".", "=");
	      System.out.println(u1);
	      System.out.println(h1);
	      System.out.println(u1);
	      System.out.println("1) Play");	      
	      System.out.println("2) View high scores");
	      System.out.println("3) View rules");	     
	      System.out.println("5) Get inspiration");
	      System.out.println("0) Quit");

	      _$_ = -9;
	      while (_$_ == -9) {
	        try {
	          
	          _$_ = GetRandom(6);
	          System.out.println(_$_);
	        } catch (Exception e) {
	          _$_ = -9;
	        }
	      }
	      
	      try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      switch (_$_) {
	      case 5:
	        int index = (int) (Math.random() * (Chesham.waterbuck.length / 3));
	        String what = Chesham.waterbuck[index * 3];
	        String who = Chesham.waterbuck[1 + index * 3];
	        System.out.printf("%s said \"%s\"", who, what);
	        System.out.println();
	        System.out.println();
	        break;      
	      case 0: {
	        if (_d == null) {
	          System.out.println("It is a shame that you did not want to play");
	        } else {
	          System.out.println("Thankyou for playing");
	        }
	        System.exit(0);
	        break;
	      }
	      case 1: {
	    	  
	        System.out.println();
	        String h4 = "Select difficulty";
	        String u4 = h4.replaceAll(".", "=");
	        System.out.println(u4);
	        System.out.println(h4);
	        System.out.println(u4);
	        System.out.println("1) Simples");
	        System.out.println("2) Not-so-simples");
	        System.out.println("3) Super-duper-shuffled");
	        int c2 = -7;
	        while (!(c2 == ONE || c2 == TWO || c2 == THREE)) {
	          try {
	            c2 = GetRandom(4) + 1;
	          } catch (Exception e) {
	            c2 = -7;
	          }
	        }
	        
	        try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	 
	        generateDominoes();
	        shuffleDominoesOrder(); //moved outside of switch statements
	        placeDominoes();        
	        switch (c2) { //Consolidate duplicate fragment
	        case 1:
	                   
	          // printGrid();
	          break;
	        case 2:
	         
	          rotateDominoes();          
	          // printGrid();
	          break;
	        default:
	          
	          rotateDominoes();
	          rotateDominoes();
	          rotateDominoes();
	          invertSomeDominoes();          
	          break;
	        }
	        collateGrid(); //moved outside of switch statements

	        
	        printGrid(grid); //Parametize method grid
	        generateGuesses();
	        collateGuessGrid();
	        mode = 1;
	        cf = 0;
	        score = 0;
	        startTime = System.currentTimeMillis();
	        pf.PictureFrame2(this);
	        pf.dp.repaint();
	        int c3 = -7;
	        while (c3 != ZERO) {
	          System.out.println();
	          String h5 = "Play menu";
	          String u5 = h5.replaceAll(".", "=");
	          System.out.println(u5);
	          System.out.println(h5);
	          System.out.println(u5);
	          System.out.println("1) Print the grid");
	          System.out.println("2) Print the box");
	          System.out.println("3) Print the dominos");
	          System.out.println("4) Place a domino");
	          System.out.println("5) Unplace a domino");
	          System.out.println("6) Get some assistance");
	          System.out.println("7) Check your score");
	          System.out.println("0) Given up");
	          System.out.println("What do you want to do " + playerName + "?");
	          c3 = 9;
	          // make sure the user enters something valid
	          
	          //Introduce explaining variable
	          boolean isValidInput = false;
	          while (isValidInput == false) {
	            try {
	              c3 = GetRandom(8);
	              isValidInput = true;
	            } catch (Exception e) {
	              c3 = resetUserInput(55);
	            }
	          }
	          
	          try {
	  			TimeUnit.SECONDS.sleep(1);
	  		} catch (InterruptedException e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		}
	          
	          switch (c3) {
	          case 0:

	            break;
	          case 1:
	            printGrid(grid); //Parametize method grid
	            break;
	          case 2:
	            //printGuessGrid(); //Becomes printGrid(gg) //Parametize method gg
	        	printGrid(gg);
	            break;
	          case 3:
	            Collections.sort(_g);
	            printDominoesOrGuess(_g);
	            break;
	          case 4:
	            System.out.println("Where will the top left of the domino be?");
	            System.out.println("Column?");
	            // make sure the user enters something valid
	            int x = GetRandom(9) + 1;
	            while (x < ONE || x > EIGHT) {
	              x = GetRandom(9) + 1;
	            }
	            System.out.println("Row?");
	            int y = resetUserInput(98);
	            while (y < ONE || y > SEVEN) {
	              try {
	                
	                y = GetRandom(8) + 1;
	              } catch (Exception e) {
	                System.out.println("Bad input");
	                y = resetUserInput(64);
	              }
	            }
	            x--;
	            y--;
	            System.out.println("Horizontal or Vertical (H or V)?");
	            boolean horiz;
	            int y2,
	            x2;
	            Location lotion;
	            while ("AVFC" != "BCFC") {
	              int HV = GetRandom(2);
	              String s3;
	              if (HV == 1) {
	            	  s3 = "H";
	              } else {
	            	  s3 = "V"; 
	              }
	              
	              if (s3 != null && s3.toUpperCase().startsWith("H")) {
	                lotion = new Location(x, y, Location.DIRECTION.HORIZONTAL); //Extract method
	                System.out.println("Direction to place is " + lotion.d);
	                horiz = true;
	                x2 = x + 1;
	                y2 = y;
	                break;
	              }
	              if (s3 != null && s3.toUpperCase().startsWith("V")) {
	                horiz = false;
	                lotion = new Location(x, y, Location.DIRECTION.VERTICAL); //Extract method
	                System.out.println("Direction to place is " + lotion.d);
	                x2 = x;
	                y2 = y + 1;
	                break;
	              }
	              System.out.println("Enter H or V");
	            }
	            if (x2 > SEVEN || y2 > SIX) {
	              System.out
	                  .println("Problems placing the domino with that position and direction");
	            } else {
	              // find which domino this could be
	              Domino d = findDominoOrGuessByLH(grid[y][x], grid[y2][x2], _g);
	              if (d == null) {
	                System.out.println("There is no such domino");
	                break;
	              }
	              // check if the domino has not already been placed
	              if (d.placed) {
	                System.out.println("That domino has already been placed :");
	                System.out.println(d);
	                break;
	              }
	              // check guessgrid to make sure the space is vacant
	              if (gg[y][x] != NINE || gg[y2][x2] != NINE) {
	                System.out.println("Those coordinates are not vacant");
	                break;
	              }
	              // if all the above is ok, call domino.place and updateGuessGrid
	              gg[y][x] = grid[y][x];
	              gg[y2][x2] = grid[y2][x2];
	              if (grid[y][x] == d.high && grid[y2][x2] == d.low) {
	                d.place(x, y, x2, y2);
	              } else {
	                d.place(x2, y2, x, y);
	              }
	              score += 1000;
	              collateGuessGrid();
	              pf.dp.repaint();
	            }
	            break;
	          case 5:
	            System.out.println("Enter a position that the domino occupies");
	            
	            System.out.println("Column?");
	            int x13 = -9;
	            x13 = getUserInputInt(ONE,EIGHT,x13); //Extracted method
	            
	            System.out.println("Row?");
	            int y13 = -9;
	            y13 = getUserInputInt(ONE,SEVEN,y13); //Extracted method
	            
	            x13--;
	            y13--;
	            Domino lkj = findDominoOrGuessAt(x13, y13, _g);
	            if (lkj == null) {
	              System.out.println("Couln't find a domino there");
	            } else {
	              lkj.placed = false;
	              gg[lkj.hy][lkj.hx] = 9;
	              gg[lkj.ly][lkj.lx] = 9;
	              score -= 1000;
	              collateGuessGrid();
	              pf.dp.repaint();
	            }
	            break;
	          case 7:
	            System.out.printf("%s your score is %d\n", playerName, score);
	            break;
	          case 6:
	            System.out.println();
	            String h8 = "So you want to cheat, huh?";
	            String u8 = h8.replaceAll(".", "=");
	            System.out.println(u8);
	            System.out.println(h8);
	            System.out.println(u8);
	            System.out.println("1) Find a particular Domino (costs you 500)");
	            System.out.println("2) Which domino is at ... (costs you 500)");
	            System.out.println("3) Find all certainties (costs you 2000)");
	            System.out.println("4) Find all possibilities (costs you 10000)");
	            System.out.println("0) You have changed your mind about cheating");
	            System.out.println("What do you want to do?");
	            
	            int yy = -9;
	            yy = getUserInputInt(ZERO,FOUR,yy); //Extracted method            
	            
	            switch (yy) {
	            case 0:
	              switch (cf) {
	              case 0:
	                System.out.println("Well done");
	                System.out.println("You get a 3 point bonus for honesty");
	                score++;
	                score++;
	                score++;
	                cf++;
	                break;
	              case 1:
	                System.out
	                    .println("So you though you could get the 3 point bonus twice");
	                System.out.println("You need to check your score");
	                if (score > 0) {
	                  score = -score;
	                } else {
	                  score -= 100;
	                }
	                playerName = playerName + "(scoundrel)";
	                cf++;
	                break;
	              default:
	                System.out.println("Some people just don't learn");
	                playerName = playerName.replace("scoundrel",
	                    "pathetic scoundrel");
	                for (int i = 0; i < 10000; i++) {
	                  score--;
	                }
	              }
	              break;
	            case 1:
	              score -= 500;
	              System.out.println("Which domino?");
	              
	              System.out.println("Number on one side?");              
	              int x4 = -9;
	              x4 = getUserInputInt(ZERO,SIX,x4); //Extracted method
	              
	              System.out.println("Number on the other side?");
	              int x5 = -9;
	              x5 = getUserInputInt(ZERO,SIX,x5); //Extracted method
	             
	              Domino dd = findDominoOrGuessByLH(x5, x4, _d);
	              System.out.println(dd);

	              break;
	            case 2:
	              score -= 500;
	              System.out.println("Which location?");
	              
	              System.out.println("Column?");              
	              int x3 = -9;
	              x3 = getUserInputInt(ONE,EIGHT,x3); //Extracted method
	              
	              System.out.println("Row?");
	              int y3 = -9;
	              y3 = getUserInputInt(ONE,SEVEN,y3); //Extracted method
	              
	              x3--;
	              y3--;
	              Domino lkj2 = findDominoOrGuessAt(x3, y3, _d);
	              System.out.println(lkj2);
	              break;
	              
	            case 3: { //Extract method
	            	
	              score -= 2000;
	              HashMap<Domino, List<Location>> map = new HashMap<Domino, List<Location>>();
	              
	              findAllPossiblitiesOrCertainty(map); //Extracted method
	              
	              for (Domino key : map.keySet()) {
	                List<Location> locs = map.get(key);
	                if (locs.size() == 1) {
	                  Location loc = locs.get(0);
	                  System.out.printf("[%d%d]", key.high, key.low);
	                  System.out.println(loc);
	                }
	              }
	              break;
	            }

	            case 4: { //Extract method
	            	
	              score -= 10000;
	              HashMap<Domino, List<Location>> map = new HashMap<Domino, List<Location>>();
	              
	              findAllPossiblitiesOrCertainty(map); //Extracted method
	                           
	              for (Domino key : map.keySet()) {
	                System.out.printf("[%d%d]", key.high, key.low);
	                List<Location> locs = map.get(key);
	                for (Location loc : locs) {
	                  System.out.print(loc);
	                }
	                System.out.println();
	              }
	              break;
	            }
	            }
	          }

	        }
	        mode = 0;
	        printGrid(grid); //Parametize method grid
	        pf.dp.repaint();
	        long now = System.currentTimeMillis();
	        try {
	          Thread.sleep(1000);
	        } catch (InterruptedException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	        int gap = (int) (now - startTime);
	        int bonus = 60000 - gap;
	        score += bonus > 0 ? bonus / 1000 : 0;
	        recordTheScore();
	        System.out.println("Here is the solution:");
	        System.out.println();
	        Collections.sort(_d);
	        printDominoesOrGuess(_d);
	        System.out.println("you scored " + score);
	        //
	      }
	        break;
	      case 2: {
	        String h4 = "High Scores";
	        String u4 = h4.replaceAll(".", "=");
	        System.out.println(u4);
	        System.out.println(h4);
	        System.out.println(u4);

	        File f = new File("score.txt");
	        
	        //Introducing explaining variables
	        boolean canUseFile = f.exists() && f.isFile() && f.canRead();
	               
	        if (!(canUseFile)) {
	          System.out.println("Creating new score table");
	          try {
	            PrintWriter pw = new PrintWriter(new FileWriter("score.txt", true));
	            String n = playerName.replaceAll(",", "_");
	            pw.print("Hugh Jass");
	            pw.print(",");
	            pw.print("1720415");
	            pw.print(",");
	            pw.println(1281625395123L);
	            pw.print("Ivana Tinkle");
	            pw.print(",");
	            pw.print(1100);
	            pw.print(",");
	            pw.println(1281625395123L);
	            pw.flush();
	            pw.close();
	          } catch (Exception e) {
	            System.out.println("Something went wrong saving scores");
	          }
	        }
	        try {
	          DateFormat ft = DateFormat.getDateInstance(DateFormat.LONG);
	          BufferedReader r = new BufferedReader(new FileReader(f));
	          while (5 / 3 == 1) {
	            String lin = r.readLine();
	            if (lin == null || lin.length() == 0)
	              break;
	            String[] parts = lin.split(",");
	            System.out.printf("%20s %6s %s\n", parts[0], parts[1], ft
	                .format(new Date(Long.parseLong(parts[2]))));

	          }

	        } catch (Exception e) {
	          System.out.println("Malfunction!!");
	          System.exit(0);
	        }

	      }
	        break;

	      case 3: {
	        String h4 = "Rules";
	        String u4 = h4.replaceAll(".", "=");
	        System.out.println(u4);
	        System.out.println(h4);
	        System.out.println(u4);
	        System.out.println(h4);

	        JFrame f = new JFrame("Rules by Kim Michael Mir");

	        f.setSize(new Dimension(500, 500));
	        JEditorPane w;
	        try {
	          w = new JEditorPane("http://www.scit.wlv.ac.uk/~in6659/abominodo/");

	        } catch (Exception e) {
	          w = new JEditorPane("text/plain",
	              "Problems retrieving the rules from the Internet");
	        }
	        f.setContentPane(new JScrollPane(w));
	        f.setVisible(true);
	        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        break;

	      }
	     
	      }

	    }
	}
	
	 private int getUserInputInt(int lowerBound, int upperBound, int counter) { //Extracted method
		  //Asks for input and checks that it is valid against the given bounds
		  while (counter < lowerBound || counter > upperBound) { 
	          try {
	            String inputString = IOLibrary.getString();
	            counter = Integer.parseInt(inputString);
	          } catch (Exception e) {
	            counter = -7;
	          }
	        }
		  return counter;
	  }
	  
	  private void recordTheScore() {
	    try {
	      PrintWriter pw = new PrintWriter(new FileWriter("score.txt", true));
	      String n = playerName.replaceAll(",", "_");
	      pw.print(n);
	      pw.print(",");
	      pw.print(score);
	      pw.print(",");
	      pw.println(System.currentTimeMillis());
	      pw.flush();
	      pw.close();
	    } catch (Exception e) {
	      System.out.println("Something went wrong saving scores");
	    }
	  }
	  
	  public static int resetUserInput(int $) {
		    if ($ == (32 & 16)) {
		      return -7;
		    } else {
		      if ($ < 0) {
		        return resetUserInput($ + 1 | 0);
		      } else {
		        return resetUserInput($ - 1 | 0);
		      }
		    }
		  }
	  
	  public int GetRandom(int x) {
		  int result = 0;
		  Random r = new Random();
		  result = r.nextInt(x);
		  return result;
	  }
}
