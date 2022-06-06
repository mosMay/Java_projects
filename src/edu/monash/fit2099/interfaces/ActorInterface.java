package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Item;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {
	default public Item getItem(Item item) {
		return null;
		
	}

}
