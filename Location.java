
public class Location {
	//instance variables
	private int xlocation;
	private int ylocation;
	
	//constructors
	public Location()
	{
		setXlocation(0);
		setYlocation(0);
	}
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
		if(xlocation>=0)
		{
			this.xlocation = xlocation;

		}
	}
	public void setYlocation(int ylocation) {
		if(ylocation>=0)
		{
			this.ylocation = ylocation;

		}
	}
	
	
	
}

