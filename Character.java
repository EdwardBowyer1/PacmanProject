
public class Character extends GameObject{
	
	private char direction; //how to tell which direction he is facing
	private boolean isEvading; //way to keep track if he ate a powerup or ghost is running away.
	
	public Character(Location onGrid)
	{
		super(onGrid);
		setDirection('0');
		setEvading(false);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * @return the direction
	 */
	public char getDirection() {
		return direction;
	}


	/**
	 * @param direction the direction to set
	 */
	public void setDirection(char direction) {
		this.direction = direction;
	}


	/**
	 * @return the isEvading
	 */
	public boolean isEvading() {
		return isEvading;
	}


	/**
	 * @param isEvading the isEvading to set
	 */
	public void setEvading(boolean isEvading) {
		this.isEvading = isEvading;
	}

}
