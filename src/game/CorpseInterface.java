package game;

import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;

/**
 * Interface used by the AttackAction and BiteAction to convert a corpse to Zombie. 
 * This interface is used as these methods can be shared by the Action subclasses
 * @author Mehnil Arif
 *
 *
 */

public interface CorpseInterface {
	/**
	 * This is used when the corpse is on the ground.
	 * @param corpse - corpse that is rising from the dead
	 * @param currentLocation - location of the corpse
	 */
	default public void changeCorpseOnGround(CorpseItem corpse,Location currentLocation) {
		
		System.out.println(corpse.toString() + " converted to zombie");
		
		
		if (currentLocation.containsAnActor()) {
			List<Exit> exits = currentLocation.getExits();
			for (Exit exit: exits) {
				Location destination = exit.getDestination();
				if(!destination.containsAnActor()) {
					changeCorpse(destination,corpse);
					break;

				}
			}
			
		}
		else {
			changeCorpse(currentLocation,corpse);

		}
		
	}
	 
	 /**
	  * Used when corpse is being carried by an actor
	  * @param corpse- corpse that is rising from the dead
	  * @param currentLocation - location of the actor
	  * @param actor - actor that is carrying the corpse
	  */
	 
	default public void changeCorpseCarriedByPlayer(CorpseItem corpse,Location currentLocation,Actor actor) {
		System.out.println(corpse.toString() +"  converted to zombie");
		
		for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
            	destination.addActor(new Zombie(corpse.toString()));
            	actor.removeItemFromInventory(corpse);
            	break;
            }
        }
	}
	 
	 /**
	  * This is used to remove corpse from the location
	  * @param currentLocation - location of the corpse
	  * @param corpse - corpse that is rising from the dead
	  */
	
	default public void changeCorpse(Location currentLocation,CorpseItem corpse) {
		currentLocation.addActor(new Zombie(corpse.toString()));
		currentLocation.removeItem(corpse);
	}
}
