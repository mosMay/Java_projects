package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * A class representing EatAction class
 * 
 * @author Mayesha
 *
 */

public class EatAction extends Action {
	protected Food food;
	

	/**
	 * The default constructor that creates a new EactAction
	 * 
	 * @param food the food on which the Action is performed
	 */
	public EatAction(Food food) {
		this.food=food;
	}
	
	/**
	 * Perform the EatAction, which increases the healthpoints of the Actor.
	 *
	 * @param actor The actor performing the EatAction
	 * @param map The map the actor is on.
	 * @return a description of what happened that can be displayed to the user.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		
		actor.heal(food.getHealthPts());
		
		if(actor instanceof Player) {
			actor.removeItemFromInventory(food);
		}
		if(actor instanceof Human) {
			map.locationOf(actor).removeItem(food);
		}
			
		
		return actor + " eat food ";

	}


	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " eat food ";
	}
	
}
