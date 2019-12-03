import java.util.Random;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * THis class keeps manages its own location and returns its representation through it's node.
 * @author Medhanie and Sami
 *
 */
public class Ghost extends Character {

	

	//instance variables
	private Node node;
	private  ImageView redGhostImage = new ImageView(Constants.GIFRedGhost);
	
	// constructor

	public Ghost(Location toCopy) {
		super(toCopy);

	}

	/**
	 * This function is called whenever the ghost is equired to change location on the map,
	 * It calls one of four move functions based on what the AI decides, (smart random probability)
	 */
	public void moveGhost(){


		double pacXlocation  = Map.player.getCoordinate().getYlocation(); //X and Y locations
		double pacYlocation  = Map.player.getCoordinate().getXlocation(); //swapped the x and y location due to confusion of x,y being [i][j] notation
		double ghostXlocation = getCoordinate().getYlocation();			// Ylocation represents width of grid "Traditional x axis"
		double ghostYlocation = getCoordinate().getXlocation();			//Xlocation represents height of grid "traditional y axis"
		Random rand = new Random();
	    int randomNum = rand.nextInt((3 - 0) + 1) + 0;

	    if (pacYlocation > ghostYlocation ){

	    	 if (pacXlocation > ghostXlocation ){

	    		 randomNum = rand.nextInt((1 - 0) + 1) + 0;

	    		 if (randomNum == 0)
	    			 moveDown();
	    		 else
	    			 moveRight();

	 	    }

	    	 if (pacXlocation <= ghostXlocation ){

	    		 randomNum = rand.nextInt((1 - 0) + 1) + 0;

	    		 if (randomNum == 0)
	    			 moveDown();
	    		 else
	    			 moveLeft();

	 	    }

	    }else if (pacYlocation <= ghostYlocation){

	    	 if (pacXlocation >= ghostXlocation){

	    		 randomNum = rand.nextInt((1 - 0) + 1) + 0;

	    		 if (randomNum == 0)
	    			 moveUp();
	    		 else
	    			 moveRight();

	 	    }

	    	 if (pacXlocation < ghostXlocation){

	    		 randomNum = rand.nextInt((1 - 0) + 1) + 0;

	    		 if (randomNum == 0)
	    			 moveUp();
	    		 else
	    			 moveLeft();

	 	    }

	    }

	    if (ghostYlocation == pacYlocation && ghostXlocation == pacXlocation ){
	    	Map.gameOver();
		}


	}
/**
 * Decrements the the row location (i in matrix notation)
 */
	public  boolean moveUp(){

		double ghostXlocation = getCoordinate().getYlocation();
		double ghostYlocation = getCoordinate().getXlocation();
		if (Map.grid.getCell(ghostYlocation-1, ghostXlocation).getType() == Constants.OBSTACLE)
			return false;

		Location temp = new Location(ghostYlocation-1, ghostXlocation);
		super.setCoordinate(temp);

    	return true;

	}
	/**
	 * Increments the the row location (i in matrix notation)
	 */
	public  boolean moveDown(){

		double ghostXlocation = getCoordinate().getYlocation();
		double ghostYlocation = getCoordinate().getXlocation();
		if (Map.grid.getCell(ghostYlocation+1, ghostXlocation).getType() == Constants.OBSTACLE)
			return false;

		Location temp = new Location(ghostYlocation+1, ghostXlocation);
		super.setCoordinate(temp);
   
    	return true;

	}

	/**
	 * Decrements the the column location (j in matrix notation)
	 */
	public  boolean moveLeft(){


		double ghostXlocation = getCoordinate().getYlocation();
		double ghostYlocation = getCoordinate().getXlocation();
		if (Map.grid.getCell(ghostYlocation,ghostXlocation-1).getType() == Constants.OBSTACLE)
			return false;

		Location temp = new Location(ghostYlocation, ghostXlocation-1);
		super.setCoordinate(temp);

    	return true;


	}
	/**
	 * Increments the the column location (j in matrix notation)
	 */
	public  boolean moveRight(){

		double ghostXlocation = getCoordinate().getYlocation();
		double ghostYlocation = getCoordinate().getXlocation();

		if (Map.grid.getCell(ghostYlocation, ghostXlocation+1).getType() == Constants.OBSTACLE)
			return false;

		Location temp = new Location(ghostYlocation, ghostXlocation+1);
		super.setCoordinate(temp);
	
    	return true;

	}
	/**
	 * 
	 * @return : returns the node that is required to visually depict the ghost in the GUI.
	 */

	public  Node getNode(){


		double xpixel = getCoordinate().getPixelW();
		double ypixel= getCoordinate().getPixelH();

		double min = Constants.cellHeight;
		if (Constants.cellWidth < Constants.cellHeight)
			min = Constants.cellWidth;

		redGhostImage.setFitWidth(min);
		redGhostImage.setFitHeight(min);

		redGhostImage.setX(xpixel);	
		redGhostImage.setY(ypixel);

		node = redGhostImage;

	return node;

	}

}
