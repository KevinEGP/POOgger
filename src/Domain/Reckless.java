package Domain;

/**
 * Clase que representa auna de las máquinas del juego. Al saltar, nunca
 * retrocede.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Reckless extends Frog {

	private static final long serialVersionUID = -8134465782002765208L;

	/**
	 * Constructor de la clase Reckless
	 */
	public Reckless() {
		super("Reckless", 0, 0);
	}

	/**
	 * Indica como debe saltar
	 */
	@Override
	public void jump(char direction) {
		char[] directions = new char[] { 'U', 'U', 'R', 'L' }; // 50% chance of going forward.
		int directionNumber = (int) Math.floor(Math.random() * 4);
		super.direction = directions[directionNumber];
		speed = 50;
		move();
	}
}