package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
/**
 * Class representing the SowBehaviour that a farmer performs on Dirt.
 * 
 * 
 * @author Mayesha
 *
 */
public class SowBehaviour implements Behaviour {
	
	/**
	 * Returns corresponding actions depending on the behaviour of the farmer on a FoodItem.
	 * If the farmer is standing next to a dirt, then the farmer sows that dirt.
	 * The farmer only sows when there are no items or Actor on that location and puts a Crop.
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return an Action that actor can perform, or null if actor can't do this.
	 */

	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		        //generates a random number
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		for (Exit exit :exits ) {   //gets the possible ways for the farmer to move
            Location loc = exit.getDestination();
            if (loc.containsAnActor()) {
            	continue;
            }
            else {
                 //System.out.println(loc.getDisplayChar());
     		
                 //check if the exits of the farmer has Dirt, if true then SowAction            
                 if(loc.getItems().size() == 0) {
                	 double p = Math.random();
                 	if (p<0.33) {
                 		//System.out.println(p);
                 		return new SowAction(loc);
                 	}else {
                 		return null;
                 	}
                 }else {
                	 return null;
                 }
            	
            }
            
            
		}
		return null;
	}
	
	

}
