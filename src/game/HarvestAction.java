package game;


import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Execute the HarvestAction depending on the actor
 * @author Mehnil Arif
 *
 */

public class HarvestAction extends Action {
	
	Crop crop;
	
	/**
	 * Create a HarvestAction object
	 * @param crop - Crop that needs to be harvested
	 */
	public HarvestAction(Crop crop) {
		this.crop = crop;
		
	}
	
	/**
	 * The execute method deletes the crop from the location and depending
	 * on the actor it executes a code. If the actor is a farmer than the food is dropped to the floor,
	 * however if it is a Human/Player it is added to the inventory.
	 */

	@Override
	public String execute(Actor actor, GameMap map) {
		
		Location lc = map.locationOf(actor);
		lc.removeItem(crop);
		
		if(actor instanceof Farmer) { 
			lc.addItem(new Food());
			
		}
		
		else if(actor instanceof Human) {
			
			actor.addItemToInventory(new Food());
			
		}
		
		
		return actor +  " harvest the crop";
		//change diaplay
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor +  " harvest the crop";
	}

}
