package Domain;

/**
 * Clase que representa al consumible caparazón de la tortuga. Cuando la
 * tortugas mueren, pueden arrojar su caparazón cerca de la acera. Hace a la
 * rana inmune a los vehículos.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Shell extends Consumable {

	/**
	 * Constructor de la clase Shell
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Shell(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, 46, 46);
	}

	/**
	 * Activa el poder
	 */
	public void activate() {

	}

	/**
	 * Afecta a la rana indicada.
	 * 
	 * @param frog rana afectada.
	 */
	public void affect(Frog frog) {

	}
}