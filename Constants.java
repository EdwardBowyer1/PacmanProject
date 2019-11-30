import javafx.geometry.Rectangle2D;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.stage.Screen;

public class Constants
{
		//grid width and height. 
		public static int gridWidth = 15;  //number of columns of the grid
		public static int gridHeight = 15; //number of rows of the grid
		
		//number of pixels of the screen horizontally/vertically from origin
		public  static double screenWidth = 1000;//1920.0;//grid_width*cellWidth;
		public  static double screenHeight = 850;//1040.0 ; //grid_height*cellHeight;
		
		//number of pixels of each the width/height of each individual cell 
		public static double cellWidth = screenWidth/gridWidth;
		public static double cellHeight = screenHeight/gridHeight;


		public static int EMPTY = 0;
		public static int OBSTACLE = 1;
		public static int FOOD = 2;
		
		public static int highscore = 0;

//		public static Color BORDR_COLOR = Color.BLUE;
		public static Color OBSTACLE_COLOR = 	Color.YELLOW;
		public static Color EMPTY_COLOUR = 	Color.BLACK;
		public static Color FOOD_COLOUR = 	Color.WHITE; 
//		public static Color PACMAN_COLOR = 	Color.YELLOW;
		//public static Color GHOST1_COLOR = 	Color.GREEN;
		//public static Color GAMEOVER_RECTANGLE_COLOR = 	Color.DARKGRAY;
		//public static Color GAMEOVER_RECTANGLE_STROKE_COLOR = 	Color.RED;

		public static Image GIFRedGhost = new Image("redGhost.gif");
		public static Image GIFPacRight = new Image("pacmanRight.gif"); 
		public static Image Wall = new Image("wall.png");

	
		

}
