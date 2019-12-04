//Imports-------------------------------------------
import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;

/**JAVADOC: Text based version of PacMan */
/**
 * 
 * @author Sami and Edward
 *
 */
public class TextGame extends Application
{
	/**
	 * Instance variables-------------------------------------------
	 */
	public static boolean isRunning;
	static int initIM = 1;
	static int initJM = 1;
	
	public static void main(String[] args) {
		
		Application.launch(args);

	}
	
	/**
	 * Getters/setters-------------------------------------------
	 * @param a 
	 */
	public void setIsRunning(boolean a)
	{
		isRunning = a;
	}
	public boolean getIsRunning()
	{
		return isRunning;
	}
	/**
	 * This function calls the regular start up method of the game but is not shown on the screen,
	 * then the already made objects are utilized to be printed instead onto the console
	 * @Override
	 */
	public void start(Stage stage) throws Exception 
	{
			// TODO Auto-generated method stub
			
		
	//Game starts here-------------------------------------------
	Scanner playerInput = new Scanner (System.in);
	Map map = new Map();

	map.generateMap(stage);

	isRunning = true;
	System.out.println("Welcome to text game version of Pacman!");
	System.out.println("Control Pacman 'C' and avoid the ghost 'X'.");
	System.out.println("Enter 'w' 'a' 's' 'd' keys to move Pacman around!");
	System.out.println("Or enter 'p' to exit the game");
	System.out.println("Collect the dots to increase your score!");
	System.out.println("                                     ");
	System.out.println("               PACMAN                  ");
	System.out.println("Score: " + Map.player.getScore() + "       		  Highscore: " + Map.player.getHighscore());
	map.grid.toConsole();
	
	Map.running = true;
	
	while(Map.running)
	{
		
		char input = playerInput.next().charAt(0); 
		//System.out.print("\033[H\033[2J"); <- For linux screen refresh
		
		
		if (input != 'a' && input != 's' &&  input != 'd' && input != 'w' && input != 'e')
		continue;
	
		map.redGhost.moveGhost();
		map.blueGhost.moveGhost();
		
		if(input=='a')
			map.player.moveLeft();
		else if(input == 's')
			map.player.moveDown();
		else if(input == 'd')
			map.player.moveRight();
		else if(input == 'w')
			map.player.moveUp();
		else if(input == 'e')
			System.exit(1);
		
		System.out.println("               PACMAN                  ");
		System.out.println("Score: " + Map.player.getScore() + "        	  Highscore: " + Map.player.getHighscore());
		map.grid.toConsole();
			}
	
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("               GAME OVER                  ");
	System.out.println("Score: " + Map.player.getScore() + "          		Highscore: " + Map.player.getHighscore());
	System.out.println("Enter 'e' to exit");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	System.out.println("                                     ");
	
	char input = playerInput.next().charAt(0); 
	if(input == 'e' || input == 'E')
		System.exit(1);
		}
	}
