import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Cell extends GameObject
{
	
	private int type; //identifies type of the cell (Obstacle/Wall, Food, and an empty Cell)
	private Node node; //Needed to actually put on the pane for GUI
	//private Location location; //this fixes the location issue
	
	
//----Constructor---------------------------------------------------
	public Cell(Location location, int type) 
	{
		super(location);
		this.type = type;	
	}

		
//----Setters--------------------------------------------------------	
	public void setNode(Node node) 
	{
		this.node = node;
	}
	
	public void setType(int type) 
	{
		this.type = type;
	}


//----Getters-------------------------------------------------------
	public int getType() 
	{			
		return type;
	}
	
	
//This is what is called to draw the cell
	public Node getNode() 
	{
		int xlocation = getCoordinate().getXlocation(); //x location in pixels. (x * cell_width)
		int ylocation = getCoordinate().getXlocation();
		
		if(type == Constants.OBSTACLE) //if type is obstacle, cell is the image of the wall
		{
			
				ImageView Wall = new ImageView("wall.png"); //loads wall image
				
				Wall.setFitWidth(Constants.cellWidth);    //set width and height in pixels
				Wall.setFitHeight(Constants.cellHeight); 
				
				 //x location in pixels (one grid-width in pixels * # columns x)
				Wall.setX(xlocation + Constants.cellWidth/2 - Constants.cellWidth/2 );  
				Wall.setY(ylocation + Constants.cellHeight/2 - Constants.cellHeight/2 );
	
					this.node = Wall;	
		}
		
		else if(type == Constants.FOOD) //if type is food
		{
			//draws a circle 
			this.node = new Circle(xlocation + Constants.cellWidth/2, ylocation + Constants.cellHeight/2 - Constants.cellWidth/8, 0, null);
			((Circle)node).setFill(Constants.FOOD_COLOUR);  //Color of dot/food is white
		}
		
		else if(type == Constants.EMPTY) 
		{				//draws rectangle at this x and y with pixel width and height
			this.node = new Rectangle(xlocation,ylocation,Constants.cellWidth,Constants.cellHeight);
			((Rectangle)node).setFill(Constants.EMPTY_COLOUR); //empty space is colored black, i.e nothing there
		}
		
		return node;
	}


	


}
