package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * A Crop class that is used represent crop on the ground.It is not a portable item as the crop should not be carried
 * unless it is ripped.
 * @author Mehnil Arif
 *
 */

public class Crop extends Item {
	

	private int turns;
	private boolean isRipe = false;

	/**
	 * A Crop Object is created where the char 'C' represents the Crop
	 */
	public Crop() {
		super("Crop",'C',false);
	}
	
	
	/**
	 * This method is called by the tick method and changes the crop to ripe. 
	 */
	public void changeCrop() {
		System.out.println("Crop Riped");
		isRipe = true;
		this.allowableActions.add(new HarvestAction(this));
	}
	
	/**
	 * Check whether crop is ripe or not
	 * @return a boolean; true means that crop is riped and false means that it is not ripe yet.
	 */
	public boolean isRipe() {
		return isRipe;
	}
	
	/**
	 * Return the turns
	 * @return the turns
	 */
	
	public int getTurns() {
		return turns;
	}

	/**
	 * Called in FertiliseAction, to increase the turn by 10. 
	 */
	public void fertilise() {
		turns = turns + 10;
		
	}
	
	/**
	 * This method increments turns every turn and checks if turns is equal to or greater than 20, 
	 * if so change the crop to ripe and change the display to 'R'.
	 */
	
	@Override
	public void tick(Location currentLocation) {
		turns = turns + 1;
		if (turns >= 20) {
			if(!isRipe()) {
				changeCrop();
				displayChar = 'R';
			}
			
			
						

		}
		
	}
	
	

}
