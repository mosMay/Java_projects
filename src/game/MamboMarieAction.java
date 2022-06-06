package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;


/**
 * 
 * @author Mehnil Arif
 * This is an Action class for Mambo Marie. 
 *
 */
public class MamboMarieAction extends Action {
	int chant;
	
	/**
	 * The constructor takes in an integer that links to a specific action. 
	 * @param b int specifying the action to be performedS
	 */
	public MamboMarieAction(int b) {
		chant = b;
	}
	
	/**
	 * The execute method takes in the actor and the GameMap objects and performs the action corresponding
	 * to the chant integer. if the chant is 1, it means the MamboMarie chants only, else if it is 2, 
	 * she vanishes and anything else she summons 5 zombies.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		
		if(chant == 1) {
			return "MamboMarie Chants: Abracadabra, Spawn the Zombies!";
		}
		else if(chant == 2) {
			map.removeActor(actor);
			return actor + " vanishes!";
		}
		else { 
			int x;
			int y;
			for(int i = 0; i<5;i++) {
				do {
					x = (int) Math.floor(Math.random() * 79.0 + 0.0); //0 to 80
					y = (int) Math.floor(Math.random() * 24.0 + 0.0); //0 to 25
				} 
				while (map.at(x, y).containsAnActor());
				map.at(x,  y).addActor(new Zombie("Zombie"));	
			}
			return actor + " spawned 5 zombies!";
			
		}
		
	
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " does action";
	}

}
