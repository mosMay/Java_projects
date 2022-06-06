package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * 
 * @author Mehnil Arif
 * This class extends Action and it represent a quit game action to the player.
 *
 */

public class QuitGameAction extends Action {

	/**
	 * The execute method is called if the Player choses to quit the game. Since the Player goes first,
	 * this method will change the GameMap objects gameover attribute to true.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		
		((SubGameMap) map).setGameOver();
		
		return " ";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " " + "quit game";
	}

	
	
	
}
