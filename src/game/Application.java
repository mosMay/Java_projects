package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.mars.MartianItem;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.World;

/**
 * The main class for the zombie apocalypse game.
 *
 */
public class Application {
	

	public static void main(String[] args) {
		SubWorld world = new SubWorld(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Fence(), new Tree());
		
		
		List<String> TownMap = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"....................................##########..................................",
		"..........................###########........#####..............................",
		"............++...........##......................########.......................",
		"..............++++.......#.......+......................##......................",
		".............+++...+++...#...............................#......................",
		".........................##...........................+..##.....................",
		"..........................#...............................#.....................",
		".........................##...............................##........+...........",
		".........................................................##.....................",
		"..........................................................##....................",
		".....................................................######.....................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		".................###....................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		
		SubGameMap townMap = new SubGameMap(groundFactory, TownMap,false);
		world.addGameMap(townMap);
		
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"....................................##########..................................",
		"..........................###########........#####..............................",
		"............++...........##......................########.......................",
		"..............++++.......#..............................##......................",
		".............+++...+++...#...............................#......................",
		".........................##..............................##.....................",
		"..........................#...............................#.....................",
		".........................##...............................##....................",
		".........................#...............................##.....................",
		".........................###..............................##....................",
		"...........................####......................######.....................",
		"..............................#########.........####............................",
		"............+++.......................#.........#...............................",
		".............+++++....................#.........#...............................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		SubGameMap gameMap = new SubGameMap(groundFactory, map,true);
		world.addGameMap(gameMap);
		

		
		//System.out.println(map.get(0).length()); 80
		//System.out.println(map.size()); 25
		
		
		//add vehicle objects to the map,with a MoveActorAction
	    Vehicle vehicle = new Vehicle();
	    vehicle.addAction(new MoveActorAction(townMap.at(7, 2), "to Town!"));
	    gameMap.at(1, 1).addItem(vehicle);
		
        Vehicle vehicle2 = new Vehicle();
        vehicle2.addAction(new MoveActorAction(gameMap.at(7, 2), "to MainMap!"));
        townMap.at(1, 1).addItem(vehicle2);
		
        //System.out.println(gameMap.getwidth());
        //System.out.println(gameMap.getheight());
        
        
        
        
        
		
	    // Place some random humans
		//String[] humans = {"Carlton", "May", "Vicente", "Andrea", "Wendy",
				//"Elina", "Winter", "Clem", "Jacob", "Jaquelyn"};
		String[] compoundHumans = {"Carlton","Will","Hilary","Chandler","Ross","Emily","Joey"};
		String[] compoundFarmers = {"Farmer Angelo","Farmer Travis","Farmer Lily","Farmer Rachel"};
		String[] compoundZombies = {"Zombie Groan", "Zombie Boo"};
		addHumans(gameMap,compoundHumans,'H');
		addHumans(gameMap,compoundFarmers,'F');
		addHumans(gameMap,compoundZombies,'Z');
		
		
		
	
		String[] townHumans = {"Ashely","Philip","Vivian"};
		String[] townFarmers = {"Farmer Barney","Farmer Fizz","Farmer Banks"};
		String[] townZombies = {"Zombie Mostalis","Zombie Aaargh"};
		addHumans(townMap,townHumans,'H');
		addHumans(townMap,townFarmers,'F');
		addHumans(townMap,townZombies,'Z');
		
		
		// place a simple weapon
		gameMap.at(74, 20).addItem(new Plank());
	
		
		
		
		//Add a farmer
		//gameMap.at(5, 14).addActor(new Farmer("farmer1"));
		//gameMap.at(10, 22).addActor(new Farmer("farmer2"));
		//gameMap.at(17, 9).addActor(new Farmer("farmer3"));
		//gameMap.at(28, 22).addActor(new Farmer("farmer4"));
		//gameMap.at(39, 5).addActor(new Farmer("farmer6"));
		//gameMap.at(75, 15).addActor(new Farmer("farmer7"));
		//gameMap.at(70, 9).addActor(new Farmer("farmer8"));
		//gameMap.at(68, 20).addActor(new Farmer("farmer9"));
		
		// FIXME: Add more zombies!
		//gameMap.at(30, 20).addActor(new Zombie("Groan"));
		//gameMap.at(30,  18).addActor(new Zombie("Boo"));
		//gameMap.at(10,  4).addActor(new Zombie("Uuuurgh"));
		//gameMap.at(50, 18).addActor(new Zombie("Mortalis"));
		//gameMap.at(1, 10).addActor(new Zombie("Gaaaah"));
		//gameMap.at(62, 12).addActor(new Zombie("Aaargh"));	
 
		
		
		
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(42, 15));
		//gameMap.at(44,15).addItem(new Sniper());	

		
		
		addAmmunition(townMap);
		addAmmunition(gameMap);
		
		//max = 80
		//min = 0
		
		int x1,y1;
		for (int i=0; i<3; i++) {
			do {
				x1 = (int) Math.floor(Math.random() * 79.0);
				y1 = (int) Math.floor(Math.random() * 25.0);
			} 
			while (townMap.at(x1, y1).containsAnActor());
			townMap.at(x1,  y1).addItem(new Shotgun());	
			
		}
		
		
		for (int i=0; i<3; i++) {
			do {
				x1 = (int) Math.floor(Math.random() * 79.0);
				y1 = (int) Math.floor(Math.random() * 25.0);
			} 
			while (townMap.at(x1, y1).containsAnActor());
			townMap.at(x1,  y1).addItem(new Sniper());	
			
		}
		
	
		
		
		
		
		world.run();
	}
	
	/**
	 * This method adds ammunition object in the gamemap.
	 * @param gameMap ammunition to add in this map
	 */
	
	public static void addAmmunition(GameMap gameMap) {
		int x1, y1;
		for (int i=0; i<3; i++) {
			do {
				x1 = (int) Math.floor(Math.random() * 79.0);
				y1 = (int) Math.floor(Math.random() * 25.0);
			} 
			while (gameMap.at(x1, y1).containsAnActor());
			gameMap.at(x1,  y1).addItem(new Ammunition(5));	
			
		}
		
		
	}
	
	/**
	 * Adds actors to map
	 * @param gameMap map to add
	 * @param humans list of names
	 * @param c a char that tells which actor; Humans,Zombies or Farmer to add
	 */
	
	public static void addHumans(GameMap gameMap,String[] humans,char c) {
		
		int x, y;
		for (String name : humans) {
			do {
				x = (int) Math.floor(Math.random() * 79.0);
				y = (int) Math.floor(Math.random() * 25.0);
			} 
			while (gameMap.at(x, y).containsAnActor());
			gameMap.at(x,  y).addActor(c == 'H'? new Human(name) : c == 'Z' ? new Zombie(name): new Farmer(name));	
		}
		
		
	}
}
