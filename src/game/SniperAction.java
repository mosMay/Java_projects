package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Class that represents the actions peformed when the player uses a sniper as a weapon
 * @author Mayesha
 *
 */
public class SniperAction extends Action {
	protected Actor target;
	protected boolean isaiming;
	protected int damage=20;
	double p = Math.random();
	//SniperAction action;
	
	/**
	 * Contructor for the SniperAction
	 * @param act the actor on which the action the done
	 * @param isaiming isaiming tells us if the player is aiming or not
	 */
	public SniperAction(Actor act, boolean isaiming) {
		this.target = act;
		this.isaiming = isaiming;
		
		
	}
	/**
	 * This method performs the action specified by the player when he is using the sniper if the 
	 * probability matches.
	 * If he chooses to aim he aims and his target is saved to be aimed later.
	 * If he chooses to shoot he shoots the target
	 * @param actor the player
	 * @param map the map the player is in
	 * @return returns a string which describes the action done by the player.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		int aimcount = ((Player) actor).getAim();
		
		if (isaiming == false && aimcount==0) { //shoot
			
			if (p<0.75) {
				//System.out.println("hello");
				//attackActors(act,map,damage);
				super.afterAttack(target, map,damage);
				((Player) actor).resetAim();
				checkAmmunition(actor);
				
				return actor + " " +"shoots"+ " "+ target;
				
			}
		}
			
		else if (isaiming== false && aimcount==1) {
			if (p<0.9) {
				//System.out.println("coming");
				damage=damage*2;
				//attackActors(actor,map,damage);
				super.afterAttack(target, map, damage);
				((Player) actor).resetAim();
				checkAmmunition(actor);
				return actor + " " +"shoots"+ " "+ target;
			}
			
		}
		else if (isaiming == false && aimcount>=2) {
			//kill the zombie completely and remove it from the map
			if(target instanceof MamboMarie) {
				((MamboMarie)target).setIsDead();
			}
			map.removeActor(target);
			((Player) actor).resetAim();
			checkAmmunition(actor);
			return actor + " instakill " + target;
		}
		
		
		else if(isaiming == true) {
			//i want to show the menu again
			//action.execute(act, map);
			((Player)actor).setTarget(target);
			((Player) actor).addAim();
			return "Player is aiming";
		}
		checkAmmunition(actor);
		
		return actor + " missed " + target;
	}
	

	/**
	 * This method decreases the number of ammunition everytime the player uses the shotgun or sniper
	 * @param actor the player
	 */
	public void checkAmmunition(Actor actor) {
		for(Item item : actor.getInventory()) {
			if (item instanceof Ammunition) {
				//((Ammunition)item).reduceBullets();
				int bullets = ((Ammunition)item).getBullets();
				//System.out.println(bullets);
				if (bullets -1 == 0) {
					actor.removeItemFromInventory(item);
					//System.out.println(bullets -1);
					break;
				}
				else {
					int b = bullets - 1;
					actor.removeItemFromInventory(item);
					actor.addItemToInventory(new Ammunition(b));
					//System.out.println(b);
					break;
				}
				
					
				}
			}
		}
	

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		if (isaiming==false) {
			return actor + "shoots at " + target;
		}
		else {
			return actor + "aims at " + target;
		}
		
	}
	

	

}
