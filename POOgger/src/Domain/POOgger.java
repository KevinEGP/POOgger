package Domain;

import java.util.ArrayList;

public class POOgger {

	private static POOgger poogger;

	private String mode;
	private int level;
	private int totalTime;
	public final int WIDTH = 745;
	public final int HEIGHT = 750;
	private String mapType;
	private Frog[] character;
	private ArrayList<Movable> movables;
	private Lane[] lanes;

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
		character = new Frog[2];
		movables = new ArrayList<Movable>();
		lanes = new Lane[12];
		for (int i = 0; i < 12; i++) {
			Lane l = new Lane(0, i * 50, WIDTH, 50, i, this);
			lanes[i] = l;
		}
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
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
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

	public void restart() {

	}

	public void finish() {

	}

}
