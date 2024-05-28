package com.pacmanproject.main;

/**
 * 
 * @author Sami, Zeke, Medhanie
 *
 */
public class Location {
	//instance variables
	/**
	 * grid cell count horizontally/vertically
	 */
	private double xlocation; // i in matrix notation  ******************************************!!
	private double ylocation; // j in matrix notation	*****************************************!!


	private double pixelW;
	private double pixelH;

	public static int tracker = 0;



	/**
	 * constructors
	 */
	public Location()
	{
		setXlocation(0);
		setYlocation(0);
	}
	/**
	 * receives an x and y location of the grid, not in pixel form
	 * @param xlocation
	 * @param ylocation
	 */
	public Location(double xlocation, double ylocation) 
	{
		setXlocation(xlocation);
		setYlocation(ylocation);
	}
	public Location(Location old) //Sami->added copy constructor for gameObject
	{
		this(old.xlocation,old.ylocation);
	}

	/**
	 * 
	 * @param old-> Location to be compared current location variable
	 * @return true if equal, false otherwise
	 */
	public boolean isEqual(Location old) 
	{
		if(old.xlocation == xlocation && old.ylocation == ylocation)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param xChange increments/decrements the row of the location 
	 * @param yChange increments/decrements the column of the location 
	 */
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
	/**
	 * getters and setters----------------------------------------------------------------------------------------
	 * @return
	 */
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

