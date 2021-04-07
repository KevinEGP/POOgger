package Domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa a los distintos carriles que componen el recorrido del
 * mapa.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Lane implements Serializable {

	private final int NUMBER;
	private boolean isInteractive;
	private ArrayList<Component> components;

	/**
	 * Constructor de la clase Lane
	 * 
	 * @param NUMBER  número de carril que le corresponde
	 * @param poogger referencia la clase principal
	 */
	public Lane(final int NUMBER, POOgger poogger) {
		this.NUMBER = NUMBER;
		components = new ArrayList<Component>();
		if (NUMBER >= 7) { // If is a river part:
			isInteractive = true; // Frog dies if fall into river
		} else { // Is a roadway part
			isInteractive = false;
		}
	}

	/**
	 * Agrega un componente nuevo al carril.
	 * 
	 * @param component nuevo componente.
	 */
	public void addComponent(Component component) {
		components.add(component);
	}

	/**
	 * Indica como afecta la rana si se intersecta con algún otro elemnto presente
	 * en el carril.
	 * 
	 * @param frog rana afectada, presente ne le carril.
	 */
	public void affect(Frog frog) {
		boolean intersects = false;
		boolean atLeastOneintersects = false;
		for (Component c : components) {
			int[] corners = c.getCorners();
			intersects = intersect(frog.getCorners(), corners);
			if (intersects) {
				c.affect(frog);
				atLeastOneintersects = false;
				break;
			}
		}

		if (NUMBER <= 5 && (!intersects || atLeastOneintersects)) {
			frog.restart();
		}
	}

	/**
	 * Dice si elmentos se intersectan
	 * 
	 * @param frog_corners esquinas de la rana
	 * @param corners      esquinas del componente
	 * @return booleano indicando si se intersectan.
	 */
	private boolean intersect(int[] frog_corners, int[] corners) {
		Rectangle frog = new Rectangle(frog_corners[0], frog_corners[1], frog_corners[2], frog_corners[3]);
		Rectangle component = new Rectangle(corners[0], corners[1], corners[2], corners[3]);
		return frog.intersects(component);
	}

	/**
	 * Mueve los componentes presentes en el carril (Excepto a la rana, si es que la
	 * tiene) de manera ponderada.
	 */
	public void moveComponents() {
		for (Component c : components) {
			try {
				((Movable) c).move();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Devuelve los elementos del carril.
	 * 
	 * @return Arreglo con los componetes del carril.
	 */
	public ArrayList<Component> getComponents() {
		return components;
	}
}