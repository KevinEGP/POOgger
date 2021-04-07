package Domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase principal del juego. Controla todos los elemntos, y permite conectar de
 * manera correcta con la capa de presentación.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class POOgger implements Serializable {

	private static final long serialVersionUID = 1L;
	private static POOgger poogger;
	public static boolean isRunning;
	public boolean win = false;
	private String mode;
	private String mapType;
	protected int homes = 5;
	private int level;
	private int totalTime;
	private double lastTime = 0;
	private double delta;
	public final int WIDTH = 745;
	public final int HEIGHT = 750;
	private Frog[] characters;
	private ArrayList<Movable> movables;
	protected Lane[] lanes;

	/**
	 * Singleton de POOgger, devuelve la única instancia.
	 * 
	 * @return instancia de Poogger.
	 */
	public static POOgger getPoogger() {
		if (poogger == null) {
			poogger = new POOgger();
		}
		return poogger;
	}

	/**
	 * Singleton de POOgger, genera una nueva instancia de POOgger.
	 */
	public static void newPoogger() {
		poogger = new POOgger();
	}

	/**
	 * Singleton de POOgger, cambia la instancia actual de POOgger por otra
	 * indicada.
	 * 
	 * @param newPoogger nueva instancia
	 */
	public static void changePoogger(POOgger newPoogger) {
		poogger = newPoogger;
	}

	/**
	 * Constructor de la clase POOgger
	 */
	private POOgger() {
		isRunning = true;
		setMode("Arcade");
		setMapType("Day");
		setTime(120);
		movables = new ArrayList<Movable>();

		lanes = new Lane[13];
		for (int i = 0; i < 13; i++) {
			Lane l = new Lane(i, poogger);
			lanes[i] = l;
		}

		// Add homes
		lanes[0].addComponent(new Home("Home", 94, 10));
		lanes[0].addComponent(new Home("Home", 224, 10));
		lanes[0].addComponent(new Home("Home", 353, 10));
		lanes[0].addComponent(new Home("Home", 483, 10));
		lanes[0].addComponent(new Home("Home", 613, 10));

		// InRiver
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

		// InStreet
		addComponent(7, new Vehicle("Car1"));
		addComponent(8, new Vehicle("Bus1"));
		addComponent(8, new Wagon("Carreta1"));
		addComponent(9, new Wagon("Carreta1"));
		addComponent(10, new Vehicle("Car2"));
		addComponent(11, new Bike("Bike"));
	}

	/**
	 * Agrega un nuevo componente.
	 * 
	 * @param lane Carril en que debe aparecer
	 * @param c    Componente a agregar
	 */
	protected void addComponent(int lane, Movable c) {
		double ran = Math.random() * 745;// Generate random number between 0 and 745.
		int x = (int) ran;// x random position.
		int y = 12 + (lane * 50); // y lane position.
		c.setPosition(x, y);
		movables.add(c);
		lanes[lane].addComponent(c);

	}

	/**
	 * devuelve el modo de juego
	 * 
	 * @return cadena con el modo de juego.
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * Establece el modo de juego.
	 * 
	 * @param mode modo de juego indicado
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
	 * Devuelve el nivel actual del juego
	 * 
	 * @return entero con el nivel del juego
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Devuelve el tiempo
	 * 
	 * @return el tiempo del juego
	 */
	public int getTime() {
		return totalTime;
	}

	/**
	 * Asigna el tiempo
	 * 
	 * @param time tiempo a asignar
	 */
	public void setTime(int time) {
		totalTime = time;
	}
	/**
	 * Establece el nivel de juego
	 * 
	 * @param level nivel de juego
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Devuelve el tipo de mapa
	 * 
	 * @return el tipo de mapa
	 */
	public String getMapType() {
		return mapType;
	}

	/**
	 * Establece el tipo de mapa
	 * 
	 * @param mapType cadena indicando el mapa
	 */
	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	/**
	 * Devuelve los jugadores actuales.
	 * 
	 * @return arreglo con los jugadores.
	 */
	public Frog[] getCharacters() {
		return characters;
	}

	/**
	 * Devuelve los elemntos movibles
	 * 
	 * @return arraylist con los elemntos.
	 */
	public ArrayList<Movable> getMovables() {
		return movables;
	}

	/**
	 * Devuelve los hogares
	 * 
	 * @return Arrylist con los hogares
	 */
	public ArrayList<Component> getHomes() {
		return lanes[0].getComponents();
	}

	/**
	 * Actuliza los elemntos del juego
	 */
	public void update() {
		// Time counter.
		double now = System.nanoTime();
		delta += (now - lastTime) / 1000000000;
		if (delta >= 1) {
			totalTime--;
			delta = 0;
		}
		lastTime = now;

		// Game win
		if (homes == 0) {
			win = true;
			finish();
		}

		// Game Finish or affect frogs in lane
		for (Frog frog : characters) {
			if (frog.lifes <= 0 || totalTime == 0) {
				finish();
			} else {
				lanes[frog.getLane()].affect(frog);
			}

		}
	}

	/**
	 * Persiste la partida en un archivo
	 * 
	 * @param file archivo a usar
	 */
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

	/**
	 * Carga un partida desde un archivo indicado
	 * 
	 * @param file archivo usado
	 */
	public void open(File file) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			POOgger newPoogger = (POOgger) ois.readObject();
			ois.close();
			POOgger.changePoogger(newPoogger);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reinicia el juego.
	 */
	public void restart() {

	}

	/**
	 * Finaliza la ejecución.
	 */
	public static void finish() {
		isRunning = false;
	}
}
