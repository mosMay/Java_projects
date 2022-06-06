package game;


import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

import java.util.*;

/**
 * Execute the fertilise action of the farmer.
 * @author Mehnil Arif
 *
 */


public class FertiliseAction extends Action {
	
	Crop crop;
	
	
	/**
	 * Create a FertiliseAction object
	 * @param crop - crop that needs to fertilise
	 */
	public FertiliseAction(Crop crop) {
		this.crop = crop;
	
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		crop.fertilise(); //call the fertilise method
		

		
		return actor + " fertilised the crop";
			
		
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " fertilised the crop";
	}
	
	
	
}
