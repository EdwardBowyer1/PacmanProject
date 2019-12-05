import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;


public class GhostTest extends Application {

	public void start(Stage arg0) throws NullPointerException{
	try {
		Map map = new Map();
		map.generateMap(arg0);
		}
	
	catch(NullPointerException e) {
        System.out.println("");
        }
	}

	
	@Before
	public void executedBeforeEach()
	{
		new JFXPanel();
		start(Map.stage);
	}


	@Test
    	public void testConstructor()
	{
		Location ghostlocation = new Location(8,6);
        Ghost ghost = new Ghost(ghostlocation);
        assertEquals (6, ghost.getCoordinate().getYlocation(), 0.001); //testing if ghost's ylocation has been set
        assertEquals (8, ghost.getCoordinate().getXlocation(), 0.001); //testing if ghost's xlocation has been set
    }


	@Test
	public void hasMovedUp() 
	{
		Location ghostlocation = new Location(8,8);
        Ghost ghost = new Ghost(ghostlocation);
		ghost.moveUp();
		assertEquals (7, ghost.getCoordinate().getXlocation(), 0.001);
	}

	
	@Test
	public void canMoveUp() 
	{
		Location ghostlocation = new Location(8,8);
        Ghost ghost = new Ghost(ghostlocation);
		assertTrue(ghost.moveUp());
	}

	
	@Test
	public void canNotMoveUp() 
	{
		Location ghostlocation = new Location(3,9);
        Ghost ghost = new Ghost(ghostlocation);
		assertFalse(ghost.moveUp());
	}

	
	@Test
	public void hasMovedDown() 
	{
		Location ghostlocation = new Location(8,9);
        Ghost ghost = new Ghost(ghostlocation);
		ghost.moveDown();
		assertEquals (9, ghost.getCoordinate().getXlocation(), 0.001);
	}
	
	
	@Test
	 public void canMoveDown()
	{
		Location ghostlocation = new Location(8,9);
	    Ghost ghost = new Ghost(ghostlocation);
	    assertTrue(ghost.moveDown());

	}

	 
	@Test
	 public void canNotMoveDown() 
	{
		Location ghostlocation = new Location(13,10);
		Ghost ghost = new Ghost(ghostlocation);
		assertFalse(ghost.moveDown());
	}


	@Test
	public void hasMovedLeft() 
	{
		Location ghostlocation = new Location(4,8);
        Ghost ghost = new Ghost(ghostlocation);
		ghost.moveLeft();
		assertEquals (7, ghost.getCoordinate().getYlocation(), 0.001);
	}


	@Test
	public void canMoveLeft() 
	{
		Location ghostlocation = new Location(2,8);
        Ghost ghost = new Ghost(ghostlocation);
        assertTrue(ghost.moveLeft());
	}

	
	@Test
	public void canNotMoveLeft() 
	{
		Location ghostlocation = new Location(4,1);
        Ghost ghost = new Ghost(ghostlocation);
        assertFalse(ghost.moveLeft());
	}




	@Test
	public void canMoveRight()
	{
		Location ghostlocation = new Location(1,1);
        Ghost ghost = new Ghost(ghostlocation);
		assertTrue(ghost.moveRight());
	}

	
	@Test
	public void canNotMoveRight()
	{
		new JFXPanel();
		start(Map.stage);
		Location ghostlocation = new Location(6,2);
        Ghost ghost = new Ghost(ghostlocation);
		assertFalse(ghost.moveRight());
	}


	@Test
	public void hasMovedRight()
	{
		Location ghostlocation = new Location(3,1);
        Ghost ghost = new Ghost(ghostlocation);
		ghost.moveRight();
        assertEquals (2, ghost.getCoordinate().getYlocation(), 0.001);
	}

}




