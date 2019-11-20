import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Pacman extends Character {

	private int xlocation  = getCoordinate().getXlocation(); //X and Y locations 
	private int ylocation  = getCoordinate().getYlocation();
	
	private static int score;
	private static Node node;
	public static ImageView PacImage = new ImageView(Constants.GIFPacRight);
	
	
//----constructors---------------------------------------------------
	
	public Pacman(Location toCopy) 
	{
		super(toCopy); 
		score = 0;
	}

	

//----Methods----------------------------------------------------------------
	
	public boolean moveUp()
	{
		//Checks one block above Pacman before moving
		if (Grid.getCell(xlocation-1, ylocation).getType() == Constants.OBSTACLE)
			return false;
		
		//Constants.PACMAN_IMAGE.setRotate();
		PacImage.setRotate(-90);
		
		//Changes location of Pacman (moves him up by one)
		Location temp = new Location(xlocation-1, ylocation);
		super.setCoordinate(temp);
		
		if (Grid.getCell(xlocation, ylocation).getType() == Constants.FOOD)
		{
			Pacman.score++; //Increase the score
			Grid.getCell(xlocation, ylocation).setType(Constants.EMPTY);
		}    	
		Map.redrawMap();
    	
    	return true;
	
	}
	
	public boolean moveDown()
	{
		//Checks if location below Pacman is an OBSTACLE
		if (Grid.getCell(xlocation+1, ylocation).getType() == Constants.OBSTACLE)
			return false;
		
		PacImage.setRotate(90);
		
		Location temp = new Location(xlocation+1, ylocation);
		super.setCoordinate(temp);
		
		if (Grid.getCell(xlocation, ylocation).getType() == Constants.FOOD)
		{
			Pacman.score++;
			Grid.getCell(xlocation, ylocation).setType(Constants.EMPTY);
		}
    	Map.redrawMap();
    	
    	return true;

	}
	
	public boolean moveLeft()
	{
		
		if (Grid.getCell(xlocation, ylocation-1).getType() == Constants.OBSTACLE)
			return false;
		
		PacImage.setRotate(180);

		Location temp = new Location(xlocation, ylocation-1);
		super.setCoordinate(temp);
		
		if (Grid.getCell(xlocation, ylocation).getType() == Constants.FOOD)
		{
			Pacman.score++;
			Grid.getCell(xlocation, ylocation).setType(Constants.EMPTY);
		}   	
		
		Map.redrawMap();

    	return true;
	}
	

	public boolean moveRight()
	{
		
		if (Grid.getCell(xlocation, ylocation+1).getType() == Constants.OBSTACLE)
			return false;
		
		PacImage.setRotate(0);
		
		Location temp = new Location(xlocation, ylocation+1);
		super.setCoordinate(temp);
		
		if (Grid.getCell(xlocation, ylocation).getType() == Constants.FOOD)
		{
			Pacman.score++;
			Grid.getCell(xlocation, ylocation).setType(Constants.EMPTY);
		} 
		
		Map.redrawMap();

    	return true;
	}
	
	public Node getNode()
	{
		double xpixel = getCoordinate().getPixelW(); //x location in pixels. (x * cell_width)
		double ypixel= getCoordinate().getPixelH();
		
		double min = Constants.cellHeight;
		if (Constants.cellWidth > Constants.cellHeight)
			min = Constants.cellWidth;
		
		PacImage.setFitWidth(min);
		PacImage.setFitHeight(min);

		PacImage.setX(xpixel);//+position.width/2 - min/2);
		PacImage.setY(ypixel);//+position.height/2 - min/2);
		
		node = PacImage;
		
	return node;
	
}


	

}
