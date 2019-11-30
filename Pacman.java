import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Pacman extends Character {
//	private int xlocation  = getCoordinate().getXlocation(); //X and Y locations 
//	private int ylocation  = getCoordinate().getYlocation();
	
	
	private static int score, highscore;
	private static Node node;
	private ImageView PacImage;
	private String Hscore = "Highscore.bin";	
//----constructors---------------------------------------------------
	
	public Pacman(Location toCopy) 
	{
		super(toCopy); 
		setScore(0);
		setHighscore(0);
		
		loadHighscore(Hscore);
		PacImage = new ImageView(Constants.GIFPacRight);
	}

	

//----Methods----------------------------------------------------------------


	public boolean moveUp()
	{
		double xlocation  = getCoordinate().getXlocation(); //X and Y locations 
		double ylocation  = getCoordinate().getYlocation();
		//Checks one block above Pacman before moving
		PacImage.setRotate(-90);
		if (Map.grid.getCell(xlocation-1, ylocation).getType() == Constants.OBSTACLE)
			return false;
		
		//Constants.PACMAN_IMAGE.setRotate();
	
		
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
			System.out.println("No previous highscores found");
			highscore = score;
			System.out.println(highscore);
			
		}
	}
	
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
	
	// Getters/setters

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
