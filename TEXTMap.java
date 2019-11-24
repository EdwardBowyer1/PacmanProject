 

public class TEXTMap {
	
	//Instance variables-------------------------------------------
	private Pacman player;
	//need to add the rest of the gameobjects
	private int[][] grid = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	          				 {1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1},
	          				 {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1},
	          				 {1,1,1,1,1,3,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,3,1,1,1,1,1},
	          				 {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1},
	          				 {1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1},
	          				 {1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1,1,1,1,1},
				          	 {1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1,1,1,1,1},
	    			      	 {1,1,1,1,1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1,1,1,1,1},
	        			  	 {1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1},
	        			  	 {1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1},
	        			  	 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
				          	 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
				          	 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,1,1,0,0,0,0,1,1,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
	        			  	 {1,0,0,0,2,2,2,2,2,2,2,0,0,0,1,1,0,0,0,0,1,1,0,0,0,2,2,2,2,2,2,2,0,0,0,1},
	        			  	 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
	        		  		 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
			        	  	 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
	          				 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
	    			      	 {1,1,1,1,1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1,1,1,1,1},
	    			      	 {1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1},
	    			      	 {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1},
	    			      	 {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1},
	    			      	 {1,1,1,1,1,3,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,3,1,1,1,1,1},
	     			     	 {1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1},
	     			     	 {1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1},
	     			     	 {1,1,1,1,1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1,1,1,1,1},
	      			    	 {1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},
	      			    	 {1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},
	       				 	 {1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1},
	       			   	 	 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
	private int height; //30
	private int width; //36
	private Location startLocation;

	//Constructors-------------------------------------------------
	public TEXTMap()
	{
		setHeight(grid.length); //consider making a wrapper class for length;
		setWidth(grid[0].length);
		startLocation = new Location((width-1)/2, 5);
		player = new Pacman(startLocation);
	}
	//Methods------------------------------------------------------
	
	// Argument is the input from console 
	
	// Returns true if the space in front of the character is empty (not a 1 on the grid).
	
		public boolean canMoveCharacter(char directionInput) 
		{
			int PacX = player.getCoordinate().getXlocation() ;
			int PacY = player.getCoordinate().getYlocation();
			if(directionInput == 'w')
			{
				System.out.println("Next grid element: " +grid[PacY-1][PacX]); //meant to debug the issue of 
																			   //not being able to access block before wall(width). 
				if(grid[PacY-1][PacX] != 1)
				{
					return true;
				}
			}
			else if(directionInput == 's')
			{
				System.out.println("Next grid element: " +grid[PacY+1][PacX]);
				if(grid[PacY+1][PacX] != 1)
				{
					return true;
				}
			}
			else if(directionInput == 'a')
			{
				System.out.println("Next grid element: " +grid[PacY][PacX-1]);
				if(grid[PacY][PacX-1] != 1)
				{
					return true;
				}
			}
		
			else if(directionInput == 'd')
			{
				System.out.println("Next grid element: " +grid[PacY][PacX+1]);
				if(grid[PacY][PacX+1] != 1)
				{
					return true;
				}
			}
				return false;
		}
		
		public void printMap()
		{
			//need the character coordintes of pacman, setting local variable
			int PacX = player.getCoordinate().getXlocation();
			int PacY = player.getCoordinate().getYlocation();
			 //these loops print out the grid to whatever we want to graphically output
			for(int i = 0; i< height; i++)
			{
				for(int j = 0; j< width; j++)
				{
					if (j == PacX && i == PacY) //must check this first
						System.out.print('C');
					else if(grid[i][j] == 0)
						System.out.print(' ');
					else if(grid[i][j] == 1)
						System.out.print('#');
					else if(grid[i][j] == 2)
						System.out.print('.');
					else if(grid[i][j] == 3)
						System.out.print('x');
				}
				System.out.println();
			}
		}
			
	//-----Getters-------------------------------	
		public int getHeight() 
		{
			return height;
		}
			
		public int getWidth() 
		{
			return width;
		}
		
		public Pacman getPlayer() 
		{
			return player;
		}

			
			
	//-----Setters-------------------------------
		private void setHeight(int h)
		{
			height = h;
		}
		private void setWidth(int w)
		{
			width = w;
		}


}
/* CODE FOR MAKING A WORKING GUI
NOT SURE WHERE TO PUT IT IN/HOW TO SPLIT IT UP



//Import required java files
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import javax.swing.JApplet;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JPanel;

import java.util.*;
import java.lang.*;



public class GUIGame extends JPanel implements ActionListener 
{
    private Dimension d;
    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

    private Image ii;
    private final Color dotColor = new Color(192,192,0);
    private Color mazeColor;   

    //Can prob implement elsewhere
    private boolean inGame = false;
    private boolean dying = false;

        private final int BLOCK_SIZE = 24;
        private final int N_BLOCKS = 15;
        private final int SCREEN_SIZE = 15*24; //to be fixed
        private final int PAC_ANIM_DELAY = 2;
        private final int PACMAN_ANIM_COUNT = 4;
        private final int MAX_GHOSTS = 4; 
        private final int PACMAN_SPEED = 6;

        private int pacAnimCount = PAC_ANIM_DELAY;
        private int pacAnimDir = 1;
        private int pacmanAnimPos = 0;
        private int N_GHOSTS = 4;
        private int pacsLeft, score;
        private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
        private int[] dx,dy;

        private int currentSpeed = 3;
        private short[] screenData;
        private Timer timer;
    public GUIGame()
    {
        loadImages();
        initVariables();
        initBoard();
    }

    private void initBoard()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
    }
    
    private void initVariables()
    {
        timer = new Timer(40, this);
        timer.start();
    }
    private void loadImages()
    {
        
        ghost = new ImageIcon("Images/ghost.png").getImage();

        
    }

}
*/
