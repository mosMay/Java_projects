package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 * edit by: Mehnil Arif
 */
public class Player extends Human {

	private Menu menu = new Menu();
	private ArrayList<Exit> exits = new ArrayList<Exit>();
	private int aimCount = 0;
	private Actor target = null;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions list = super.getAllowableActions(otherActor, direction, map);
		if (otherActor.hasCapability(ZombieCapability.UNDEAD) != this.hasCapability(ZombieCapability.UNDEAD))
			list.add(new AttackAction(this));	
		return list;
	}
	
	public int getAim() {
		return aimCount;
	}
	
	public void addAim() {
		aimCount++;
		
	}
	
	public void resetAim() {
		target = null;
		aimCount = 0; 
	}
	
	public Actor getActor() {
		return target;
	}
	
	public void setTarget(Actor target) {
		this.target = target;
	}
	
	

	/**
	 * In the playturn method, it is checked if the player holds a limb if so, it is a chance to craft that limb and so its action
	 * is added to its list of actions. Furthermore, if a player has a Food Object in its inventory than it is given a choice to 
	 * eat it. Lastly, if the player is standing on a ripe crop than it is given a choice to harvest it.
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		System.out.println("Player's healthpoint"+ Integer.toString(this.hitPoints));
		// check player's inventory
		/**Location loc = map.locationOf(this);   //remove this is not needed
		for (Exit exit : loc.getExits()) {
			System.out.println(exit.getName());
		}**/
		
		
		for (Item item: this.getInventory()) {
			if (item instanceof Limbs) {
				actions.add(new CraftWeaponAction(item));
			}
			//if(item instanceof Food) {
			//	actions.add(new EatAction((Food) item));
			//}
			if (item instanceof Shotgun) {
				//actions.add(new ShotgunAction((WeaponItem) item));
				actions.add(new ShotGunMenu());
			}
			if (item instanceof Sniper) {
				actions.add(new SnipertargetMenu());
			}
			

		}

		
		actions.add(new QuitGameAction());

		
		
		
		
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		Action ac = menu.showMenu(this, actions, display);
		if(!(ac instanceof SnipertargetMenu)) {
			resetAim();
		}
			
		return ac ;
	}
}
