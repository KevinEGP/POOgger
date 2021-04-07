package Domain;

/**
 * Indica el lodo sobre el andén cerca al rio.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Puddle extends Component {

	/**
	 * Constructor de la clase Puddle
	 * 
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param WIDTH  Ancho del elemento
	 * @param HEIGHT Alto del elemento
	 */
	public Puddle(int xPos, int yPos, int WIDTH, int HEIGHT) {
		super("Puddle", xPos, yPos, WIDTH, HEIGHT);
	}

	/**
	 * Inidca como afecta a la rana
	 * 
	 * @param frog rana afectada
	 */
	@Override
	public void affect(Frog frog) {

	}
}