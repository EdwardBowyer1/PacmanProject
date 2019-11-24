


//import java.awt.Color;
//import java.awt.Font;
import java.util.ArrayList;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Sami
 *
 */
public class Map {
	
	//Instance variables-------------------------------------------
	protected static Pane root;
	public static Grid grid;
	public static Timeline timeLine;
	public static Scene scene;
	public static Stage stage;
	public static Text score, highscore;
	//public static Boolean noMoreFood = false;
	public static int foodCount = 0;
	public static int originalFoodCount;
	
	//intital starting point of pacman, matrix notation
	static int initIM = 1;
	static int initJM = 1;
	
	private static Location startLocation = new Location(initIM, initJM);
	private static Location ghostStartLocation = new Location(1,5);
	private static Location scorePosition = new Location(0.5,0.2);

	public static Pacman player = new Pacman(startLocation);
	public static Ghost redGhost = new Ghost (ghostStartLocation);
	public static ArrayList<Location> obstacles = new ArrayList<>();

	//Constructors-------------------------------------------------
	public Map()
	{
		
	}

	public  Stage generateMap (Stage primaryStage){ 
		stage = primaryStage;
		//loading pacman GIF from constants to imageView class
	
		root = new Pane(); 
		root.setStyle("-fx-background-color: black");

		double ScreenW = Constants.screenWidth;
		double ScreenH = Constants.screenHeight;
		
		initializeObstacles();
		
		stage.setTitle("Pacman Demo2");
		
		
		// HERE IS WHERE THE INITIAL GRID POPULATING OCCURS--------------------------------------------------------------------------------
		initGrid();
		
		
        originalFoodCount = foodCount;

		
		Scene scene = new Scene(root,ScreenW,ScreenH);
	    stage.setScene(scene);

	   
		return stage;
	

		
		
	}
	
	
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
	public static  void redrawMap()
	{

		
		
		//Location.initScreenDimensions();

		
		root.getChildren().clear();
		
		//redrawwing the map from the grid and checking to see if the food is finished
		if(foodCount==0)
		{
			//should be resetting the map
			initGrid();
			grid.toConsole();
			foodCount = originalFoodCount;
		}
//		
//		int completeFood = 0;
		for (int i = 0;i < Constants.gridHeight;i++)
		{
			for (int j = 0;j < Constants.gridWidth;j++)
			{
                root.getChildren().add(grid.getCell(i, j).getNode());
                
                
            }
		}

			root.getChildren().add(player.getNode());
		
			root.getChildren().add(redGhost.getNode());
		
			
			score  = new Text();
			highscore = new Text();
			
			String S = "Score : "+player.getScore();
			String H = "Highscore:";
			
			score = setText(score,scorePosition,S);
			highscore = setText(highscore,new Location(0.5,10),H);
			
			root.getChildren().add(score);
			root.getChildren().add(highscore);
			
			root.requestFocus();
	}
	
	public static Text setText(Text text, Location scorePosition, String textV )
	{
		 text.setY(scorePosition.getPixelH());
		 text.setX(scorePosition.getPixelW());
		 //System.out.print(scorePosition.getPixelW() +  "height:"+scorePosition.getPixelH() +"here" );
		 text.setText(textV);
		 text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		 text.setFill(Color.WHITE);

		 text.setStroke(Color.LIGHTGOLDENRODYELLOW); 
		return text;
		
	}
	
	public static void arrowKeyListener()
	{
		root.setOnKeyPressed(event -> {
		
		if (event.getCode() == KeyCode.UP)
		{
			player.moveUp();
			redrawMap();
		}
		else if (event.getCode() == KeyCode.DOWN)
		{
			player.moveDown();
			redrawMap();
		}
		else if (event.getCode() == KeyCode.LEFT)
		{	
			player.moveLeft();
			redrawMap();
		}
		else if (event.getCode() == KeyCode.RIGHT)
		{
			player.moveRight();
			redrawMap();
		}
		else if (event.getCode() == KeyCode.ESCAPE)
		{
			redrawMap();
			//code to pause game
		}
		else if(event.getCode() == KeyCode.E)
		{
			foodCount = 0;
			redrawMap();
			
		}
		  //event.consume();
		redrawMap();
	});
		
	}
	
	public static void gameOver()
	{
		
		System.exit(1);
	}
	
public static void startTimeline(){
    	
	//here we control the rate at which the ghost moves in miliseconds
    	timeLine = new Timeline(new KeyFrame(Duration.millis(200), event ->
    	{
    		redGhost.moveGhost();
    		eeeeredrawMap();
    			}));
    	timeLine.setCycleCount(Timeline.INDEFINITE);
    	timeLine.play();
    	
    }

public static void initGrid()
{
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
        	System.out.print(type);

        	Cell cell = new Cell(cellLocation,type);
        	grid.addCell(cell);
        	
        	
            root.getChildren().add(cell.getNode());
        }
    	System.out.println();
    }
    
}

			
	//-----Getters-------------------------------	
		
		public Pacman getPlayer() 
		{
			return player;
		}
			
			
			
	//-----Setters-------------------------------


}
