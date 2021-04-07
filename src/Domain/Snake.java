package Domain;

/**
 * Clase que representa a las serpientes del juego. Aparecen en la acera previa
 * al rio, en los troncos y en los hogares. Si llegan a tocar a la rana lo
 * matarán.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Snake extends Movable {

	/**
	 * Constructor de la clase Snake
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Snake(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, WIDTH, HEIGHT, 'L', 2);
		isVisible = true;
	}

	/**
	 * Mueve la serpiente en la dirección de desplazamiento.
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
	 * Afecta a la rana indicada matándola
	 * 
	 * @param frog rana afectada
	 */
	@Override
	public void affect(Frog frog) {
		// TODO Auto-generated method stub

	}
}