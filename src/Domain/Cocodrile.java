package Domain;

/**
 * Clase que representa a un cocodrilo que transita en el río
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Cocodrile extends Movable {

	private int dangerousArea;

	/**
	 * Constructor de la clase Cocodrile
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  ancho del elemento
	 * @param HEIGHT alto del elemento
	 */
	public Cocodrile(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, WIDTH, HEIGHT, 'L', 2);
	}

	/**
	 * Puede afectar a una rana transportándola o matándola.
	 * 
	 * @param frog rana afectada
	 */
	public void affect(Frog frog) {

	}

	/**
	 * Realiza el movimeinto del cocodrilo
	 */
	public void move() {

	}
}