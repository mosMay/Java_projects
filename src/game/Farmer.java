package game;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/**
 * Class representing a farmer
 * 
 * 
 * @author Mayesha
 *
 */

public class Farmer extends Human {
	private Behaviour[] behaviour = {new SowBehaviour(),
									new FertiliseBehaviour(),
									new HarvestBehaviour(),
									new WanderBehaviour()};
			
	
	/**
	 * The default constructor creates default Farmers
	 * 
	 * @param name the's display name
	 */
	public Farmer(String name) {
		super(name, 'F',50);
		
		
	}
	/**
	 * The protected constructor which can be used to create farmers.
	 * @param name the farmer's display name
	 * @param displayChar character that will represent the Farmer in the map
	 * @param hitPoints amount of damage that the farmer can take before it dies.
	 */
	protected Farmer(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}
	/**
	 * Select and return an action for the farmer to perform on the current turn. 
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		/**
		for(Item item : map.locationOf(this).getItems()) {
			System.out.println(item.toString());
		} 
		**/
		
		for(Behaviour b: behaviour) {
			Action action = b.getAction(this, map);
			if (action!=null) {
				return action;
			}
		}
		
		 
		return new DoNothingAction() ;
		

}
}

