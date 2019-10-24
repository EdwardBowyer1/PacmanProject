
public class Pacman extends Character {

	public final int dX = 1;
	public final int dY = 1;
	
	//instance variables
	private int lives;
	private String name;

	//constructors
	//can constructother pacman qualities here later
	public Pacman(Location toCopy) {
		super(toCopy);
		setLives(3);
		setName("Pacman");
	}

    //Methods
	//to control movement
	
    public void Move(char input)
    {
        if (input == 'a')
        	getCoordinate().changeLocation(-dX,0);
        else if (input == 'w')
        	getCoordinate().changeLocation(0,-dY);
        else if (input == 's')
        	getCoordinate().changeLocation(0,dY);
        else if (input == 'd')
        	getCoordinate().changeLocation(dX,0);
    }

	/**
	 * @return the lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @param lives the lives to set
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{
		return name +" " + super.toString();
		
	}

}
