
public abstract class Character extends GameObject
{
	
//----Constructor--------------------------------------
	
	public Character(Location onGrid)
	{
		super(onGrid);
		
	}

//----Methods-------------------------------------------
	public abstract boolean moveUp();	

	public abstract boolean moveDown();
	
	public abstract boolean moveRight();
	
	public abstract boolean moveLeft();

}

