package game;

/**
 * This class represent the harvested crop.
 * @author User
 *
 */

public class Food extends PortableItem{
	
	private int healthPts = 10;
	
	
	/**
	 * A Food Object is created and a char 'M' is used to display it
	 */
	public Food() {
		super("Food", 'O');
		this.allowableActions.add(new EatAction(this));
		
	}
	
	/**
	 * Returns 
	 * @return healthPts - health points received when the food is consumed
	 */
	public int getHealthPts() {
		return healthPts;
	}
	
	
	
}
