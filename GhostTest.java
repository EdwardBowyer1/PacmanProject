import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

/**
 * This is a junit test class for Ghost.java, it tests the move methods of the Ghost class.
 * @author Medhanie 
 */
public class GhostTest  {

	public static void start(){
	try {
		Map map = new Map();
		map.generateMap(Map.stage);
		}
	
	catch(Exception e) {
        System.out.println("caught exception");
        }
	}

	/**
	 * initializes the Stage and executes before each test method
	 */
	@BeforeClass
	public static void executedBeforeEach()
	{
		new JFXPanel();
		start();
	}


    /**
	 * testing the constructor 
	 */
    @Test
    public void testConstructor()
	{
		Location ghostlocation = new Location(8,6);
        Ghost ghost = new Ghost(ghostlocation);
        assertEquals (6, ghost.getCoordinate().getYlocation(), 0.001); //testing if ghost's row location has been set to 6
        assertEquals (8, ghost.getCoordinate().getXlocation(), 0.001); //testing if ghost's column location has been set to 8
    }


    /**
	 * testing if ghost's row location Decrements by 1 when it moves up
	 */
	@Test
	public void hasMovedUp() 
	{
		Location ghostlocation = new Location(8,8);
        Ghost ghost = new Ghost(ghostlocation);
		ghost.moveUp();
		assertEquals (7, ghost.getCoordinate().getXlocation(), 0.001);
	}

	/**
	 * testing if ghost can move up when there is no obstacle above it
	 */
	@Test
	public void canMoveUp() 
	{
		Location ghostlocation = new Location(8,8);
        Ghost ghost = new Ghost(ghostlocation);
		assertTrue(ghost.moveUp());
	}

	/**
	 * testing if ghost can not move up due to an obstacle above it
	 */
	@Test
	public void canNotMoveUp() 
	{
		Location ghostlocation = new Location(3,9);
        Ghost ghost = new Ghost(ghostlocation); 
		assertFalse(ghost.moveUp());    //expecting ghost unable to move up since the new position to be at (2,9) is an obstacle
	}

	/**
	 * testing if ghost's row location increments by 1 when it moves down
	 */
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

    /**
	 * testing if ghost's column location Decrements by 1 when it moves left
	 */
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



    /**
	 * testing if ghost's column location increments by 1 when it moves right
	 */
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




