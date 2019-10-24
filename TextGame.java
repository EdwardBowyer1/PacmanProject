import java.util.*;

public class TextGame
{
	private boolean isRunning;

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
	//Game starts here
	TextGame myapp = new TextGame();
	Scanner playerInput = new Scanner (System.in);
	Map m1 = new Map();

	myapp.isRunning = true;

	while(myapp.isRunning)
	{
		m1.printMap();
		System.out.println(m1.getPlayer().toString());
		char input = playerInput.next().charAt(0); 
		//System.out.print("\033[H\033[2J");
		
		if (input != 'a' && input != 's' &&  input != 'd' && input != 'w')
		continue;
		
		if (m1.canMoveCharacter(input))
			{
				m1.getPlayer().Move(input);
			}
	}
}
}
