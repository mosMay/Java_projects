package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * Class to represent the Zombie limbs
 * @author User
 *
 */

public class Limbs extends WeaponItem {
	
	/**
	 * A limb object is created
	 * @param name - arm or leg?
	 * @param displayChar - "A" or "L"
	 * @param damage - damage done by limb
	 * @param verb - verb used to represent limb
	 */

	public Limbs(String name, char displayChar, int damage, String verb) {
		super(name, displayChar, damage, verb);
		
	}
	
	

	
	

}
