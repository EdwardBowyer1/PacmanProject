
/**
 * This class extends game object and contains abstract methods to be implemented by the charaters of the game.
 * @author Sami
 *
 */
public abstract class Character extends GameObject
{

	//----Constructor--------------------------------------

	public Character(Location onGrid)
	{
		super(onGrid);

	}

	//----Methods-------------------------------------------

	/**
	 *  Functions to be implemented for every new character added to the game
	 * @return  True if the fucntion was able to move(not hit an obstacle, false otherwise.
	 */
	public abstract boolean moveUp();	

	public abstract boolean moveDown();

	public abstract boolean moveRight();

	public abstract boolean moveLeft();


}

