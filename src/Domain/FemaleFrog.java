package Domain;

/**
 * Clase que representa a una rana hembra. Aparecen en cualquier punto. La rana
 * puede decidir llevarla a su hogar. Resta 200 puntos si muere al ser
 * transportada. Suma 450 puntos por cada rana hembra salvada.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class FemaleFrog extends Consumable {

	/**
	 * Constructor de la clase FemaleFrog
	 * 
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public FemaleFrog(int xPos, int yPos, int WIDTH, int HEIGHT) {
		super("FemaleFrog", xPos, yPos, 37, 50);
	}

	/**
	 * Indica como afecta a la rana
	 * 
	 * @param frog Rana afectada
	 */
	public void affect(Frog frog) {

	}

	/**
	 * Mueve la rana hembra.
	 */
	public void move() {

	}

	/**
	 * Se activa automaticamente
	 */
	public void activate() {

	}
}