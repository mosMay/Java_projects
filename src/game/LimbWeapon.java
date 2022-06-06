package game;

import edu.monash.fit2099.engine.WeaponItem;

/**
 * A class representing LimbWeapon
 * 
 * @author Mayesha
 *
 */

public class LimbWeapon extends WeaponItem{

	private int damage;
	private String verb;

	/** Constructor.
	 *
	 * @param name name of the item
	 * @param displayChar character to use for display when item is on the ground
	 * @param damage amount of damage this weapon does
	 * @param verb verb to use for this weapon, e.g. "hits", "zaps"
	 */
	public LimbWeapon(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
		this.damage = damage;
		this.verb = verb;
	}

	/**
	 * Accessor for damage done by this weapon.
	 *
	 * @return the damage
	 */
	public int damage() {
		return damage;
	}

	/**
	 * Returns the verb used for attacking with this weapon, so that it can be displayed
	 * in the UI.
	 *
	 * @return a third-person present tense verb, e.g. "hits", "zaps"
	 */
	public String verb() {
		return verb;
	}
}
