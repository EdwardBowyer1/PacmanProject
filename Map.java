 

public class Map {
	
	//Instance variables-------------------------------------------
	private Pacman player;
	//need to add the rest of the gameobjects
	private int[][] grid = { {1,1,1,1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,1},
								{1,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1,1}};
	private int height;
	private int width;
	private Location startLocation;

	//Constructors-------------------------------------------------
	public Map()
	{
		setHeight(grid.length); //consider making a wraooer class for length;
		setWidth(grid[0].length);
		startLocation = new Location((width-1)/2, (height-1)/2);
		player = new Pacman(startLocation);
	}
	//Methods------------------------------------------------------
	
	// Argument is the input from console 
	// Returns whether or not character is next boarder or '1'--> boundary
		public boolean canMoveCharacter(char directionInput) 
		{
			int PacX = player.getCoordinate().getXlocation();
			int PacY = player.getCoordinate().getYlocation();
			if(directionInput == 'w')
			{
				if(PacY >= 1 && grid[PacX][PacY-1] != 1)
				{
					return true;
				}
			}
			else if(directionInput == 's')
			{
				if(PacY <= height-3 && grid[PacX][PacY+1] != 1)
				{
					return true;
				}
			}
			else if(directionInput == 'a')
			{
				if(PacX >= 1 && grid[PacX-1][PacY] != 1)
				{
					return true;
				}
			}
		
			else if(directionInput == 'd')
			{
				if(PacX <= width-2 && grid[PacX+1][PacY] != 1)
				{
					return true;
				}
			}
				return false;
		}
		
		public void printMap()
		{
			int PacX = player.getCoordinate().getXlocation();
			int PacY = player.getCoordinate().getYlocation();
			for(int i = 0; i< height; i++)
			{
				for(int j = 0; j< width; j++)
				{
					if (j == PacX && i == PacY)
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
