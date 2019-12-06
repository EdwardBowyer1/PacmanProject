import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * This class keeps track of the GUI Node and the type of the cell, it's superclass GamObject keeps track 
 * of the Location.
 * @author Zeke and Sami
 *
 */
public class Cell extends GameObject
{
	/**
	 * Instance variables
	 */
	private int type; //identifies type of the cell (Obstacle/Wall, Food, and an empty Cell)
	private Node node; //Needed to actually put on the pane for GUI	

	//----Constructor---------------------------------------------------
	public Cell(Location location, int type) 
	{
		super(location);
		this.type = type;	
	}


	/**
	 * ----Setters--------------------------------------------------------	
	 * @param node
	 */
	public void setNode(Node node) 
	{
		this.node = node;
	}

	public void setType(int type) 
	{
		this.type = type;
	}


	/**
	 * ----Getters-------------------------------------------------------
	 * @return typer of cell 
	 */
	public int getType() 
	{			
		return type;
	}


	/**
	 * @return Returns the node that will be added into the GUI, based on the type of the cell
	 */
	public Node getNode() 
	{
		double xlocation = getCoordinate().getPixelW(); //x location in pixels. (x * cell_width)
		double ylocation = getCoordinate().getPixelH();

		if(type == Constants.OBSTACLE) //if type is obstacle, cell is the image of the wall
		{

			ImageView Wall = new ImageView("wall.png"); //loads wall image

			Wall.setFitWidth(Constants.cellWidth);    //set width and height in pixels
			Wall.setFitHeight(Constants.cellHeight); 

			//x location in pixels (one grid-width in pixels * # columns x)
			Wall.setX(xlocation);  
			Wall.setY(ylocation);

			this.node = Wall;	
		}

		else if(type == Constants.FOOD) //if type is food
		{

			this.node = new Circle();

			((Circle)node).setFill(Constants.FOOD_COLOUR);  	//Color of dot/food is white

			((Circle) node).setCenterX(xlocation + Constants.cellWidth/2);
			((Circle) node).setCenterY(ylocation +Constants.cellHeight/2 );
			((Circle) node).setRadius(Constants.cellHeight/8);	
		}
		else if(type == Constants.EMPTY) 
		{				//draws rectangle at this x and y with pixel width and height
			this.node = new Rectangle(xlocation,ylocation,Constants.cellWidth,Constants.cellHeight);
			((Rectangle)node).setFill(Constants.EMPTY_COLOUR); //empty space is colored black, i.e nothing there
		}

		return node;
	}
	/**
	 * Returns the type of the cell
	 */
	public String toString()
	{
		return "Type: " + this.type;
	}

}
