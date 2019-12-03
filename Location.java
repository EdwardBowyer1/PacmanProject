import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Location {
	//instance variables
	//grid cell count horizontally/vertically
	private double xlocation; // i in matrix notation  ******************************************!!
	private double ylocation; // j in matrix notation	******************************************!!
	
	
	private double pixelW; //why do we need this? Cant we just refer to constant class ANS-> Because its the how many pixels from (0,0) to this location, its a multiple of cell pixels dimensions 
	private double pixelH;
	
	public static int tracker = 0;


	
	//constructors
	public Location()
	{
		setXlocation(0);
		setYlocation(0);
	}
	//receives an x and y location of the grid, not in pixel form
	public Location(double xlocation, double ylocation) 
	{
		setXlocation(xlocation);
		setYlocation(ylocation);
	}
	public Location(Location old) //Sami->added copy constructor for gameObject
	{
		this(old.xlocation,old.ylocation);
	}
	
	//Methods
	
	public boolean isEqual(Location old) 
	{
		if(old.xlocation == xlocation && old.ylocation == ylocation)
			return true;
		else
			return false;
	}
		
	protected void changeLocation(int xChange, int yChange) //consider changing to protected instead
		{
			setXlocation(xlocation + xChange);
			setYlocation(ylocation + yChange);
		}
	
	/**
	 * Returns a string of of the i and j location 
	 */
	public String toString()
	{
		return "Coordinate: (" + xlocation + ", " + ylocation + ")";
	}
	//getters and setters
	public double getXlocation() {
		return xlocation;
	}

	public double getYlocation() {
		return ylocation;
	}

	public void setXlocation(double xlocation) {
		if(xlocation>=0) //add other bound
		{
			this.xlocation = xlocation;
			setPixelH(xlocation*Constants.cellHeight);
		}
	}
	public void setYlocation(double ylocation) {
		if(ylocation>=0) //add other bound
		{
			this.ylocation = ylocation;
			setPixelW(ylocation*Constants.cellWidth);
		}
	}
	public double getPixelH() {
		return pixelH;
	}
	public void setPixelH(double pixelH) {
		this.pixelH = pixelH;
	}
	public double getPixelW() {
		return pixelW;
	}
	public void setPixelW(double pixelW) {
		this.pixelW = pixelW;
	}
	
	
}

