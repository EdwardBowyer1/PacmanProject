import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 *  THis class keeps manages its own location and returns its representation through it's node.
 * @author Zeke and Sami
 *
 */
public class Pacman extends Character {

	/**
	 * Instance variables
	 */
	private static int score, highscore;
	private static Node node;
	private ImageView PacImage;
	//name of the BINARY file to read and save the highscore 
	private String Hscore = "Highscore.bin";	
	/**
	 * ----constructors---------------------------------------------------
	 * @param toCopy, sets the location.
	 */

	public Pacman(Location toCopy) 
	{
		super(toCopy); 
		setScore(0);
		setHighscore(0);

		loadHighscore(Hscore);
		PacImage = new ImageView(Constants.GIFPacRight);
	}



	//----Methods----------------------------------------------------------------

	/**
	 * Decrements the the row location (i in matrix notation)
	 */
	public boolean moveUp()
	{
		double xlocation  = getCoordinate().getXlocation(); //X and Y locations 
		double ylocation  = getCoordinate().getYlocation();
		//Checks one block above Pacman before moving
		PacImage.setRotate(-90);
		if (Map.grid.getCell(xlocation-1, ylocation).getType() == Constants.OBSTACLE)
			return false;

		//Changes location of Pacman (moves him up by one)
		Location temp = new Location(xlocation-1, ylocation);
		super.setCoordinate(temp);

		if (Map.grid.getCell(xlocation-1, ylocation).getType() == Constants.FOOD)
		{
			setScore(getScore() + 10); //Increase the score
			if(getScore() >= getHighscore())
				setHighscore(getScore());
			Map.grid.getCell(xlocation-1, ylocation).setType(Constants.EMPTY);
			Map.foodCount--;
		}    	
		Map.redrawMap();

		return true;

	}

	/**
	 * Increments the the row location (i in matrix notation)
	 */
	public boolean moveDown()
	{
		double xlocation  = getCoordinate().getXlocation(); //X and Y locations 
		double ylocation  = getCoordinate().getYlocation();
		PacImage.setRotate(90);
		//Checks if location below Pacman is an OBSTACLE
		if (Map.grid.getCell(xlocation+1, ylocation).getType() == Constants.OBSTACLE)
			return false;



		Location temp = new Location(xlocation+1, ylocation);
		super.setCoordinate(temp);

		if (Map.grid.getCell(xlocation+1, ylocation).getType() == Constants.FOOD)
		{
			setScore(getScore() + 10);
			if(getScore() >= getHighscore())
				setHighscore(getScore());
			Map.grid.getCell(xlocation+1, ylocation).setType(Constants.EMPTY);
			Map.foodCount--;
		}
		Map.redrawMap();

		return true;

	}

	/**
	 * Decrements the the column location (j in matrix notation)
	 */
	public boolean moveLeft()
	{

		double xlocation  = getCoordinate().getXlocation(); //X and Y locations 
		double ylocation  = getCoordinate().getYlocation();

		PacImage.setRotate(180);
		if (Map.grid.getCell(xlocation, ylocation-1).getType() == Constants.OBSTACLE)
			return false;



		Location temp = new Location(xlocation, ylocation-1);
		super.setCoordinate(temp);

		if (Map.grid.getCell(xlocation, ylocation-1).getType() == Constants.FOOD)
		{
			setScore(getScore() + 10);
			if(getScore() >= getHighscore())
				setHighscore(getScore());
			Map.grid.getCell(xlocation, ylocation-1).setType(Constants.EMPTY);
			Map.foodCount--;
		}   	

		Map.redrawMap();

		return true;
	}

	/**
	 * Increments the the column location (j in matrix notation)
	 */
	public boolean moveRight() 
	{
		double xlocation  = getCoordinate().getXlocation(); //X and Y locations 
		double ylocation  = getCoordinate().getYlocation();

		PacImage.setRotate(0);
		if (Map.grid.getCell(xlocation, ylocation+1).getType() == Constants.OBSTACLE)
			return false;



		Location temp = new Location(xlocation, ylocation+1);
		super.setCoordinate(temp);

		//increments score 
		if (Map.grid.getCell(xlocation, ylocation+1).getType() == Constants.FOOD)
		{
			setScore(getScore() + 10);
			if(getScore() >= getHighscore())
				setHighscore(getScore());
			Map.grid.getCell(xlocation, ylocation+1).setType(Constants.EMPTY);
			Map.foodCount--;
		} 

		Map.redrawMap();

		return true;
	}
	/**
	 * 
	 * @return : returns the node that is required to visually depict the ghost in the GUI.
	 */
	public Node getNode()
	{
		double xpixel = getCoordinate().getPixelW(); //x location in pixels. (x * cell_width)
		double ypixel= getCoordinate().getPixelH();

		double min = Constants.cellHeight;
		if (Constants.cellWidth < Constants.cellHeight)
			min = Constants.cellWidth;

		PacImage.setFitWidth(min);
		PacImage.setFitHeight(min);

		PacImage.setX(xpixel);
		PacImage.setY(ypixel);

		node = PacImage;

		return node;

	}

	/**
	 * Loads the highscore from a file into the application which is then 
	 * @param filename Name of the file with the highscore
	 */
	public static void loadHighscore(String filename)
	{
		try
		(DataInputStream input = new DataInputStream(new FileInputStream(filename)))
		{
			int x = input.readInt();
			highscore = x;
			input.close();
		}
		catch(IOException ioe)
		{
			System.out.println("Error, no previous highscores found");
			highscore = score;

		}
	}

	/**
	 * Saves the highscore into a file with the provided name. Must be .bin.
	 * If the file exists then it is overwritten.
	 * @param filename
	 */
	public static void saveHighscore(String filename)
	{
		try 
		(DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));)
		{
			out.writeInt(highscore);
			out.close();		
		} catch (IOException ioe) {
			System.out.println("Cant make a new file");
		}
	}

	/**
	 *  Getters/setters-------------------------------------------------------------------------
	 * @return
	 */

	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		Pacman.score = score;
	}



	public static int getHighscore() {
		return highscore;
	}



	public static void setHighscore(int highscore) {
		Pacman.highscore = highscore;
	}

	public String getHscore() {
		return Hscore;
	}


}
