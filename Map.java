


import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Map {
	
	//Instance variables-------------------------------------------
	protected static Pane root;
	public static Grid grid;
	static Timeline timeLine;
	static Scene scene;
	static Stage stage;
	static ImageView iView = new ImageView(Constants.GIFPacRight);
	
	
	private int height;
	private int width;
	private static Location startLocation = new Location(1,1);
	public static Pacman player = new Pacman(startLocation);
	public static ArrayList<Location> obstacles = new ArrayList<>();

	//Constructors-------------------------------------------------
	public Map()
	{
//		setHeight(grid.length); //consider making a wrapper class for length;
//		setWidth(grid[0].length);
	}
	//Methods------------------------------------------------------
	
//	public static void movePac(double x, double y)
//	{
//		double OGX = iView.getX();
//		double OGY = iView.getY();
//		if((OGX + x)>=0 && (OGY + y)>=0 && (OGY + y)<=Constants.screenHeight && (OGX + 2*x)<=Constants.screenWidth)
//		{
//			iView.setX(OGX + x);
//			iView.setY(OGY + y);
//		}
//		root.getChildren().add(iView);
//	}

	public static Stage generateMap (Stage primaryStage){ //start here--------------------------------------------------------------------
		stage = primaryStage;
		//loading pacman GIF from constants to imageView class
	
		root = new Pane(); 
		root.setStyle("-fx-background-color: black");

		double ScreenW = Constants.screenWidth;
		double ScreenH = Constants.screenHeight;
		FxGame myapp = new FxGame();
		
		initializeObstacles();
		
		stage.setTitle("Pacman Demo2");
		
		grid = new Grid();
	
		 
        for (int i =0;i< Constants.gridWidth;i++){
        	
            for (int j =0;j< Constants.gridHeight;j++){
            	
            	Location cellLocation = new Location(i,j);
            	//Random random = new Random();
            	int type = Constants.OBSTACLE;
            	
            	//Check if not boundary
            	if ( i != Constants.gridWidth-1 && j != Constants.gridHeight-1 && i != 0 && j!= 0){
            		if (i == 1 && j ==1)
            			type = Constants.EMPTY;
            		
            		else if (isObstacle(cellLocation))
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
		obstacles.add(new Location(2, 2));
		obstacles.add(new Location(2, 3));
		obstacles.add(new Location(2, 4));
		obstacles.add(new Location(2, 6));
		obstacles.add(new Location(2, 7));
		obstacles.add(new Location(2, 8));
		obstacles.add(new Location(2, 12));
		obstacles.add(new Location(2, 13));
		
		obstacles.add(new Location(13, 2));
		obstacles.add(new Location(13, 3));
		obstacles.add(new Location(13, 4));
		obstacles.add(new Location(13, 6));
		obstacles.add(new Location(13, 7));
		obstacles.add(new Location(13, 8));
		obstacles.add(new Location(13, 12));
		obstacles.add(new Location(13, 13));
		
		obstacles.add(new Location(20, 2));
		obstacles.add(new Location(20, 3));
		obstacles.add(new Location(20, 4));
		obstacles.add(new Location(20, 6));
		obstacles.add(new Location(20, 7));
		obstacles.add(new Location(20, 8));
		obstacles.add(new Location(20, 12));
		obstacles.add(new Location(20, 13));
		
		
	}
	public static boolean isObstacle(Location pObstacle)
	{
		for(int i = 0; i<obstacles.size(); i++)
		{
			if(pObstacle.getXlocation() == obstacles.get(i).getXlocation() 
					&& pObstacle.getYlocation() == obstacles.get(i).getYlocation() )
				return true;
		}
			return false;
	}
	
	public static  void redrawMap()
	{

		
		
		Location.initScreenDimensions();

		
		root.getChildren().clear();
		
		for (int i = 0;i < Constants.gridHeight;i++)
			for (int j = 0;j < Constants.gridWidth;j++)
                root.getChildren().add(grid.getCell(i, j).getNode());
	
				
			root.getChildren().add(player.getNode());
		
		//	root.getChildren().add(ghost1.getNode());
		
			
//			Position scorePosition = new Position(1, Constants.COLUMN_CELL_COUNT-2);
//			Text text = new Text(scorePosition.x-30,scorePosition.y-10,"SCORE : "+Pacman.Score);
//			text.setFill(Constants.PACMAN_COLOR);
//			text.setFont(Font.font("IMPACT", Constants.screenWidth/35));
//			
//			root.getChildren().add(text);
//		
			
			root.requestFocus();
	}
	
	public static void arrowKeyListener()
	{
		root.setOnKeyPressed(event -> {
			root.getChildren().clear();
		
		if (event.getCode() == KeyCode.UP)
		{
			//iView.setRotate(-90);
			player.moveUp();
			redrawMap();
		}
		else if (event.getCode() == KeyCode.DOWN)
		{
			//iView.setRotate(90);
			player.moveDown();
			redrawMap();
		}
		else if (event.getCode() == KeyCode.LEFT)
		{	
			//iView.setRotate(180);
			player.moveLeft();
			redrawMap();
		}
		else if (event.getCode() == KeyCode.RIGHT)
		{
			//iView.setRotate(0);
			player.moveRight();
			redrawMap();
		}
		  event.consume();
	});
		iView.setFocusTraversable(true);
	}
public static void startTimeline(){
    	
    	timeLine = new Timeline(new KeyFrame(Duration.millis(250), event -> {
        	
    			}));
    	timeLine.setCycleCount(Timeline.INDEFINITE);
    	timeLine.play();
    	
    }

			
	//-----Getters-------------------------------	
		public int getHeight() 
		{
			return height;
		}
			
		public int getWidth() 
		{
			return width;
		}
		
		public Pacman getPlayer() 
		{
			return player;
		}
			
			
			
	//-----Setters-------------------------------
		private void setHeight(int h)
		{
			height = h;
		}
		private void setWidth(int w)
		{
			width = w;
		}


}
