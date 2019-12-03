
public class Grid {
	
	private  Cell [] [] grid;
	
	public Grid(){
		
		grid = new Cell [Constants.gridHeight] [Constants.gridWidth];
		
	}
	
	public Grid(Grid toCopy)
	{
		this();
		for (int i =0;i< Constants.gridHeight;i++)
		{
            for (int j =0;j< Constants.gridWidth;j++)
            {
            	this.addCell(toCopy.getCell(i, j));
            }
		
		
		}
	}
	
	public void addCell(Cell cell){ //we need to make copies of the cell because encapsulation
		
		grid [(int)cell.getCoordinate().getXlocation()][(int)cell.getCoordinate().getYlocation()] = cell;
		
	}
	
	public  Cell getCell(double row, double column){
		
		return grid [(int)row][(int)column];
		
	}
	
	public void toConsole() //for debugging
	{
		
		for(int i = 0; i< grid.length; i++)
		{
			System.out.print("           ");
			for(int j= 0; j<grid[0].length; j++)
			{
				int type = grid[i][j].getType();
				
				if(Map.player.getCoordinate().getXlocation() == i && Map.player.getCoordinate().getYlocation()== j)
					System.out.print('C');
				else if(Map.redGhost.getCoordinate().getXlocation() == i && Map.redGhost.getCoordinate().getYlocation()== j)
					System.out.print('X');
				else {
				 	if(type == 1) 
		        		System.out.print('#');
		        	else if(type == 2)
		        		System.out.print('.');
		        	else 
		        		System.out.print(' ');
					//System.out.print(grid[i][j].getType());
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean isEmpty(int i, int j)
	{
		if(grid[i][j].getType() == Constants.EMPTY)
			return true;
		else
			return false;
	}
	

}
