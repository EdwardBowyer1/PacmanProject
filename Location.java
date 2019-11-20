import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Location {
	//instance variables
	//grid cell count horizontally/vertically
	private int xlocation;
	private int ylocation;
	
	
	private double pixelW; //why do we need this? Cant we just refer to constant class
	private double pixelH;


	
	//constructors
	public Location()
	{
		setXlocation(0);
		setYlocation(0);
	}
	//receives an x and y location of the grid, not in pixel form
	public Location(int xlocation, int ylocation) 
	{
		setXlocation(xlocation);
		setYlocation(ylocation);
	}
	public Location(Location old) //Sami->added copy constructor for gameObject
	{
		this(old.xlocation,old.ylocation);
	}
	
	//Methods
	
	public static void initScreenDimensions()
	{
		
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Constants.screenWidth = primaryScreenBounds.getWidth();
        Constants.screenHeight = primaryScreenBounds.getHeight();
        
        
         System.out.println("width: " +Constants.screenWidth + " height: " + Constants.screenHeight + " \n" + primaryScreenBounds.toString());
	}
	
	
	public boolean isEqual(Location old) //
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
	public String toString()
	{
		return "Coordinate: (" + xlocation + ", " + ylocation + ")";
	}
	//getters and setters
	public int getXlocation() {
		return xlocation;
	}

	public int getYlocation() {
		return ylocation;
	}

	public void setXlocation(int xlocation) {
		if(xlocation>=0) //add other bound
		{
			this.xlocation = xlocation;
			setPixelW(xlocation*Constants.cellWidth);
		}
	}
	public void setYlocation(int ylocation) {
		if(ylocation>=0)
		{
			this.ylocation = ylocation;
			setPixelH(ylocation*Constants.cellHeight);
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

