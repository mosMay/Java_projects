package game;

import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;
import edu.monash.fit2099.engine.NumberRange;

/**
 * 
 * @author Mehnil Arif
 * This is a SubClass of the GameMap class. 
 *
 */
public class SubGameMap extends GameMap {
	private MamboMarie mamboMarie;
	private int turn = 0;
	private boolean gameover;
	private boolean isCompound; 
	

	/**
	 * The constructor takes in the GroundFactory, map and a boolean.The boolean represents if its 
	 * a compound map or not.
	 * @param groundFactory object of GroundFactory
	 * @param lines map
	 * @param ic boolean indicating whether the object is a compound map or not
	 */
	public SubGameMap(GroundFactory groundFactory, List<String> lines, boolean ic) {
		super(groundFactory, lines);
		isCompound = ic;
		if(ic) {
			mamboMarie = new MamboMarie();
		}
	}
	

	
	/**
	 * This is a overriden method from the parent class. This method increases the turn every tick, 
	 * checks whether the object is a compound if so it tries and spawn Mambo Marie. It also calls it super tick method.
	 * 
	 */
	@Override
	public void tick() {
		turn ++;
		
		if (isCompound) {
			//check if Mambo Marie is on the map and not dead
			if ((this.contains(mamboMarie)==false) && (mamboMarie.isDead() == false)) {// if it is not in the map and not dead
				
				double b  = Math.random();
				if (b <= 0.05) {
					this.at(78,3).addActor(mamboMarie); //spawns Mambo Marie at the corner of map.
					System.out.println("MamboMarie is here");
					
				}
			}
		
		}
		
		super.tick();
	}
	
	/**
	 * Sets the Game Over to true which is used to stop the game
	 */
	public void setGameOver() {
		gameover=true;
	}
	
	/**
	 * Gets the game over boolean
	 * @return gameover
	 */
	public boolean getGameOver() {
		return gameover;
	}
	
	/**
	 * checks if the object is the compound map
	 * @return isCompound
	 */
	public boolean isCompound() {
		return isCompound;
	}
	
	/**
	 * Checks if Mambo Marie is dead
	 * @return isDead
	 */
	public boolean isDead() {
		return mamboMarie.isDead();
	}
	
	/**
	 * Gets the location of all the actors in the map
	 * @return actorLocations
	 */
	public ActorLocations getActorLocation() {
		return actorLocations;
	}
	
	/**
	 * Get the width of the map
	 * @return widths
	 */
	public NumberRange getwidth() {
		return widths;
		
	}
	/**
	 * Get the height of the map
	 * @return heights
	 */
	public NumberRange getheight() {
		return heights;
		
	}
}
