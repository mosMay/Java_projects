package game;

import edu.monash.fit2099.engine.Action;
/**
 * @author Mehnil Arif
 * class representing a vehicle object that moves the actor from one map to the other. It extends Item class 
 * as it is not a portable object.
 */
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

public class Vehicle extends Item {
	
	/**
	 * Constructor for the Vehicle class
	 */
	public Vehicle() {
		super("Vehicle", 'V', false);
		
	}
	
	//add actions to this object
	public void addAction(Action action) {
		this.allowableActions.add(action);
	}
	


}
