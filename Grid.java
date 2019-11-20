
public class Grid {
	
	private static Cell [] [] grid;
	
	public Grid(){
		
		grid = new Cell [Constants.gridHeight] [Constants.gridWidth];
		
	}
	
	public void addCell(Cell cell){ //we need to make copies of the cell because encapsulation
		
		grid [cell.getCoordinate().getYlocation()][cell.getCoordinate().getXlocation()] = cell;
		
	}
	
	public static Cell getCell(int row, int column){
		
		return grid [row][column];
		
	}
	

}
