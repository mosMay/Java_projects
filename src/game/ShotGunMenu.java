package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;
import edu.monash.fit2099.engine.NumberRange;

public class ShotGunMenu extends Action {
	/**
	 * Class representing the ShotGunMenu 
	 * @author Mayesha
	 */
	
	private Menu menu = new Menu();
	private Actions actions = new Actions();
	private ArrayList<Exit> exits = new ArrayList<Exit>(); 
	protected String direction;
	
	
	/**
	 * Constructor for ShotGunMenu.
	 */
	public ShotGunMenu() {
		
	}
	/**
	 * This method displays the the possible directions available to the the player 
	 * when he is using the shotgun.
	 * @param actor the player
	 * @param map the map the player is on
	 */

	@Override
	public String execute(Actor actor, GameMap map) {
		boolean isAmmu = false;
		for(Item item : actor.getInventory()) {
			if(item instanceof Ammunition) {
				isAmmu = true;
			}
			
		}
		if(!isAmmu) {
			return actor + " does not have ammunition";
		}
		
		
		//System.out.println("Shotgun menu is created");
		Location here = map.locationOf(actor); //location of player
		int x = here.x();
		int y = here.y();
		NumberRange x1 = ((SubGameMap)map).getwidth();
		NumberRange y1 = ((SubGameMap)map).getheight();
		
		//if (!(map.at(x,y-1).getItems() instanceof Ground)) {
		
		if (x1.contains(x) && y1.contains(y-1)){
			if ((map.at(x, y-1)).getGround().canActorEnter(actor)){
				exits.add(new Exit("North", map.at(x, y-1),"1"));
		}
		}
		if (x1.contains(x+1) && y1.contains(y-1)) {
			 if ((map.at(x+1, y-1).getGround().canActorEnter(actor))) {
				 exits.add(new Exit("North-East", map.at(x+1, y-1),"2"));
		}
		 }
		if (x1.contains(x+1) && y1.contains(y)) {
			 if ((map.at(x+1, y).getGround().canActorEnter(actor))) {
				 exits.add(new Exit("East", map.at(x+1, y),"3"));
		}
		}
		if (x1.contains(x+1) && y1.contains(y+1)) {
			 if ((map.at(x+1, y+1).getGround().canActorEnter(actor))) {
				 exits.add(new Exit("South-East", map.at(x+1, y+1),"4"));
		}
		}
		if (x1.contains(x) && y1.contains(y+1)) {
			if ((map.at(x, y+1)).getGround().canActorEnter(actor)){
				exits.add(new Exit("South", map.at(x, y+1),"5"));
		}
		}
		if (x1.contains(x-1) && y1.contains(y+1)) {
			if ((map.at(x-1, y + 1)).getGround().canActorEnter(actor)) {
				exits.add(new Exit("South-West", map.at(x-1, y + 1),"6"));
		}
		}
		if (x1.contains(x-1) && y1.contains(y)) {
			if  ((map.at(x-1, y)).getGround().canActorEnter(actor)) {
				exits.add(new Exit("West", map.at(x-1, y),"7"));
		}
		}
		if (x1.contains(x-1) && y1.contains(y-1)) {
			if ((map.at(x-1, y-1)).getGround().canActorEnter(actor)) {
				exits.add(new Exit("North-West", map.at(x-1, y-1),"8"));
		}	
		}
		
		
		for (Exit exit : exits) { //here.getExits()
			System.out.println(exit.getName());
			actions.add(new ShotgunAction(exit.getName(),exit.getHotKey()));
					//destination.ShotgunAction(actor, exit.getName(), exit.getHotKey()));
		}
		
	
		actions.add(new DoNothingAction());
		
		String ac = menu.showMenu(actor, actions, new Display()).execute(actor, map);
		
		return ac ;
	}


	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Player shoots with ShotGun";
	}
	
	

}
