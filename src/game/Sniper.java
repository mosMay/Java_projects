package game;

import edu.monash.fit2099.engine.WeaponItem;

public class Sniper extends WeaponItem {
	/**
	 * Class representing the Sniper weapon
	 * @author Mayesha
	 */
	
	private int damage;
	private String verb;

	/**
	 * Constructor for the sniper
	 */

	public Sniper() {
		super("Sniper", 'S', 10, "Pew");
		this.damage = 10;
		this.verb = "Pew";
	}	
	
}


