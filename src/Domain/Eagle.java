package Domain;

/**
 * Clase que representa a un águila dentro del juego. Atacan en picada a un
 * sitio en específico matando a la rana si se encuentra en el lugar al que
 * atacó. Aparecen únicamente cuando se está jugando en el mapa de día. Mueren
 * si son alcanzadas por un auto. Cuando mueren sus alas quedan en la calle.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Eagle extends Movable {

	/**
	 * Constructor de la clase Eagle
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Eagle(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, WIDTH, HEIGHT, 'L', 2);
	}

	/**
	 * dice como debe moverse el águila.
	 */
	@Override
	public void move() {

	}

	/**
	 * Afecta a la rana matándola
	 * 
	 * @param frog Rana afectada
	 */
	@Override
	public void affect(Frog frog) {

	}
}