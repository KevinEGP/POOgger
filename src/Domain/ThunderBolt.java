package Domain;

/**
 * Clase asociada a los rayos presentes en el mapa de noche. Aparecen �nicamente
 * cuando se est� jugando en el mapa de noche, es equivalente a las �guilas
 * adem�s cualquier objeto que entre en contacto con el rayo ser� destruido.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class ThunderBolt extends Component {

	/**
	 * Constructor de la clase ThunderBolt
	 * 
	 * @param name   nombre del elemento
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param width  Ancho del elemento
	 * @param height Alto del elemento
	 */
	public ThunderBolt(String name, int xPos, int yPos, int width, int height) {
		super(name, xPos, yPos, width, height);
	}

	/**
	 * Afecta a la rana inidicada mat�ndola.
	 * 
	 * @param frog rana afectada.
	 */
	@Override
	public void affect(Frog frog) {

	}
}