package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A class that generates an AttackAction if the current Actor is standing
 * next to an Actor that they can attack.
 * 
 * @author ram
 *
 */
public class AttackBehaviour implements Behaviour {
	private ZombieCapability attackableTeam;
	
	/**
	 * Constructor.
	 * 
	 * Sets the team (i.e. ZombieCapability) that the owner of this
	 * Behaviour is allowed to attack.
	 * 
	 * @param attackableTeam Team descriptor for ZombieActors that can be attacked
	 */
	public AttackBehaviour(ZombieCapability attackableTeam) {
		this.attackableTeam = attackableTeam;
	}

	/**
	 * Returns an AttackAction that attacks an adjacent attackable Actor.
	 * If the zombie is holding any weapon then it attacks with the weapon.
	 * If it doesnot have any weapon then it bites or punches.
	 * If the zombie has only one arm then the probability for punching is halved.
	 * 
	 * Actors are attackable if their ZombieCapability matches the 
	 * "undeadness status" set 
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		double p = Math.random();
		// Is there an attackable Actor next to me?
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		for (Exit e: exits) {
			if (!(e.getDestination().containsAnActor()))
				continue;
			if (e.getDestination().getActor().hasCapability(attackableTeam)) {
				
				
				for (Item item : actor.getInventory()) {
					if (item.asWeapon()!=null) {
					
						return new AttackAction(e.getDestination().getActor());
					}
				}
				Zombie zombie = ((Zombie) actor);
				if (zombie.getarms().size()==2) {
					if (p<0.5) {
						return new BiteAction(e.getDestination().getActor());
					}
					else {
						return new AttackAction(e.getDestination().getActor());
					}
				}
				else if(zombie.getarms().size()==1){
					if (p<(0.3)) {
						return new BiteAction(e.getDestination().getActor());
					}
					else {
						return new AttackAction(e.getDestination().getActor());
					}
						
				}
				else {
					return new DoNothingAction();
						
				}	
					
			}
			
			
			
		}
			
	return null;
		
}
}
