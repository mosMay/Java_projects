package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.WeaponItem;

public class SniperSubMenu extends Action{
	/**
	 * Class representing the actions displayed to the player when he chooses to use the sniper
	 * @author Mayesha
	 */
	
	protected Actor act;
	private Menu menu = new Menu();
	private Actions actions = new Actions();
	//protected boolean isaiming = false;
 
	
	/**
	 * Constructor for the SniperSubMenu
	 * @param act the actor on which the attack is performed.
	 */
	public SniperSubMenu(Actor act) {
		this.act=act;
	}
	
	/**
	 * This method displays a menu showing al the possible targets in the map.
	 * @param actor the player
	 * @param map the map the player is in
	 * @return returns the list if targets on which action can be performed
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
	
		actions.add(new SniperAction(act,false));//shoot
		actions.add(new SniperAction(act,true));//aim

		String showmenu = menu.showMenu(actor, actions, new Display()).execute(actor, map);
	
		return showmenu ; 
		

}
	

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " " + "target"+ " " + act + " " + "with sniper"; 
	}

	

}