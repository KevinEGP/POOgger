package Domain;

/**
 * Clase que representa a los troncos del juego. Recorren el rio. Sirven de
 * plataforma.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Trunk extends Movable {

	private Snake snake;

	/**
	 * Constructor de la clase Trunks
	 * 
	 * @param name nombre del elemento
	 */
	public Trunk(String name) {
		super(name, 750, 750, 169, 46, 'L', 2);
		isVisible = true;
	}

	/**
	 * mueve el tronco en un posición ya inidcada.
	 */
	@Override
	public void move() {
		double ran = Math.random() * 200;// Generate random number between 0 and WIDTH.
		int respown = (int) ran;// respown x random position.
		if (super.xPosition <= -WIDTH - respown) {
			super.xPosition = 745;
		}
		if (direction == 'L') {
			if (super.xPosition > -WIDTH) {
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
	 * Afecta ala rana transportándola.
	 * 
	 * @param frog rana afectada
	 */
	@Override
	public void affect(Frog frog) {
		frog.speed = speed;
		frog.direction = direction;
		frog.move();
	}
}