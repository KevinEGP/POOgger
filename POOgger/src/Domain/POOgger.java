package Domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class POOgger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static POOgger poogger;
	public static boolean isRunning;
	public boolean win= false;
	private String mode;
	private String mapType;
	protected int homes = 5;
	private int level;
	private int totalTime = 120;
	private double lastTime = 0;
	private double delta;
	public final int WIDTH = 745;
	public final int HEIGHT = 750;
	private Frog[] characters;
	private ArrayList<Movable> movables;
	protected Lane[] lanes;

	public static POOgger getPoogger() {
		if (poogger == null) {
			poogger = new POOgger();
		}
		return poogger;
	}

	public static void newPoogger() {
		poogger = new POOgger();
	}

	public static void changePoogger(POOgger newPoogger) {
		poogger = newPoogger;
	}

	private POOgger() {
		isRunning = true;
		setMode("Arcade");
		setMapType("Day");
		movables = new ArrayList<Movable>();
		
		lanes = new Lane[13];
		for (int i = 0; i < 13; i++) {
			Lane l = new Lane(i, poogger);
			lanes[i] = l;
		}
		
		//Add homes
		lanes[0].addComponent(new Home("Home",94,10));
		lanes[0].addComponent(new Home("Home",224,10));
		lanes[0].addComponent(new Home("Home",353,10));
		lanes[0].addComponent(new Home("Home",483,10));
		lanes[0].addComponent(new Home("Home",613,10));
		
		
		
		//InRiver
		addComponent(1, new Trunk("Trunk"));
		addComponent(1, new Trunk("Trunk"));
		addComponent(1, new Turtles("Turtles"));
		addComponent(2, new Turtles("Turtles"));
		addComponent(2, new Trunk("Trunk"));
		addComponent(2, new Turtles("Turtles"));
		addComponent(2, new Trunk("Trunk"));
		addComponent(3, new Trunk("Trunk"));
		addComponent(3, new Turtles("Turtles"));
		addComponent(3, new Turtles("Turtles"));
		addComponent(3, new Trunk("Trunk"));
		addComponent(4, new Trunk("Trunk"));
		addComponent(4, new Trunk("Trunk"));
		addComponent(4, new Turtles("Turtles"));
		addComponent(4, new Turtles("Turtles"));
		addComponent(5, new Trunk("Trunk"));
		addComponent(5, new Trunk("Trunk"));
		addComponent(5, new Turtles("Turtles"));
		addComponent(5, new Turtles("Turtles"));
		
		//InStreet		
		addComponent(7, new Vehicle("Car1"));
		addComponent(8, new Vehicle("Bus1"));
		addComponent(8, new Wagon("Carreta1"));
		addComponent(9, new Wagon("Carreta1"));
		addComponent(10, new Vehicle("Car2"));
		addComponent(11, new Bike("Bike"));
	}
	
	protected void addComponent(int lane, Movable c) {
		double ran =  Math.random()*745;//Generate random number between 0 and 745.
		int x = (int) ran;//x random position.
		int y = 12+(lane*50); //y lane position.
		c.setPosition(x,y);
		movables.add(c);
		lanes[lane].addComponent(c);	
		
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
		characters = new Frog[1];
		characters[0] = new Frog("Frog1", 347, 617);
		if (!(mode == "Arcade")) {
			homes = 1;
			characters = new Frog[2];
			characters[0] = new Frog("Frog1", 443, 617);
			characters[1] = new Frog("Frog2", 223, 617);
		}
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return the game time
	 */
	public int getTime() {
		return totalTime;
	}
	
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the mapType
	 */
	public String getMapType() {
		return mapType;
	}

	/**
	 * @param mapType the mapType to set
	 */
	public void setMapType(String mapType) {
		this.mapType = mapType;
	}
	
	public Frog[] getCharacters() {
		return characters;
	}
	
	public ArrayList<Movable> getMovables() {
		return movables;
	}
	
	public ArrayList<Component> getHomes() {
		return lanes[0].getComponents();
	}
	
	public void update() {
		//Time counter.
		double now = System.nanoTime();
		delta += (now - lastTime)/1000000000;		
		if (delta >= 1) {			
			totalTime--;
			delta = 0;
		}
		lastTime = now;
		
		//Game win
		if(homes == 0) {
			win = true;
			finish();
		}
		
		//Game Finish or affect frogs in lane
		for (Frog frog: characters) {
			if (frog.lifes <= 0 || totalTime == 0) {
				finish();
			}
			else {
				lanes[frog.getLane()].affect(frog);
			}		

		}
	}
	
	public void save(File file) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(poogger);
	    	oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void open(File file) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream( 
			        new FileInputStream(file) );
			POOgger newPoogger = (POOgger)ois.readObject();
	        ois.close();
	        POOgger.changePoogger(newPoogger);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
    	
	}
	    	
		
	public void restart() {
		
	}

	public static void finish() {
		isRunning = false;		
	}
}
