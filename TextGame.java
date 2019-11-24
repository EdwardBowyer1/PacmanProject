//Imports-------------------------------------------
import java.util.*;
/**JAVADOC: Text based version of PacMan */
public class TextGame
{
	//Instance variables-------------------------------------------
	private boolean isRunning;
	//Instance methods-------------------------------------------
	public void setIsRunning(boolean a)
	{
		isRunning = a;
	}
	public boolean getIsRunning()
	{
		return isRunning;
	}

	public static void main (String[] args)
	{
	//Game starts here-------------------------------------------
	TextGame myapp = new TextGame();
	Scanner playerInput = new Scanner (System.in);
	TextMap m1 = new TextMap();

	myapp.isRunning = true;

	while(myapp.isRunning)
	{
		m1.printMap();
		System.out.println(m1.getPlayer().toString());
		char input = playerInput.next().charAt(0); 
		//System.out.print("\033[H\033[2J"); <- For linux screen refresh
		
		if (input != 'a' && input != 's' &&  input != 'd' && input != 'w')
		continue;
		
		if (m1.canMoveCharacter(input))
			{
				m1.getPlayer().Move(input);
			}
	}
}
}
