package Domain;

/**
 * Clase que representa a uno de los tipos de jugadores máquina. Activa los
 * poderes inmediatamente después de recogerlos, si está en una zona en la que
 * es útil.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Cautious extends Frog {

	private static final long serialVersionUID = 7770425486909592009L;

	/**
	 * Constructor de la clase Cautious
	 */
	public Cautious() {
		super("Cautious", 0, 0);
	}

	/**
	 * Dice si un poder es util en una situacion
	 * 
	 * @param nombre nombre del poder
	 * @return booleano diciendo si es util el poder
	 */
	private boolean powerIsUtilNow(String nombre) {
		boolean isUtil = false;

		return isUtil;
	}

	/**
	 * hace que la rana salte
	 */
	public void jump(char direction) {

	}
}