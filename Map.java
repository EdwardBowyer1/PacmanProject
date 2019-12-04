
//import java.awt.Color;
//import java.awt.Font;
import java.util.ArrayList;


import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import junit.framework.Test;

/**
 * This class is implemented to statically keep track of the GUI, but contains instance of all the other classes implemented.
 * @author Sami
 *
 */
public class Map {
	
	/**
	 * Instance variables----------------------------------------------------------------------------------------
	 */
	public static boolean running =true;
	
	//intital starting point of pacman, matrix notation
	static int initIM = 1;
	static int initJM = 1;
	
	//javafx variables
	protected static Pane root;
	public static Grid grid;
	public static Timeline timeLine;
	public static Scene scene;
	public static Stage stage;
	public static Text score, highscore;

	//food 
	public static int foodCount = 0;
	public static int originalFoodCount;
	

	//initial locations
	private static Location startLocation = new Location(initIM, initJM);
	private static Location REDghostStartLocation = new Location(Constants.gridHeight-2,Constants.gridHeight-2);
	private static Location BLUEghostStartLocation = new Location(Constants.gridHeight-2,1);
	private static Location scorePosition = new Location(0.5,0.2);

	//Character initializations
	public static Pacman player = new Pacman(startLocation);
	public static Ghost redGhost = new Ghost (REDghostStartLocation);
	public static Ghost blueGhost = new Ghost(BLUEghostStartLocation);
	
	//list of obstacles
	public static ArrayList<Location> obstacles = new ArrayList<>();

	/**
	 * 
	 * @param primaryStage Retrieves the Stage from FxGame file to add a pane and 
	 * a scene to it.
	 * @return Returns the stage ready to be shown.
	 */
	public  Stage generateMap (Stage primaryStage){ 
		stage = primaryStage;

		root = new Pane(); 
		root.setStyle("-fx-background-color: black");

		double ScreenW = Constants.screenWidth;
		double ScreenH = Constants.screenHeight;
		
		initializeObstacles();
		
		stage.setTitle("Pacman");
		
		
		// HERE IS WHERE THE INITIAL GRID POPULATING OCCURS and Pacman and the ghosts are initialized--------------------------------------------------------------------------------
//		 player = new Pacman(startLocation);
//		 redGhost = new Ghost (REDghostStartLocation);
//		 
		initGrid();
		
		
        originalFoodCount = foodCount;

		
		Scene scene = new Scene(root,ScreenW,ScreenH);
	    stage.setScene(scene);

		return stage;
	

		
		
	}

	
	/**
	 * Responsible for creating the layout of the of the obstacles 
	 * in the GUI.
	 */
	public static void initializeObstacles()
	{

	
		for(int i = 2; i<Constants.gridWidth-2; i++)
		{
			for(int j=2; j<Constants.gridHeight-1; j++) {
				if(i!=7 && j%2==0) {
					obstacles.add(new Location(j, i));

				}
		}
		}

			
		
		
		
	}
	/**
	 * 
	 * @param pObstacle: Location on the map of the potential obstacle
	 * @return True if the location is matches the arraylist of obstacle locations
	 * 		   False otherwise
	 */
	public static boolean isObstacle(Location pObstacle)
	{
		for(int i = 0; i<obstacles.size(); i++)
		{
			if(pObstacle.isEqual(obstacles.get(i)))
				return true;
		}
			return false;
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------*********************************************************
	/**
	 * Responsible for updating the map everytime an action occurs
	 * such as food being consumed by pacman or if the ghost AI
	 * moves the ghost.
	 */
	
	public static  void redrawMap()
	{
		
		root.setStyle("-fx-background-color: black");
		if(running) {
			root.setStyle("-fx-background-color: black");
		root.getChildren().clear();
		
		//redrawing the map from the grid and checking to see if the food is finished
		if(foodCount==0)
		{
			//should be resetting the map
			initGrid();
			foodCount = originalFoodCount;
		}

		for (int i = 0;i < Constants.gridHeight;i++)
		{
			for (int j = 0;j < Constants.gridWidth;j++)
			{
                root.getChildren().add(grid.getCell(i, j).getNode());
                
                
            }
		}

			root.getChildren().add(player.getNode());
		
			root.getChildren().add(redGhost.getNode());
		
			root.getChildren().add(blueGhost.getNodeB());
			
			score  = new Text();
			highscore = new Text();
			
			score = setText(scorePosition,"Score : "+ Integer.toString(player.getScore()),20);
			highscore = setText(new Location(0.5,10),"High Score : " + player.getHighscore(),20); // + retrieveHighscore());
			
			root.getChildren().add(score);
			root.getChildren().add(highscore);
			
			root.requestFocus();
		}
	}
	
	/**
	 * 
	 * @param scorePosition
	 * @param textV
	 * @param size
	 * @return Sets the JavaFX node of Text to be added to the Pane.
	 */
	public static Text setText(Location scorePosition, String textV, int size )
	{
		Text text = new Text();
		 text.setY(scorePosition.getPixelH());
		 text.setX(scorePosition.getPixelW());
		 text.setText(textV);
		 text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, size));
		 text.setFill(Color.AZURE);

