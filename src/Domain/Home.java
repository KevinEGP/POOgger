package Domain;

/**
 * Clase que representa las casas o destinos de la rana.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Home extends Component {

	private boolean isHabitable;
	private boolean hasBeenTaken;
	private Component occupator;

	/**
	 * Constructor de la clase Home
	 * 
	 * @param name nombre del elemento
	 * @param xPos posicion en x
	 * @param yPos posicion en y
	 */
	public Home(String name, int xPos, int yPos) {
		super(name, xPos, yPos, 38, 50);
		hasBeenTaken = false;
		isHabitable = true;
		isVisible = false;
	}

	/**
	 * establece si un hogar es habitable en cierto momento
	 * 
	 * @param b indica si es habitable o no
	 */
	public void setHabitable(boolean b) {
		isHabitable = b;
		if (!isHabitable) {
			generateOccupier();
		}
	}

	/**
	 * Genera un ocupador aleatoriamente. Es decir, los cocodrilos invasores o
	 * serpientes, que son invasores temporales.
	 */
	public void generateOccupier() {

	}

	/**
	 * Indica si la casa ha sido tomada
	 * 
	 * @return booleano inicando si ha sido tomada
	 */
	public boolean itsTaken() {
		return hasBeenTaken;
	}

	/**
	 * afecta a una rana haciendo que ocupe una de las casas.
	 */
	@Override
	public void affect(Frog frog) {
		if (isHabitable) {
			isVisible = true;
			isHabitable = false;
			frog.lifes++;
			POOgger.getPoogger().homes--;
			frog.restart();
		}
	}

}