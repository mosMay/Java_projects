package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

/**
 * 
 * @author Mehnil Arif
 * This is a SubClass of the World class in the Engine
 *
 */

public class SubWorld extends World{

	/**
	 * The constructor takes in the display.
	 * @param display
	 */
	public SubWorld(Display display) {
		super(display);
		
	}
	
	/**
	 * This method checks whether the game is still running or not. 
	 * It will return false if the game is over. It firsts checks in all the GameMaps, 
	 * for the number of Humans and Zombies left. If the Humans are zero the player loses, if the zombies are zero and 
	 * mambo marie is dead than the player wins. 
	 */
	@Override
	protected boolean stillRunning() {
		SubGameMap compound = null;
		for(GameMap map: gameMaps) {
			
			
			if (((SubGameMap) map).getGameOver()==true){
				return false;
			}
			
			if (((SubGameMap)map).isCompound()) {
				compound = ((SubGameMap)map);
				break;
				
			}
		}

			int humans = 0;
			int zombies = 0;
			
			for(Actor actor:actorLocations) {
				//if (this.contains(actor)) {
					if(actor instanceof Human) {
						//System.out.println(actor.getDisplayChar());
						humans++;
					}
					else if(actor instanceof Zombie) {
						//System.out.println("Zombies are in the game");
						zombies++;
					}
					
				}
			
			if (humans==0) {
				System.out.println("Player Loses");
				return false;
			}
			else if (zombies==0 && compound.isDead()) {
				System.out.println("Player Wins");
				return false;
			}
			
			return actorLocations.contains(player);
				
			
		//}
		
		/**
		int humans = 0;
		int zombies = 0;
		
		for(Actor actor:actorLocations) {
			if (this.contains(actor)) {
				if(actor instanceof Human) {
					System.out.println(actor.getDisplayChar());
					humans++;
				}
				else if(actor instanceof Zombie) {
					//System.out.println("Zombies are in the game");
					zombies++;
				}
				
			}
			
		}
		System.out.println(humans);
		System.out.println(zombies);
		
		if (humans==0) {
		
			return false;
		}
		else if (zombies==0 && (isCompound == true?mamboMarie.isDead():true)) {
			return false;
		}
		
		return actorLocations.contains(player);
	**/	
	}
	
	

}
