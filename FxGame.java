

import javafx.application.Application;
import javafx.stage.Stage;


/**JAVADOC: GUI version of PacMan */
/**
 * 
 * @author Sami
 *
 */
public class FxGame extends Application{

	public static void main(String[] args) {

		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {


		Map map = new Map();

		map.generateMap(primaryStage).show();
		primaryStage.setTitle("P A C M A N");
		map.startTimeline();



	}
}


