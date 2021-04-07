package Domain;

/**
 * Clase que representa a las tortugas del juego. Recorren el rio. Sirven de
 * plataforma, pero pueden llegar a causar la muerte de la rana al momento de
 * sumergirse. El tiempo y la frecuencia con la que una tortuga se sumerge se
 * escoge de manera aleatoria. Si llegan a morir, pueden arrojar su caparazón
 * cerca de la acera.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Turtles extends Movable {

	private int quantity;

	/**
	 * Constructor de la clase Turtles
	 * 
	 * @param name nombre del elemento.
	 */
	public Turtles(String name) {
		super(name, 745, 750, 58, 46, 'L', 2);
		isVisible = true;
	}

	/**
	 * Mueve las totugas en una dirección ya definida.
	 */
	public void move() {
		double ran = Math.random() * 200;// Generate random number between 0 and WIDTH.
		int respown = (int) ran;// respown x random position.
		if (super.xPosition <= -WIDTH - respown) {
			super.xPosition = 745;
		}
		if (super.direction == 'L') {
			if (super.xPosition > -super.WIDTH) {
				super.xPosition -= super.speed;
			}
		}

		if (super.direction == 'R') {
			if (super.xPosition < 745) {
				super.xPosition += super.speed;
			}
		}
	}

	/**
	 * Afecta a la rana transportándola o matándola.
	 * 
	 * @param frog rana afectada.
	 */
	@Override
	public void affect(Frog frog) {
		frog.speed = speed;
		frog.direction = direction;
		frog.move();
	}
}