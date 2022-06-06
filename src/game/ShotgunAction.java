package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class ShotgunAction extends Action {
	/**
	 * Class representing the ShotgunAction that the player performs when he chooses a shotgun
	 * to attack
	 * @author Mayesha
	 */
	
	//protected Location location;
	protected String direction;
	protected String hotKey;



	//constructor
	public ShotgunAction(String dir, String key) {
		//this.shotgun=shotgun;
		direction = dir;
		hotKey = key;
	}
	
	/**
	 * Shoots with the shotgun at the specified target by the player and reduces the ammunition count.
	 * @param actor the actor performing the action(i.e the player)
	 * @param map the map at which the player is.
	 * @return returns a string of the action performed by the player.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		//get the location of the player
		SubGameMap mymap = ((SubGameMap)map);
		Location loc = map.locationOf(actor);
		int x1= loc.x();
		int y1 = loc.y();
		//System.out.println("HI");
		//System.out.println(x1);
		//System.out.println(y1);
		
		double p = Math.random();
		if (p>0.76) {
			return "Player misses the targets";
		}
		
		if (direction=="North") {
			//System.out.println("This should not come");
			shootnorth(x1, y1, mymap);
			//System.out.println("Coming here");
		}
		else if (direction =="North-East") {
			shootnorthEast(x1, y1, mymap);
		}
		else if (direction == "East") {
			shootEast(x1, y1, mymap);
		}
		else if (direction == "South-East") {
			shootSouthEast(x1, y1, mymap);
		}
		else if (direction == "South") {
			shootSouth(x1, y1, mymap);
		}
		else if (direction == "South-West") {
			shootSouthWest(x1, y1, mymap);
		}
		else if (direction == "West") {
			//System.out.println("Coming to west");
			shootWest(x1, y1, mymap);
		}
		else if (direction == "Noth-West") {
			shootnorthWest(x1, y1, mymap);
		}
		
		//reduce bullet and check
		for(Item item : actor.getInventory()) {
			if (item instanceof Ammunition) {
				//((Ammunition)item).reduceBullets();
				//System.out.println(((Ammunition)item).getBullets());
				if (((Ammunition)item).getBullets() -1 == 0) {
					actor.removeItemFromInventory(item);
					//System.out.println(((Ammunition)item).getBullets());
					break;
				}
				else {
					int b = ((Ammunition)item).getBullets() -1;
					actor.removeItemFromInventory(item);
					actor.addItemToInventory(new Ammunition(b));
					//System.out.println(b);
					break;
				}
					
				}
			}
		
		return actor + " shot at direction " + direction;
		
		
		
	}
	/**
	 * Method executed when the player chooses to shoot North with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
		
	public void shootnorth(int x1, int y1,SubGameMap map) {	
		//System.out.println("comes to shoot north");
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		

		
		for (int i=1; i<4; i++) {
			int ycor=y1-i;
			for (int j=x1-i; j<x1+i+1; j++ ){
				if (map.getwidth().contains(j) &&  map.getheight().contains(ycor)) {
					x.add(j);
					y.add(ycor);
				//System.out.println(j);
				//System.out.println(ycor);
				}
			}
		}
		attackActorsinRange(x, y,map);
	}
	/**
	 * Method executed when the player chooses to shoot North-East with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
	
	public void shootnorthEast(int x1, int y1,SubGameMap map) {	
		
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		for (int i=0; i<4; i++) {
			int ycor=y1-i;
			for (int j=0; j<4; j++ ){
				if (map.getwidth().contains(x1+j) &&  map.getheight().contains(ycor)) {
					x.add(x1+j);
					y.add(ycor);
			}
			}		
		}
		x.remove(0);
		y.remove(0);
		
		attackActorsinRange(x, y,map);
	}
	/**
	 * Method executed when the player chooses to shoot North-West with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
	
	public void shootnorthWest(int x1, int y1,SubGameMap map) {	
		
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		for (int i=0; i<4; i++) {
			int ycor=y1-i;
			for (int j=0; j<4; j++ ){
				if (map.getwidth().contains(x1-j) &&  map.getheight().contains(ycor)) {
					x.add(x1-j);
					y.add(ycor);
			}
		
		}
		}
		x.remove(0);
		y.remove(0);
		
		attackActorsinRange(x, y,map);
	}
	/**
	 * Method executed when the player chooses to shoot South with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
		
	public void shootSouth(int x1, int y1, SubGameMap map) {
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		
		for (int i=1; i<4; i++) {
			int ycor=y1+i;
			for (int j=x1-i; j<x1+i+1; j++ ){
				if (map.getwidth().contains(j) &&  map.getheight().contains(ycor)) {
					x.add(j);
					y.add(ycor);
			}
		}
		}
		
		attackActorsinRange(x, y,map);
	}
	/**
	 * Method executed when the player chooses to shoot South-East with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
	
	public void shootSouthEast(int x1, int y1,SubGameMap map) {	
		
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		for (int i=0; i<4; i++) {
			int ycor=y1+i;
			for (int j=0; j<4; j++ ){
				if (map.getwidth().contains(x1+j) &&  map.getheight().contains(ycor))
					x.add(x1+j);
					y.add(ycor);
			}
		}
		x.remove(0);
		y.remove(0);
		
		attackActorsinRange(x, y,map);
	}
	/**
	 * Method executed when the player chooses to shoot South-West with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
	
	public void shootSouthWest(int x1, int y1,SubGameMap map) {	
		
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		for (int i=0; i<4; i++) {
			int ycor=y1+i;
			for (int j=0; j<4; j++ ){
				if (map.getwidth().contains(x1-j) &&  map.getheight().contains(ycor)) {
				x.add(x1-j);
				y.add(ycor);
			}
			}	
		}
		x.remove(0);
		y.remove(0);
		
		attackActorsinRange(x, y,map);
	}
	/**
	 * Method executed when the player chooses to shoot East with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
	
	public void shootEast(int x1, int y1, SubGameMap map) {
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		
		for (int i=1; i<4; i++) {
			int xcor=x1+i;
			for (int j=y1+i; j>y1-i-1; j-- ){
				if (map.getwidth().contains(xcor) &&  map.getheight().contains(j)) {
					x.add(xcor);
					y.add(j);
			}
		}
		}
		
		attackActorsinRange(x, y,map);
	}
	/**
	 * Method executed when the player chooses to shoot West with the shotgun.Actors in the range  
	 * are hit by the bullets.
	 * @param x1 x coordinate of the location of the player in the map.
	 * @param y1 y coordinate of the location of the player.
	 * @param map the map at which the player is in.
	 */
	
	public void shootWest(int x1, int y1, SubGameMap map) {
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		//System.out.println("COmes to west");
		
		for (int i=1; i<4; i++) {
			int xcor=x1-i;
			for (int j=y1+i; j>y1-i-1; j-- ){
				if (map.getwidth().contains(xcor) &&  map.getheight().contains(j)) {
					x.add(xcor);
					y.add(j);
				//System.out.println(xcor);
				//System.out.println(j);
				
			}
		}
		}
		
		attackActorsinRange(x, y,map);
	}
	/**
	 * This method checks if Actors in the map fall into the range of the direction of the shotgun.
	 * If Actors are in range, then they are hit by the bullet.
	 * @param x x-coordinates of the locations of all the Actors in the map
	 * @param y y-coordinates of the locations of all the Actors in the map
	 * @param map the map at which the player is in.
	 */
	
	public  void attackActorsinRange(ArrayList<Integer> x, ArrayList<Integer> y,SubGameMap map) {
		for (int i=0; i<x.size(); i++){
			if (map.at(x.get(i), y.get(i)).containsAnActor()==true) {
				System.out.println("player attacks" + " " + map.at(x.get(i), y.get(i)).getActor());
				super.afterAttack(map.at(x.get(i), y.get(i)).getActor(), map, 20);
			}
		}
	}
		
	

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " shot at direction " + direction;
	}

}
