package Domain;

/**
 * Clase que representa a los vehículos del juego. Recorren la calle y pueden
 * arrollar a la rana. Pueden arrojar aceleradores.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Vehicle extends Movable {

	/**
	 * Constructor de la clase Vehicle
	 * 
	 * @param name nombre del elemento
	 */
	public Vehicle(String name) {
		super(name, 745, 750, 123, 46, 'L', 2);
		isVisible = true;
	}

	/**
	 * Puede dejar un acelerador, dependiendo de las probabilidades.
	 * 
	 * @param probability
	 */
	void leaveElement(int probability) {

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
	 * Afecta a la rana arrollandola.
	 * 
	 * @param frog rana afectada.
	 */
	@Override
	public void affect(Frog frog) {
		frog.restart();
	}

}