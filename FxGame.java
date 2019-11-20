

import java.util.Scanner;


import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;



public class FxGame extends Application{
	
	public static void main(String[] args) {
		
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	
        Location.initScreenDimensions();
        
//        Map map = new Map();
       
        Map.generateMap(primaryStage).show();
        
        Map.arrowKeyListener();
        
        Map.redrawMap();
		
		Map.startTimeline();
//		BackgroundFill myBF = new BackgroundFill(Color.BLACK, new CornerRadii(1),
//		         new Insets(0.0,0.0,0.0,0.0));// or null for the padding
//		//then you set to your node or container or layout
//		root.setBackground(new Background(myBF));
		
	
			
			
		

        
	}
}


