package Domain;


/**
 * Clase que representa el consumible acelerador, dejado por algunos vehícuulos
 * en las carreteras.
 * 
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 */
public class Accelerator extends Consumable {

	private int jumpLength;

	/**
	 * Constructo de la clase Acclerator
	 * 
	 * @param xPos posicion en X donde queda el objeto
	 * @param yPos posicion en Y donde queda el objeto
	 */
	public Accelerator(int xPos, int yPos) {
		super("Rocket", xPos, yPos, 118, 46);
		jumpLength = 100;
	}

	/**
	 * Indica que se activa el consumible
	 */
	@Override
	public void activate() {

	}

	/**
	 * Hace efecto en la rana que lo activa.
	 */
	@Override
	public void affect(Frog f) {		
	}
}