		 text.setStroke(Color.LIGHTGOLDENRODYELLOW); 
		return text;
		
	}
	
	/**
	 * Listener for Pacman's movement around the map.
	 * Calls the move functions of Pacman to traverse
	 * the map.
	 */
	public static void arrowKeyListener()
	{
		
		root.setOnKeyPressed(event -> {
		
		if (event.getCode() == KeyCode.UP)
		{
			player.moveUp();
			
		}
		else if (event.getCode() == KeyCode.DOWN)
		{
			player.moveDown();
	
		}
		else if (event.getCode() == KeyCode.LEFT)
		{	
			player.moveLeft();

		}
		else if (event.getCode() == KeyCode.RIGHT)
		{
			player.moveRight();

		}
		else if (event.getCode() == KeyCode.ESCAPE)
		{
			gameOver();
			//code to end game
		}
		else if(event.getCode() == KeyCode.E)
		{
			foodCount = 0;
			redrawMap();
			
		}
		root.requestFocus();
		event.consume();
	});
		
	}
	
	/**
	 * Function that is called when Pacman is caught, stops all threads related
	 * to ghost and redrawing of the map through boolean checker
	 */
	public static void gameOver()
	{

		running = false;
		root.getChildren().clear(); //removing all nodes from scene
		
		//saving the highscore of pacman
		player.saveHighscore(player.getHscore());
		
		
		//creating the texts for the "GAME OVER" screen
		score  = new Text();
		highscore = new Text();
		

		//adding a background image 
		   final ImageView imageView = new ImageView(
				      new Image("GameOver.jpg")
				      );
				    imageView.setFitHeight(Constants.screenHeight);
				    imageView.setFitWidth(Constants.screenWidth);
	  
				    root.setStyle("-fx-background-color: rgba(0, 50, 50, 0.5); -fx-background-radius: 10;");
				    root.setMaxWidth(imageView.getFitWidth() - 40);
				   root.setMaxHeight(imageView.getFitHeight() - 40);
		
				   
		//creating the Text objects to be added to the pane		   
		Text over = setText(new Location(Constants.gridHeight/2 ,Constants.gridWidth/2 -1.7), "GAME OVER",40 );
		over.setFill(Color.RED);
		score = setText(new Location(Constants.gridHeight/2 +2,Constants.gridWidth/2 - 5) ,"Score : "+ Integer.toString(player.getScore()),30);
		highscore = setText(new Location(Constants.gridHeight/2 +2,Constants.gridWidth/2 + 3),"High Score : " + Integer.toString(player.getHighscore()),30); // + retrieveHighscore());
		Text restart =  setText(new Location(Constants.gridHeight/2 +4,Constants.gridWidth/2 -3.5),"PRESS SPACEBAR TO RESTART  ",30); // + retrieveHighscore());
		
		
		root.getChildren().addAll(imageView,score,highscore,over,restart);

		
		endGameListener();
	}
	/**
	 * Allows the the option to restart or end the game when PacMan is killed
	 * Through user input
	 */
	public static void endGameListener()
	{
		if(running == false) {
		root.setOnKeyPressed(event -> {
		
			//Restarting the Game
		if (event.getCode() == KeyCode.SPACE)
		{
			 player = new Pacman(startLocation);
			 redGhost = new Ghost (REDghostStartLocation);
			 blueGhost = new Ghost (BLUEghostStartLocation);

			running = true;
			
			initGrid();
		}
		if (event.getCode() == KeyCode.ESCAPE)
		{
			System.exit(1);
		}
	});
		}
	}
	
	/**
	 * Begins the loop for the ghost to start moving periodically
	 */
public static void startTimeline(){
    	
	//here we control the rate at which the ghost moves in miliseconds
	if(running) {
    	timeLine = new Timeline(new KeyFrame(Duration.millis(200), event ->
    	{
    		blueGhost.moveGhost();
    		redGhost.moveGhost();
    		redrawMap();
    			}));
    	timeLine.setCycleCount(Timeline.INDEFINITE);
    	timeLine.play();
	}
    }


/**
 * Initializes the grid to start values,
 * Also intializes PacMan and ghosts to their original locations,
 * Invokes the arrowkey listener
 */
public static void initGrid()
{
	arrowKeyListener();
	grid = new Grid();

    for (int i =0;i< Constants.gridHeight;i++){
    	
        for (int j =0;j< Constants.gridWidth;j++){
        	
        	Location cellLocation = new Location(i,j);
        	
        	
        	//Check if not boundary
        	int type = Constants.OBSTACLE;
        	if ( j != Constants.gridWidth-1 && i != Constants.gridHeight-1 && i != 0 && j!= 0){
        		if (j == player.getCoordinate().getYlocation() && i ==player.getCoordinate().getXlocation())
        			type = Constants.EMPTY;
        		
        		else if (isObstacle(cellLocation))
        			type = Constants.OBSTACLE;
        		
        		else {
        			type = Constants.FOOD;
        			foodCount++;
        		}
        		
        		
        	}

        	Cell cell = new Cell(cellLocation,type);
        	grid.addCell(cell);
        	
        	
            root.getChildren().add(cell.getNode());
        }

    }
    
}

			
	/**
	 * -----Getters-------------------------------	
	 * @return
	 */
		
		public Pacman getPlayer() 
		{
			return player;
		}
			
			
		

}
