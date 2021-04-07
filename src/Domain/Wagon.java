package Domain;

/**
 * Clase que representa a las carretas. Recorren la calle llevando material
 * radioactivo. Las ranas pueden subirse sobre ellos para adquirir radiación.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Wagon extends Movable {

	private static final long serialVersionUID = -6360057288075502819L;

	/**
	 * Constructor de la clase Wagon
	 * 
	 * @param name nombre del elemento
	 */
	public Wagon(String name) {
		super(name, 745, 750, 67, 46, 'L', 2);
		isVisible = true;
	}

	public void vacate() {

	}

	/**
	 * Mueve el vehículo en la direccion definida.
	 */
	@Override
	public void move() {
		if (super.xPosition <= -super.WIDTH) {
			super.xPosition = 745;
		}
		if (direction == 'L') {
			if (super.xPosition > -super.WIDTH) {
				super.xPosition -= speed;
			}
		}

		if (direction == 'R') {
			if (super.xPosition < 745) {
				super.xPosition += speed;
			}
		}

	}

	/**
	 * Afecta a la rana arrollandola o transportandola.
	 * 
	 * @param frog rana afectada.
	 */
	@Override
	public void affect(Frog frog) {
		frog.restart();
	}
}