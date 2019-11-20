
public class Grid {
	
	private static Cell [] [] grid;
	
	public Grid(){
		
		grid = new Cell [Constants.gridHeight] [Constants.gridWidth];
		
	}
	
	public void addCell(Cell cell){ //we need to make copies of the cell because encapsulation
		
		grid [cell.getCoordinate().getXlocation()][cell.getCoordinate().getYlocation()] = cell;
		
	}
	
	public static Cell getCell(int row, int column){
		
		return grid [row][column];
		
	}
	

}
