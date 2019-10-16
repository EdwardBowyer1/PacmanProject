import java.util.Scanner;

public class Player
{
    //Class to set up the player, and how the player input works and how the player interacts with the AI
    private Location location;
    
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
    public void Die() //Name for this method?
    {
        //Gives response to player coming into contact with AI (when powerup not active)
    }

    /*
    public main()
    {
        //Tests class
    }
    */
}