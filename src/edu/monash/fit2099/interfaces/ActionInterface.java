package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.AttackAction;
import game.CorpseItem;
import game.MamboMarie;
import game.Zombie;

/**
 * This interface provides the ability to add methods to Action, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ActionInterface {
	
	
	/**
	 * This method is called after an attack happens. It is used to reduce the damage of the targer, and checks 
	 * whether the target is unconscious,if so create a corpse object.
	 * @param target
	 * @param map
	 * @param damage
	 */
	 default public void afterAttack(Actor target,GameMap map,int damage) {
		 
		 target.hurt(damage);
		 
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
				map.removeActor(target); // if target is MumboMarie remove from map
			}
			else {
				//Item corpse = new PortableItem("dead " + target, '%');
				CorpseItem corpse = new CorpseItem("dead" + target, '%');
				map.locationOf(target).addItem(corpse);
				
				Actions dropActions = new Actions();
				for (Item item : target.getInventory())
					dropActions.add(item.getDropAction());
				for (Action drop : dropActions)		
					drop.execute(target, map);
				map.removeActor(target);	
				
				
			}
	
		}
	
	}
}
