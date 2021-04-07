package Domain;

/**
 * Clase que representa al insecto que puede aparecer dentro del juego. Aparecen
 * en los hogares. La rana obtiene puntos si los come. 200 puntos: Por cada
 * insecto atrapado.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Insect extends Consumable {

	/**
	 * Constructor de la clase Insect
	 * 
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Insect(int xPos, int yPos, int WIDTH, int HEIGHT) {
		super("Insect", xPos, yPos, 50, 33);
	}

	/**
	 * Afecta a la rana indicada.
	 * 
	 * @param frog rana afectada.
	 */
	public void affect(Frog frog) {

	}

	/**
	 * Mueve al insecto.
	 */
	public void move() {

	}

	/**
	 * Se activa automaticamente.
	 */
	public void activate() {

	}
}