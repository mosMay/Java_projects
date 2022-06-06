package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FertiliseBehaviour implements Behaviour {
	/**
	 * Class representing the FertiliseBehaviour that the farmer performs on Unripe Crop.
	 * @author Mayesha
	 *
	 */
	
	public FertiliseBehaviour() {
		
	}
	/**
	 * Returns corresponding actions depending on the behaviour of the farmer on a FoodItem.
	 * If the farmer is standing on an unripe crop, he fertilises that crop and makes it ripe.
	 * The Farmer checks the items that are on his location, if there is an unripe crop, he fertilises.
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return an Action that actor can perform, or null if actor can't do this.
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		List<Item> items = map.locationOf(actor).getItems();
		
		for (int i=0; i<items.size(); i++) {
			Item item1 = items.get(i);
			if (item1 instanceof Crop) {
				if (!((Crop) item1).isRipe()){
				return new FertiliseAction((Crop)item1);
				}
				else {
					return null;
				}
			}
		}
		
		
		return null;
	}

}
