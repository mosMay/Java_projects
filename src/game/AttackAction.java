package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Weapon;

/**
 * Special Action for attacking other Actors.
 * Author:Mehnil Arif
 */
public class AttackAction extends Action implements CorpseInterface {
	
	
	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}
	
	/**
	 * In this method, one thing was added.
	 * it checks if the target was a zombie if so than it calls the loselimb method of it.
	 */

	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();
		

		if (rand.nextBoolean()) {
			return actor + " misses " + target + ".";
		}

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

		
		
		this.afterAttack(target, map,damage);
		/**
		if (target instanceof Zombie) {//Zombie was hit
			System.out.println("Zombie limb called");
			
			double p = Math.random();
			if(p<0.8) {
				System.out.println(p);
				((Zombie) target).loseLimb(map);
			}
			
		}
		
		if (!target.isConscious()) {
			if(target instanceof MamboMarie) {
				result += System.lineSeparator() + target + " is killed.";
				map.removeActor(target);
			}
			else {
				//Item corpse = new PortableItem("dead " + target, '%');
				CorpseItem corpse = new CorpseItem("dead" + target, '%',this);
				map.locationOf(target).addItem(corpse);
				
				Actions dropActions = new Actions();
				for (Item item : target.getInventory())
					dropActions.add(item.getDropAction());
				for (Action drop : dropActions)		
					drop.execute(target, map);
				map.removeActor(target);	
				
				result += System.lineSeparator() + target + " is killed.";
			}

		}
		**/
	
		return result;
	}
	
	
	
	

	


	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}

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

				}
			}
			
		}
		else {
			changeCorpse(currentLocation,corpse);

		}
		
		
	}
	
	@Override
	public void changeCorpse(Location currentLocation,CorpseItem corpse) {
		currentLocation.addActor(new Zombie(corpse.toString()));
		currentLocation.removeItem(corpse);
	}
	
	
	@Override
	public void changeCorpseCarriedByPlayer(CorpseItem corpse,Location currentLocation,Actor actor) {
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
	**/
		

}
