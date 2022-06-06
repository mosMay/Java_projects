package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * This executes the SowAction of the farmer
 * @author Mehnil Arif
 *
 */

public class SowAction extends Action  {
	
	Location loc;
	
	
	/**
	 * A SowAction object is created
	 * @param loc- location where the farmer will sow
	 */
	public SowAction(Location loc) {
		this.loc = loc;
	}
	
	/**
	 * In this method, a new crop object is added to the location's inventory
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// create FoodItem object and add to location Item
		loc.addItem(new Crop());
		return actor + "sowed crop";

	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " sow crop";
	}
	

}
