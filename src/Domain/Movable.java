package Domain;

import java.io.Serializable;

/**
 * Clase que representa los elementos que puden realizar la accion de moverse en
 * el juego.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public abstract class Movable extends Component implements Serializable {

	protected int speed;
	protected char direction;

	/**
	 * Constructor de la clase Movable
	 * 
	 * @param name      nombre del elemento
	 * @param xPos      posicion en x
	 * @param yPos      posicion en y
	 * @param WIDTH     Ancho del elemento
	 * @param HEIGHT    Alto del elemento
	 * @param direction direccion de desplazamiento
	 * @param speed     velocidad de desplazamiento
	 */
	public Movable(String name, int xPos, int yPos, int WIDTH, int HEIGHT, char direction, int speed) {
		super(name, xPos, yPos, WIDTH, HEIGHT);
		this.direction = direction;
		this.speed = speed;
	}

	/**
	 * Mueve el elemnto movible.
	 */
	public abstract void move();

}
