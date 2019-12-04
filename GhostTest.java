import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;


public class GhostTest {

    @Test
    public void testConstructor(){
    	Location ghostlocation = new Location(8,6);
        Ghost ghost = new Ghost(ghostlocation);
        
        assertEquals (6, ghost.getCoordinate().getYlocation(), 0.001); //testing if ghost's ylocation has been set
        assertEquals (8, ghost.getCoordinate().getXlocation(), 0.001); //testing if ghost's xlocation has been set
    }

	
	
	@Test
	
    public void tesMoveup() {
		JFXPanel j = new JFXPanel();
		//Map.running = true;
		
		/*Location celLocation = new Location(4,4);
		Cell cell = new Cell(celLocation, 0);
		Map map = new Map();

		//Map.grid.addCell(cell);

	    //Grid grid = new Grid();
		//Map.initializeObstacles();

	   // Location pacLocation = new Location(8,8);
        //Pacman pacman = new Pacman(pacLocation);*/

        Location ghostlocation = new Location(8,8);
        Ghost ghost = new Ghost(ghostlocation);
        //Location p = new Location(6,7);
        ghost.moveUp();
        
        assertEquals (7, ghost.getCoordinate().getXlocation(), 0.001);
        
         if (ghost.moveUp()==true){
        	 assertEquals (7, ghost.getCoordinate().getXlocation(), 0.001);
        }
       /* if(Map.isObstacle(p)==false){
        //	assertTrue(ghost.moveUp());
        	//assertEquals (7, ghost.getCoordinate().getYlocation());
       // }*/

    }

}
