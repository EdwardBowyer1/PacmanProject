/**
 * This is the class that creates a grid based on the value in the Constants class. 
 * It's a 2D array of cells which is how the map retains it;s values and dynamically changes.
 * @author Zeke and Sami
 *
 */
public class Grid {

	/**
	 * instance variables
	 */
	private  Cell [][] grid;

	/**
	 * Constructors
	 * @param toCopy
	 */
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
	/**
	 * Getters and setters
	 * @param cell
	 */
	public void addCell(Cell cell)
	{ 

		grid [(int)cell.getCoordinate().getXlocation()][(int)cell.getCoordinate().getYlocation()] = cell;

	}

	public  Cell getCell(double row, double column){

		return grid [(int)row][(int)column];

	}

	/**
	 * Prints the current grid types encoded into suitable characters on the console.
	 */
	public void toConsole() 
	{

		for(int i = 0; i< grid.length; i++)
		{
			System.out.print("           ");
			for(int j= 0; j<grid[0].length; j++)
			{
				int type = grid[i][j].getType();

				if(Map.blueGhost.getCoordinate().getXlocation() == i && Map.blueGhost.getCoordinate().getYlocation()== j)
					System.out.print('X');
				else if(Map.player.getCoordinate().getXlocation() == i && Map.player.getCoordinate().getYlocation()== j)
					System.out.print('C');
				else if(Map.redGhost.getCoordinate().getXlocation() == i && Map.redGhost.getCoordinate().getYlocation()== j)
					System.out.print('X');
				else {
					if(type == 1) 
						System.out.print('#');
					else if(type == 2)
						System.out.print('.');
					else if(type == 0)
						System.out.print(' ');

				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Returns true if the cell at (i,j) is empty.
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isEmpty(int i, int j)
	{
		if(grid[i][j].getType() == Constants.EMPTY)
			return true;
		else
			return false;
	}

	public Cell[][] getGrid()  //for the test class
	{
		return grid;
	}

	public void initDefGrid() //for test
	{

		for (int i =0;i< Constants.gridHeight;i++)
		{
			for (int j =0;j< Constants.gridWidth;j++)
			{
				Location celocation = new Location(i,j);
				Cell cell = new Cell(celocation, 0);
				addCell(cell);

			}

		}


	}

}
