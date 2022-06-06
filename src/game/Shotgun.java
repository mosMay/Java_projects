package game;
import edu.monash.fit2099.engine.WeaponItem;

public class Shotgun extends WeaponItem {
	/**
	 * Class representing the Shotgun weapon
	 * @author Mayesha
	 */

	private int damage;
	private String verb;

	/**
	 * Constructor for the Shotgun 
	 */

	public Shotgun() {
		super("ShotGun", 'G', 10, "BAM!");
		this.damage = 10;
		this.verb = "BAM!";
	}	
	
}
