


import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Map {
	
	//Instance variables-------------------------------------------
	protected static Pane root;
	public static Grid grid;
	static Timeline timeLine;
	static Scene scene;
	static Stage stage;
	//static ImageView iView = new ImageView(Constants.GIFPacRight);
	//intital starting point of pacman, matrix notation
	static int initIM = 1;
	static int initJM = 5;
	
	private static Location startLocation = new Location(initIM, initJM);
	private static Location ghostStartLocation = new Location(1,5);

	public static Pacman player = new Pacman(startLocation);
	public static Ghost redGhost = new Ghost (ghostStartLocation);
	public static ArrayList<Location> obstacles = new ArrayList<>();

	//Constructors-------------------------------------------------
	public Map()
	{
		
	}

	public static Stage generateMap (Stage primaryStage){ //start here--------------------------------------------------------------------
		stage = primaryStage;
		//loading pacman GIF from constants to imageView class
	
		root = new Pane(); 
		root.setStyle("-fx-background-color: black");

		double ScreenW = Constants.screenWidth;
		double ScreenH = Constants.screenHeight;
		
		initializeObstacles();
		
		stage.setTitle("Pacman Demo2");
		
		grid = new Grid();
	
		 
        for (int i =0;i< Constants.gridHeight-1;i++){
        	
            for (int j =0;j< Constants.gridWidth-1;j++){
            	
            	Location cellLocation = new Location(i,j);
            	//Random random = new Random();
            	int type = Constants.OBSTACLE;
            	
            	//Check if not boundary
            	if ( j != Constants.gridWidth-1 && i != Constants.gridHeight-1 && i != 0 && j!= 0){
            		if (i == initIM && j ==initIM)
            			type = Constants.EMPTY;
            		
            		 if (isObstacle(cellLocation))
            			type = Constants.OBSTACLE;
            		
            		else
            			type = Constants.FOOD;
            	}

            		//type = random.nextInt(2 - 0 + 1) + 0;
            	Cell cell = new Cell(cellLocation,type);
            	grid.addCell(cell);
            	
            	
                root.getChildren().add(cell.getNode());
            }
        	
        }

		
		
		 //iView.setPreserveRatio(true);  
		
		Scene scene = new Scene(root,ScreenW,ScreenH);
	    stage.setScene(scene);

	   
		return stage;
	

		
		
	}
	
	
	public static void initializeObstacles()
	{
		obstacles.add(new Location(2, 7));
		obstacles.add(new Location(2, 8));
		obstacles.add(new Location(2, 13));
		obstacles.add(new Location(2, 14));
		obstacles.add(new Location(2, 15));
		obstacles.add(new Location(2, 21));
		obstacles.add(new Location(2, 22));
		obstacles.add(new Location(2, 23));
		
		obstacles.add(new Location(8, 7));
		obstacles.add(new Location(8, 8));
		obstacles.add(new Location(8, 13));
		obstacles.add(new Location(8, 14));
		obstacles.add(new Location(8, 15));
		obstacles.add(new Location(8, 21));
		obstacles.add(new Location(8, 22));
		obstacles.add(new Location(8, 23));
		
		obstacles.add(new Location(13, 7));
		obstacles.add(new Location(13, 8));
		obstacles.add(new Location(13, 13));
		obstacles.add(new Location(13, 14));
		obstacles.add(new Location(13, 15));
		obstacles.add(new Location(13, 21));
		obstacles.add(new Location(13, 22));
		obstacles.add(new Location(13, 23));
		
		
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
	
	public static  void redrawMap()
	{

		
		
		Location.initScreenDimensions();

		
		root.getChildren().clear();
		
		for (int i = 0;i < Constants.gridHeight-1;i++)
		{
			for (int j = 0;j < Constants.gridWidth-1;j++)
			{
                root.getChildren().add(grid.getCell(i, j).getNode());
               // System.out.print(grid.getCell(i, j).toString()); //debugging
			}
			//System.out.println(); //debugging
		}
				
			root.getChildren().add(player.getNode());
		
			root.getChildren().add(redGhost.getNode());
		
			
			Location scorePosition = new Location(1, (int)Constants.screenWidth);
			 Text text = new Text(scorePosition.getPixelH()-30,scorePosition.getPixelW()-10,"Score : "+player);
			 
//			Paint value = Color.blue;
//			Paint Font = 
//			text.setFill(value);
//			text.setFont(value);
			
			
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
		  //event.consume();
		redrawMap();
	});
		//iView.setFocusTraversable(true);
	}
public static void startTimeline(){
    	
	//here we control the rate at which the ghost moves in miliseconds
    	timeLine = new Timeline(new KeyFrame(Duration.millis(3000), event -> {
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
