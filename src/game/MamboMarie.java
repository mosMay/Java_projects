package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

/**
 * 
 * @author Mehnil Arif
 * This class represents the MamboMarie actor. It does not extend the Zombie Actor because she does not attack 
 * any actors, she only chants and summon Zombies onto the map.
 *
 */

public class MamboMarie extends Actor {
	private int turns;
	private boolean isDead = false;
	
	/**
	 * This constructor creates an object of this class. The char 'M' is used to represent Mambo Marie in the map.
	 */
	public MamboMarie() {
		super("Mambo Marie", 'M', 100);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Checks whether Mambo Marie is dead or not
	 * @return boolean true if she is dead false otherwise
	 */
	public boolean isDead() {
		return isDead;
	}
	
	/**
	 * This method runs the object. What Mambo Marie does, depends on the turns. Every 10 turns she will
	 * stop and chant, every 11th turn she will summon 5 zombies, and every 30th turn she will vanish. Otherwise,
	 * she will wander around or do nothing.
	 * 
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn.
	 * @param map        the map containing the Actor
	 * @param display    display on console
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turns++;
		System.out.println(turns);
		if (turns % 10 == 0 && turns % 30 != 0) {//every 10 turns she stops and this turn chants
			//System.out.println("MamboMarie Chants: Abracadabra, Spawn the Zombies!");
			return new MamboMarieAction(1);
		}
		else if (turns % 11 == 0) { // cause zombies to appear
			return new MamboMarieAction(3);
		}
		else if(turns % 30 == 0) {
			//map.removeActor(this);
			return new MamboMarieAction(2);
		}
	
		return new WanderBehaviour().getAction(this, map) == null? new DoNothingAction() : new WanderBehaviour().getAction(this, map) ;
	}
	
	/**
	 * When Mambo Marie is killed, the isDead attribute will become true.
	 */
	public void setIsDead() {
		isDead = true;
	}
	
	
	/**
	 * An Overridden method from the parent class, which checks whether the object lost all its health, if so then
	 * it is dead so change its isDeat attribute to true.
	 */
	@Override
	public boolean isConscious() {
		boolean b = super.isConscious();
		if (!b){
			isDead = true;
		}
		return b;
		
	}
		

}
