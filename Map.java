 

public class Map {
	
	//Instance variables-------------------------------------------
	private Pacman player;
	//need to add the rest of the gameobjects
	private int[][] grid = { {1,1,1,1,1,1,1,1,1,1,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
							 {1,0,0,0,0,0,0,0,0,0,1},
					 		 {1,1,1,1,1,1,1,1,1,1,1}};
	private int height;
	private int width;
	private Location startLocation;

	//Constructors-------------------------------------------------
	public Map()
	{
		setHeight(grid.length); //consider making a wrapper class for length;
		setWidth(grid[0].length);
		startLocation = new Location((width-1)/2, (height-1)/2);
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
				System.out.println("Next grid element: " +grid[PacX][PacY-1]); //meant to debug the issue of 
																			   //not being able to access block before wall(width). 
				if(grid[PacX][PacY-1] != 1)
				{
					return true;
				}
			}
			else if(directionInput == 's')
			{
				System.out.println("Next grid element: " +grid[PacX][PacY+1]);
				if(grid[PacX][PacY+2] != 1)
				{
					return true;
				}
			}
			else if(directionInput == 'a')
			{
				System.out.println("Next grid element: " +grid[PacX-1][PacY]);
				if(grid[PacX-1][PacY] != 1)
				{
					return true;
				}
			}
		
			else if(directionInput == 'd')
			{
				System.out.println("Next grid element: " +grid[PacX+1][PacY]);
				if(grid[PacX+1][PacY] != 1)
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
