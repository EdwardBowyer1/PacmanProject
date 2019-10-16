//Imports
import java.util.Scanner;

public class Player
{
    //Class to set up the player, and how the player input works and how the player interacts with the AI
    //Instance Variables
    private Location location;
    
    public Player()
    {
        //Empty Constructor
    }
    
    public Player(Location Location)
    {
        Player.location = Location;
    }

    //Method to control movement
    public void Move(char input)
    {
        if (input == 'a')
        Player.xlocation -= 1;
        else if (input == 'w')
        Player.ylocation += 1;
        else if (input == 's')
        Player.ylocation -= 1;
        else if (input == 'd')
        Player.xlocation += 1;
    }

    //Method for interaction with Ghosts
    public void Die() 
    {
        //Gives response to player coming into contact with AI (when powerup not active)
    }
}