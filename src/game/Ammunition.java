package game;

import edu.monash.fit2099.engine.PickUpItemAction;

/**
 * 
 * @author Mehnil Arif
 *This class represents the ammunition objects.
 *
 */

public class Ammunition extends PortableItem {
	
	private int bullets = 5;
	
	/**
	 * The constuctor takes in the number of bullets. 
	 * @param bullets number of bullets
	 */
	public Ammunition(int bullets) {
		super("Ammunition", 'B');
		this.bullets = bullets;
		// TODO Auto-generated constructor stub
		//this.allowableActions.add(new PickUpItemAction(this));
	}
	
	/**
	 * reduce the number of bullets
	 */
	public void reduceBullets() {
		bullets--;
		if (bullets<0) {
			bullets = 0;
		}
	}
	/**
	 * returns the number of bullets
	 * @return bullets
	 */
	
	public int getBullets() {
		return bullets;
	}
	
	
	

}
