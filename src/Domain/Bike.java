package Domain;

/**
 * Representa una bicicleta que circula por las carreteras, y que puede
 * transportar a la rana.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 */
public class Bike extends Movable {

	/**
	 * Constructo de la clase
	 * 
	 * @param name nombre del elemento
	 */
	public Bike(String name) {
		super("Bike", 745, 750, 78, 46, 'L', 2);
		isVisible = true;
	}

	/**
	 * Mueve la bicicleta
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
	 * Afecta a la rana cuando se intersectan.
	 */
	@Override
	public void affect(Frog frog) {
		frog.restart();
	}

}