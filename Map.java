


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
	private static Grid grid;
	static Timeline timeLine;
	static Scene scene;
	static Stage stage;
	static ImageView iView = new ImageView(Constants.GIFPacRight);
	
	private Pacman player;
	private int height;
	private int width;
	private Location startLocation;

	//Constructors-------------------------------------------------
	public Map()
	{
//		setHeight(grid.length); //consider making a wrapper class for length;
//		setWidth(grid[0].length);
		startLocation = new Location((width-1)/2, (height-1)/2);
		player = new Pacman(startLocation);
	}
	//Methods------------------------------------------------------
	
	public static void movePac(double x, double y)
	{
		double OGX = iView.getX();
		double OGY = iView.getY();
		if((OGX + x)>=0 && (OGY + y)>=0 && (OGY + y)<=Constants.screenHeight && (OGX + 2*x)<=Constants.screenWidth)
		{
			iView.setX(OGX + x);
			iView.setY(OGY + y);
		}
		root.getChildren().add(iView);
	}

	public static Stage generateMap (Stage primaryStage){ //start here--------------------------------------------------------------------
		stage = primaryStage;
		//loading pacman GIF from constants to imageView class
	
		root = new Pane(); 
		root.setStyle("-fx-background-color: black");

		double ScreenW = Constants.screenWidth;
		double ScreenH = Constants.screenHeight;
		FxGame myapp = new FxGame();
		
		
		stage.setTitle("Pacman Demo2");
		
	
		
	

		
		//setting dimensions of pacman GIF
		iView.setFitHeight(Constants.cellHeight); 
	    iView.setFitWidth(Constants.cellWidth); 
	    
	    //Placing pacman in centre of screen
		iView.setX((ScreenW-Constants.cellWidth)/2);
		iView.setY((ScreenH-Constants.cellHeight)/2);

		
		
		 //iView.setPreserveRatio(true);  
		 
		root.getChildren().add(iView);
		
		Scene scene = new Scene(root,ScreenW,ScreenH);
	    stage.setScene(scene);

	   
		return stage;
	

		
		
	}
	
	public static void arrowKeyListener()
	{
		root.setOnKeyPressed(event -> {
			root.getChildren().clear();
		
		if (event.getCode() == KeyCode.UP)
		{
			iView.setRotate(-90);
			movePac(0, -Constants.cellHeight);    			
		}
		else if (event.getCode() == KeyCode.DOWN)
		{
			iView.setRotate(90);
			movePac(0, Constants.cellHeight);
		}
		else if (event.getCode() == KeyCode.LEFT)
		{	
			iView.setRotate(180);
			movePac(-Constants.cellWidth, 0);
		}
		else if (event.getCode() == KeyCode.RIGHT)
		{
			iView.setRotate(0);
			movePac(Constants.cellWidth,0);
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
	//Map m1 = new Map();
	// Argument is the input from console 
	
	// Returns true if the space in front of the character is empty (not a 1 on the grid).
	
//		public boolean canMoveCharacter(char directionInput) 
//		{
//			int PacX = player.getCoordinate().getXlocation() ;
//			int PacY = player.getCoordinate().getYlocation();
//			if(directionInput == 'w')
//			{
//				System.out.println("Next grid element: " +grid[PacX][PacY-1]); //meant to debug the issue of 
//																			   //not being able to access block before wall(width). 
//				if(grid[PacX][PacY-1] != 1)
//				{
//					return true;
//				}
//			}
//			else if(directionInput == 's')
//			{
//				System.out.println("Next grid element: " +grid[PacX][PacY+1]);
//				if(grid[PacX][PacY+2] != 1)
//				{
//					return true;
//				}
//			}
//			else if(directionInput == 'a')
//			{
//				System.out.println("Next grid element: " +grid[PacX-1][PacY]);
//				if(grid[PacX-1][PacY] != 1)
//				{
//					return true;
//				}
//			}
//		
//			else if(directionInput == 'd')
//			{
//				System.out.println("Next grid element: " +grid[PacX+1][PacY]);
//				if(grid[PacX+1][PacY] != 1)
//				{
//					return true;
//				}
//			}
//				return false;
//		}
//		
//		public void printMap()
//		{
//			//need the character coordintes of pacman, setting local variable
//			int PacX = player.getCoordinate().getXlocation();
//			int PacY = player.getCoordinate().getYlocation();
//			 //these loops print out the grid to whatever we want to graphically output
//			for(int i = 0; i< height; i++)
//			{
//				for(int j = 0; j< width; j++)
//				{
//					if (j == PacX && i == PacY) //must check this first
//						System.out.print('C');
//					else if(grid[i][j] == 0)
//						System.out.print(' ');
//					else if(grid[i][j] == 1)
//						System.out.print('#');
//				}
//				System.out.println();
//			}
//		}
			
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
