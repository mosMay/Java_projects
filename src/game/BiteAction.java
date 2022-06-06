package game;

import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
/**
 * Class representing BiteAction.
 * 
 * 
 * @author Mayesha
 *
 */
public class BiteAction extends Action implements CorpseInterface {
	
	protected Random rand = new Random();
	protected Actor target;
	//double p = Math.random();
	/**
	 * The default constructor that creates a new BiteAction
	 * 
	 * @param target the target on which the Action is performed.
	 */
	public BiteAction(Actor target) {
		this.target = target;
	}
	
	/**
	 * Perform the bite action.
	 *The bite action restores healthpoints for the zombie and damages the Actor on which the bite 
	 *is performed.
	 *If the Actor is killed by the Zombie the Actor becomes a corpse.
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of what happened that can be displayed to the user.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		
		
		//check if the actor is near the target

		if (rand.nextBoolean()) {
			return actor + " misses " + target + ".";
		}
		String result = actor + " " + "bites " + target + " for " + "15" + " damage.";
		actor.heal(5);
		this.afterAttack(target, map, 15);
		
		/**
		target.hurt(15);
		
		if (!target.isConscious()) {
			//Item corpse = new PortableItem("dead " + target, '%');
			CorpseItem corpse = new CorpseItem("dead" + target, '%');
			map.locationOf(target).addItem(corpse);
			
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		
				drop.execute(target, map);
			map.removeActor(target);	
			
			result += System.lineSeparator() + target + " is killed.";
		}
		**/
	
		return result;
		
	}
	
	@Override
	public String menuDescription(Actor actor) {
		return actor + " bits " + target;
	}
	/**
	 * This method puts the new Zombie to the desired location on the map after it has
	 * risen from death.
	 * @param corpse  the Actor that became a corpse
	 * @param currentLocation  the current location of the Actor
	 */
/**
	@Override
	public void changeCorpseOnGround(CorpseItem corpse,Location currentLocation) {
		System.out.println(corpse.toString() + " converted to zombie");
		
		
		if (currentLocation.containsAnActor()) {
			List<Exit> exits = currentLocation.getExits();
			for (Exit exit: exits) {
				Location destination = exit.getDestination();
				if(!destination.containsAnActor()) {
					changeCorpse(destination,corpse);
					break;
					//currentLocation.addActor(new Zombie(corpse.toString()));
					//currentLocation.removeItem(corpse);
				}
			}
		}
		else {
			changeCorpse(currentLocation,corpse);
			//currentLocation.addActor(new Zombie(corpse.toString()));
			//currentLocation.removeItem(corpse);
		}
		
		
	}

	
	@Override
	public void changeCorpse(Location currentLocation,CorpseItem corpse) {
		currentLocation.addActor(new Zombie(corpse.toString()));
		currentLocation.removeItem(corpse);
	}
	
	@Override
	public void changeCorpseCarriedByPlayer(CorpseItem corpse,Location currentLocation,Actor actor) {
		System.out.println(corpse.toString() + " converted to zombie");
		
		for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
            	destination.addActor(new Zombie(corpse.toString()));
            	actor.removeItemFromInventory(corpse);
            	System.out.println("Corpse Rmoved from inventory");
            	break;
            }
        }
		
		
		
	}
**/
	

}
