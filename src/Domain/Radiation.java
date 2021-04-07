package Domain;

/**
 * Clase que representa el consumible radiacion. Vuelven a la rana t�xica, si un
 * animal intenta comerla, el animal morir� por intoxicaci�n. Se adquiere al
 * subirse a las carretas.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Radiation extends Consumable {

	/**
	 * 
	 * 
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Radiation(int xPos, int yPos, int WIDTH, int HEIGHT) {
		super("Radiation", xPos, yPos, WIDTH, HEIGHT);
	}

	/**
	 * Activa el poder.
	 */
	public void activate() {

	}

	/**
	 * Afecta a la ran indicada volv�endola venenosa
	 */
	@Override
	public void affect(Frog frog) {

	}
}