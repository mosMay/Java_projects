package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import java.util.Random;

/**
 * CorpseItem class which represents the corpse
 * @author Mehnil Arif
 *
 */


public class CorpseItem extends PortableItem implements CorpseInterface {
	
	private int turns = 0;
	private int turn = 0;
	
	/**
	 * A CorpseItem object is created
	 * @param name - name of the actor
	 * @param displayChar - char to display the corpse
	 * @param ac -Action Object that created the CorpseItem object
	 */
	public CorpseItem(String name, char displayChar) {
		super(name, displayChar);
		turn =  (int)(Math.random() * ((10 - 5) + 1)) + 5;
		System.out.println(turn);

		
	}

	/**
	 * In the tick method, if the corpse is on the ground a turn is increased. When the corpse is rising from the 
	 * dead '&' char is shown. When it is time to convert the corpse into zombie, a method is called inside the action.
	 */
	
	@Override
	public void tick(Location currentLocation) {
		turns += 1;
		
		if(turns == turn - 1) {
			System.out.println("Rising from the dead!");
			displayChar = '&';
		}
		
		if(turns == turn) {
			changeCorpseOnGround(this, currentLocation);
		}
		
		super.tick(currentLocation);
		
		/**
		if (turns == turn) {
			if(AC instanceof AttackAction) {
				((AttackAction) AC).changeCorpseOnGround(this, currentLocation);
			}
			
			else {
				((BiteAction) AC).changeCorpseOnGround(this,currentLocation);
			}
			
		}
		**/
		

	}
	

	/**
	 * In the tick method, if the corpse is on an actor's inventory, a turn is increased.
	 *  When it is time to convert the corpse into zombie, a method is called inside the action.
	 *  This method will create the Zombie next to the actor and remove the corpse.
	 */
	
	@Override
	public void tick(Location currentLocation, Actor actor) { //if actor is holding corpse
		turns+=1;
		
		if(turns == turn - 1) {
			System.out.println("Rising from the dead!");
			displayChar = '&';
		}
		
		if(turns == turn) {
			changeCorpseCarriedByPlayer(this, currentLocation, actor);
		}
		
		super.tick(currentLocation, actor);
		
		/**
		if (turns == turn) {
			if(AC instanceof AttackAction) {
				System.out.println("change");
				changeCorpseOnGround(this, currentLocation);
				//((AttackAction) AC).changeCorpseCarriedByPlayer(this, currentLocation, actor);
			}
			
			else {
				System.out.println("change");
				((BiteAction) AC).changeCorpseCarriedByPlayer(this, currentLocation, actor);
			}
			
		}
		**/
		
		
	}
	
	
	
	
	

}
