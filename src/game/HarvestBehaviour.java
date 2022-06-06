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

public class HarvestBehaviour implements Behaviour {
	/**
	 * Class representing the HarvestBehaviour that harvests ripe crop.
	 * 
	 * 
	 * @author Mayesha
	 *
	 */	
	
	
	public HarvestBehaviour() {
		
	}
	/**
	 * Returns corresponding actions depending on the behaviour of the farmer on a FoodItem.
	 * If the farmer is standing on or next to a ripe crop he harvests it and puts it on the ground 
	 * for other Actors to pick up.
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return an Action that actor can perform, or null if actor can't do this.
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		List<Item> items = map.locationOf(actor).getItems();
		Crop crop = checkCrop(items);
        if (crop != null) {
        	return new HarvestAction(crop);
        }
		
		List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
		Collections.shuffle(exits);
		for (Exit exit :exits ) {   //gets the possible ways for the farmer to move
            Location loc = exit.getDestination();
            Crop crop1 = checkCrop(loc.getItems());
            if (crop1 != null) {
            	return new HarvestAction(crop1);
        
            }
            
         
		
		}
		
		
		
		
		return null;
	}
	/**
	 * This method checks if a location has a ripe crop or not
	 * @param items that exist on that location
	 * @return returns the crop if it is ripe, or else returns null if there is no ripe crop.
	 */
	
	public Crop checkCrop(List<Item> items) {
		
		for (int i=0; i<items.size(); i++) {
			Item item1 = items.get(i);
			if (item1 instanceof Crop) {
				Crop crop = (Crop) item1;
				if(crop.isRipe()) {
					return crop;
				}
				return null;
			}
				
				
			}
		return null;
		
	}
	

}
	
