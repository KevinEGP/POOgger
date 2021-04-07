package Domain;

/**
 * Clase que representa a las motos del juego. : Recorren la calle. Si la rana
 * se estrella no muere, pero cae dos saltos hacia el norte.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Motocycle extends Movable {

	/**
	 * Constructor de la clase Motocycle
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Motocycle(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, WIDTH, HEIGHT, 'L', 2);
	}

	/**
	 * Mueve la moto
	 */
	@Override
	public void move() {

	}

	/**
	 * Afecta a la rana indicada
	 * 
	 * @param frog rana afectada.
	 */
	@Override
	public void affect(Frog frog) {

	}
}