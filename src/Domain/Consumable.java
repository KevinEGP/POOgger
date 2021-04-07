package Domain;

/**
 * Clase que representa los poderes que puede tomar la rana.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public abstract class Consumable extends Component {

	private boolean wasUsed;

	/**
	 * Construcor de la clase Consumable
	 * 
	 * @param name   nombre del Consumible
	 * @param xPos   posicion en x
	 * @param yPos   posicion en y
	 * @param width  Ancho del Consumible
	 * @param height Alto del Consumible
	 */
	public Consumable(String name, int xPos, int yPos, int width, int height) {
		super(name, xPos, yPos, width, height);
		setUsed(false);
	}

	/**
	 * Inidica que el poder ya se usó.
	 * 
	 * @param value booleano para establecer si ha sido usado, o no.
	 */
	public void setUsed(boolean value) {
		wasUsed = value;
	}

	/**
	 * Indica si ya fue usado el elemento.
	 * 
	 * @return booleano indicando si ya fue usado.
	 */
	private boolean wasUsed() {
		return wasUsed;
	}

	/**
	 * Activa el consumible.
	 */
	public abstract void activate();
}