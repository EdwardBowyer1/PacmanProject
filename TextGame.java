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

	textapp.isRunning = true;

	while(textapp.isRunning)
	{
	char input = playerInput.nextChar();

	if (input != 'a' && input != 's' &&  input != 'd' && input != 'w')
	continue;

	if (m1.canMovePlayer(input))
		m1.Player.move(input);	
	}
}
}
