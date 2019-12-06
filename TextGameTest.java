import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextGameTest {

	@Test
	public void test() {
		JFXPanel j = new JFXPanel();
		Location scorePosition = new Location(15,0);

		Map map = new Map();
		Text text = new Text();
		text.setY(850);
		text.setX(0);
		text.setText("");
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		text.setFill(Color.AZURE);
		text.setStroke(Color.LIGHTGOLDENRODYELLOW);
		assertEquals(text,Map.setText(scorePosition, "", 12));
	}
	@Test
	public void test2() {
		JFXPanel j = new JFXPanel();
		Location p = new Location(7,8);
		assertFalse(Map.isObstacle(p));

	}
}

