package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;
import edu.monash.fit2099.engine.WeaponItem;

import java.util.*; 

/**
 * A Zombie.
 * 
 * This Zombie is pretty boring.  It needs to be made more interesting.
 * 
 * @author ram
 * Edited by: Mehnil Arif
 *
 */
public class Zombie extends ZombieActor {
	
	private int turns;
	 
	private Behaviour[] behaviours = {
			new AttackBehaviour(ZombieCapability.ALIVE),
			new HuntBehaviour(Human.class, 10),
			new WanderBehaviour()
	};

	//add arms and legs
	 private List<Limbs> arms = new ArrayList<>(); 
	 private List<Limbs> legs = new ArrayList<>(); 
	

	/**
	 * returns the arms 
	 * @return arms list
	 */
	public List<Limbs> getarms(){
		return arms;
	} 
	
	/**
	 * returns the legs
	 * @return leg list
	 */
	public List<Limbs> getlegs(){
		return legs;
	} 
	
	
	/**
	 * A Zombie object is created. Arms and legs are created and added to their respective lists.
	 * @param name - name of the zombie
	 */
	
	public Zombie(String name) {
		super(name, 'Z', 70, ZombieCapability.UNDEAD);
		arms.add(new Limbs("arm",'A',10,"slaps"));
		arms.add(new Limbs("arm",'A',10,"slaps"));
		
		legs.add(new Limbs("leg",'L',10,"kick"));
		legs.add(new Limbs("leg",'L',10,"kick"));
	
	}
	
	/**
	 * Called when the Zombie is attacked. There is a 50% chance of losing an arm or a leg. 
	 * But if the zombie has no arms, than lose the leg and vice versa. If arm is lost there is a 50% chance of the 
	 * zombie dropping the weapon if it is holding one.
	 * @param map - GameMap object
	 */
	
	public void loseLimb(GameMap map) {
		double p = Math.random();
		System.out.println("In Limb");
		System.out.println(p);
		
		if(arms.size() == 0 && legs.size()==0) {
			System.out.println("No arm leg");
			return;
		}
		
		if ((arms.size() == 0 || p>0.5) && legs.size() != 0) { //remove legs
			
			
			map.locationOf(this).addItem(legs.remove(legs.size()-1));
			
			System.out.println("legs off");
		}
		
		else { //legs == 0 or p<= 0.5
			//arms
			map.locationOf(this).addItem(arms.remove(arms.size() - 1));
			
			for (int i = 0; i < this.getInventory().size(); i++) { //get weapon
				  Item item1 = this.getInventory().get(i);
				  if (item1 instanceof WeaponItem) {
					  double n = Math.random();
					  if(n<=0.5) {
						  this.removeItemFromInventory(item1);
						  map.locationOf(this).addItem(item1);
						  
						  
					  }
					  
					  break;
				  }
				}
			System.out.println("arms off");

		}
		
		System.out.println("Nothing happened");
		
		
	}
	


	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "punches");
	}

	/**
	 * This action is the original playTurn method. It looks through the behaviour list and returns the 
	 * corresponding action. 
	 * @param actions - actions list of possible Actions
	 * @param lastAction - previous Action, if it was a multiturn action
	 * @param map - the map where the current Zombie is
	 * @param display - the Display where the Zombie's utterances will be displayed
	 * @return the action done by zombie
	 */
	public Action playTurn2(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null)
				return action;
		}
		return new DoNothingAction();	
	}
	
	/**
	 * This method increases the turns for the zombie. The zombie are dumb so it can do one of the three things.It can either say 
	 * "BRAINS", or check for weapon in his sorroundings or calls the playTurn2 method to get actions. 
	 * The actions depends on the number of legs the zombie has.
	 * @param actions list of possible Actions
	 * @param lastAction previous Action, if it was a multiturn action
	 * @param map the map where the current Zombie is
	 * @param display the Display where the Zombie's utterances will be displayed
	 */
	
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turns +=1;
		//check to print out BRAAINNS
		double p=Math.random();
		if (p<=0.1)
			System.out.println("BRRAAAAAIIINNSSSS");
		
		
		else if(p>0.1 && p<=0.3) {
			//check for weapon at location
			List<Item> items = map.locationOf(this).getItems(); //get items at location
			
			for (int i = 0; i < items.size(); i++) { //get weapon
				  Item item1 = items.get(i);
				  if (item1 instanceof WeaponItem) {
					  return new PickUpItemAction(item1);
				 }
				}
			
		}
		else {
			//check legs
			if ((legs.size() == 2 || (legs.size() == 1) && turns%2==0)) { //zombie can move
				return playTurn2(actions,lastAction,map,display);
			}

			else if (legs.size() == 0) { //zombie cannot move but can attack only
				Action action = behaviours[0].getAction(this, map);
				if (action != null)
					return action;
				
			}
			
			
		}
		

		return new DoNothingAction();  //happen when turn is odd
		
		
		
	}
	
	
}
