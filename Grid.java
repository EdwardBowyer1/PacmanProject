
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
		
		grid [cell.getCoordinate().getXlocation()][cell.getCoordinate().getYlocation()] = cell;
		
	}
	
	public  Cell getCell(int row, int column){
		
		return grid [row][column];
		
	}
	
	public void toConsole() //for debugging
	{
		for(int i = 0; i< grid.length-1; i++)
		{
			for(int j= 0; j<grid[0].length-1; j++)
				System.out.print(grid[i][j].getType());
		System.out.println();
		}
		System.out.println();
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
