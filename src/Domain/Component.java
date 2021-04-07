package Domain;

import java.awt.Rectangle;
import java.io.Serializable;

/**
 * Clase que sirve para generalizar las propiedades básicas y más útiles de los
 * elementos presentes en el juego
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public abstract class Component implements Serializable {

	private static final long serialVersionUID = -467069163317626991L;
	// private int color;
	protected int xPosition;
	protected int yPosition;
	protected final int WIDTH;
	protected final int HEIGHT;
	protected final String name;
	public boolean isVisible;

	/**
	 * Constructor de la clase Component
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Component(String name, int xPos, int yPos, final int WIDTH, final int HEIGHT) {
		xPosition = xPos;
		yPosition = yPos;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.name = name;
	}

	/**
	 * Indica si el elemento se encuentra dentro del rango válido, es decir, dentro
	 * del mapa.
	 * 
	 * @return booleano indicando si está dentro del rango válido.
	 */
	public boolean stillInRange() {
		if ((xPosition < 0 || xPosition > 745) || (yPosition < 0 || yPosition > 617 )) {
			return false;
		}
		return true;
	}

	/**
	 * Dice si el elemnto se intersecta con algún otro al analizar sus valores
	 * 
	 * @param values Arreglo de enteros con posicion en X y Y, el ancho y el alto
	 *               del otro elemento
	 * @return booleano indicando si los elemntos se intersectan
	 */
	public boolean intersects(int[] values) {
		Rectangle me = new Rectangle(xPosition, yPosition, WIDTH, HEIGHT);
		Rectangle other = new Rectangle(values[0], values[1], values[2], values[3]);
		if (me.intersects(other))
			return true;
		return false;
	}

	/**
	 * Genera las coordenadas de las esquinas del elemnto
	 * 
	 * @return arreglo de entero con los valores de las coordenadas de las esquinas
	 */
	public int[] getCorners() {
		int[] corners = new int[4];
		corners[0] = xPosition;
		corners[1] = yPosition;
		corners[2] = WIDTH;
		corners[3] = HEIGHT;
		return corners;
	}

	/**
	 * Devuelve los valores de posicion en X y Y, el ancho y el alto.
	 * 
	 * @return Arreglo de enteros con los valores indicados
	 */
	public int[] getValues() {
		return new int[] { xPosition, yPosition, WIDTH, HEIGHT };
	}

	/**
	 * Indica como el componente afecta ala rana especificada.
	 * 
	 * @param frog rana afectada.
	 */
	public abstract void affect(Frog frog);

	/**
	 * Devuelve el nombre del elemento.
	 * 
	 * @return Cadena con el nombre.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Cambia la posicion del elemento a una indicada
	 * 
	 * @param xPos valor en x de la posicion
	 * @param yPos valor en y de la posicion
	 */
	public void setPosition(int xPos, int yPos) {
		xPosition = xPos;
		yPosition = yPos;
	}

}
