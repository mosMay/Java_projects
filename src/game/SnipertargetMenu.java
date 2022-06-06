package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;

public class SnipertargetMenu extends Action{
	/**
	 * Class reprsenting the SnipertargetMenu that is shown to the player when he chooses to perform 
	 * an action with a sniper.
	 * author Mayesha
	 */
	
	private Menu menu = new Menu();
	private Actions actions = new Actions();
	ArrayList<Actor> targets = new ArrayList<>();
	
	/**
	 * Constructor for the SnipertargetMenu
	 */
	public SnipertargetMenu() {
		
	}


	/**
	 * This method gives a list of all the targets that the player can attack using a sniper
	 * and displays it to the player.
	 * It also checks if the player has enough ammunition or not to be able to use the sniper
	 * @param actor the player
	 * @param map the map the player is on
	 */
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		
		boolean isAmmu = false;
		for(Item item : actor.getInventory()) {
			if(item instanceof Ammunition) {
				isAmmu = true;
			}
			
		}
		if(isAmmu == false) {
			return actor + " does not have ammunition";
		}
		
		Location playerLoc = map.locationOf(actor);
		ActorLocations locationofTargets= ((SubGameMap) map).getActorLocation();
		if (((Player)actor).getActor() != null) {
			actions.add(new SniperAction(((Player)actor).getActor(),false));//shoot
			actions.add(new SniperAction(((Player)actor).getActor(),true));//aim
			
		}else {
			for (Actor actors: locationofTargets) {
				if (map.contains(actors)) {
					if (actors instanceof Zombie || actors instanceof MamboMarie) {
						targets.add(actors);
					//int newKey = Integer.parseInt(key);
					//newKey++;
					//key = Integer.toString(newKey);
					
				}
				}
			}
			for (Actor act : targets) {
		
				actions.add(new SniperSubMenu(act));
				//System.out.println("is it coming here");
						
		}
			
			
		}
		//String key="1";

		actions.add(new DoNothingAction());
		
		String ac = menu.showMenu(actor, actions, new Display()).execute(actor, map);
		return ac ;
}
	
	 


	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Player shoots with sniper";
	}

	
	

}
