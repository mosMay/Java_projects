package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
/**
 * An EatBehaviour class that implements the behaviour eat
 * @author Mayesha
 *
 */
public class EatBehaviour implements Behaviour{
	

	/**
	 * Returns an EatAction if there is  Food available.
	 * 
	 */
	
	@Override
	public Action getAction(Actor actor,GameMap map) {
		
		
		List<Item> items = map.locationOf(actor).getItems();
		for (int i=0; i<items.size(); i++) {
			Item item1 = items.get(i);
			if (item1 instanceof Food) {
				return new EatAction((Food) item1);
			
			}
		}
		return null;
}
}
