package Domain;

/**
 * Clase que representa al consumible alas. Evita que la rana muera ahogada una
 * vez. Cuando un águila muere sus alas quedan en la calle.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Wings extends Consumable {

	/**
	 * Constructor de la clase Wings
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Wings(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, WIDTH, HEIGHT);
	}

	/**
	 * Inidica que se acticava el poder
	 */
	public void activate() {

	}

	/**
	 * Afecta a la rana indicada.
	 * 
	 * @param frog rana afectada.
	 */
	public void affect(Frog frog) {

	}
}