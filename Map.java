


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

public class Map {
	
	//Instance variables-------------------------------------------
	protected static Pane root;
	public static Grid grid;
	public static Grid originalGrid;
	public static Timeline timeLine;
	public static Scene scene;
	public static Stage stage;
	public static Text text;
	//public static Boolean noMoreFood = false;
	public static int foodCount = 0;
	public static int originalFoodCount;
	
	//intital starting point of pacman, matrix notation
	static int initIM = 1;
	static int initJM = 1;
	
	private static Location startLocation = new Location(initIM, initJM);
	private static Location ghostStartLocation = new Location(1,5);
	private static Location scorePosition = new Location(1,Constants.gridWidth/2-2);

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
        
        originalFoodCount = foodCount;
        originalGrid = new Grid(grid);
		
        Location scorePosition = new Location(0, Constants.gridWidth-5);
		 //iView.setPreserveRatio(true);  
        
        //create function for this
        text = new Text();

		 
		 root.getChildren().add(text);

		
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
			grid = new Grid(originalGrid);
			grid.toConsole();
			foodCount = originalFoodCount;
		}
//		
//		int completeFood = 0;
		for (int i = 0;i < Constants.gridHeight-1;i++)
		{
			for (int j = 0;j < Constants.gridWidth-1;j++)
			{
                root.getChildren().add(grid.getCell(i, j).getNode());
                
                
            }
		}

			root.getChildren().add(player.getNode());
		
			root.getChildren().add(redGhost.getNode());
		
			
			text = new Text();
			 text.setY(scorePosition.getPixelH()-20);
			 text.setX(scorePosition.getPixelW()+100);
			 //System.out.print(scorePosition.getPixelW() +  "height:"+scorePosition.getPixelH() +"here" );
			 text.setText("Score : "+player.getScore());
			 text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			 text.setFill(Color.WHITE);

			 text.setStroke(Color.LIGHTGOLDENRODYELLOW); 
			
			
			root.getChildren().add(text);
		
			
			root.requestFocus();
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
    	timeLine = new Timeline(new KeyFrame(Duration.millis(500), event -> {
    		redGhost.moveGhost();
    		
    			}));
    	timeLine.setCycleCount(Timeline.INDEFINITE);
    	timeLine.play();
    	
    }

			
	//-----Getters-------------------------------	
		
		public Pacman getPlayer() 
		{
			return player;
		}
			
			
			
	//-----Setters-------------------------------


}
