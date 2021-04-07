package Domain;

/**
 * Clase que representa auno de los jugadores automáticos del juego. Se mueve al
 * azar.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Irreflexive extends Frog {

	private static final long serialVersionUID = 2230964432406571950L;

	/**
	 * Constructor de la clase Irreflexive
	 */
	public Irreflexive() {
		super("Irreflexive", 0, 0);
	}

	/**
	 * Indica el modo de saltar de la maquina.
	 */
	@Override
	public void jump(char direction) {
		char[] directions = new char[] { 'U', 'D', 'R', 'L' };
		int directionNumber = (int) Math.floor(Math.random() * 4);
		super.direction = directions[directionNumber];
		move();
	}
}