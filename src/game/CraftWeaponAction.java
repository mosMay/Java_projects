package game;
import edu.monash.fit2099.engine.*;
/**
 * Class representing an action that will craft weapons from zombie limbs
 * 
 * 
 * @author Mayesha
 *
 */


public class CraftWeaponAction extends Action{ 
	
	protected Item item;
	
	public CraftWeaponAction(Item item) {
		this.item=item;
	}
	
	/**
	 * Perform the Action which is to craft weapon from a zombie limb
	 *
	 * @param actor The player performing the action.
	 * @param map The map the actor is on.
	 * @return a description of what weapon has been created.
	 */
	
	@Override
	public String execute(Actor actor, GameMap map) {
		
		System.out.println("craft weapon");
		
		if (item.getDisplayChar()=='A') {
			LimbWeapon weapon = new LimbWeapon("Zombie Club",'$',15,"hits with club"); 
			actor.removeItemFromInventory(item);
			actor.addItemToInventory(weapon);
			return actor + "creates a Club from arm " ;
		}	
		if (item.getDisplayChar()=='L') {
			LimbWeapon weapon = new LimbWeapon("Zombie mace",'#',20,"hits with mace");
			actor.removeItemFromInventory(item);
			actor.addItemToInventory(weapon);
			return actor + "creates a Mace from Zombie Leg";
		}
		return null;
	}

	

	@Override
	public String menuDescription(Actor actor) {
		return actor + " create weapon from " + item.toString();
	}
	
	

}
