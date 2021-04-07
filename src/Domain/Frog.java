package Domain;

/**
 * Clase que representa a la rana dentro del juego. se pueden mover en las
 * cuatro direcciones básicas (norte, sur, este y oeste). Su movimiento es un
 * desplazamiento, es decir, es instantaneo. En el transcurso del camino la rana
 * puede recoger varios poderes que son arrojados/dejados por los enemigos.
 *
 * @author Kevin Garzon
 * @author Brayan Macias
 * @version 07/12/2020
 *
 */
public class Frog extends Movable {


	private int name;
	private int health;
	protected int lifes;
	private int score;

	private Consumable powers;

	private POOgger poogger;


	private int lane = 12;

	/**
	 * Constructor de la clase Frog
	 *
	 * @param name nombre del elemento
	 * @param xPos posicion en x
	 * @param yPos posicion en y
	 */
	public Frog(String name, int xPos, int yPos) {
		super(name, xPos, yPos,  50, 37,'N', 0);

		health = 100;
		lifes = 5;
		score = 0;

	}

	/**
	 * Indica como puede afectar a otra rana
	 */
	public void affect(Frog frog) {
	}

	/**
	 * Reinicia las estadísticas de la rana, inidcando que muere y devolviéndola a
	 * la posición de partida.
	 */
	public void restart() {
		setPosition(347, 617);
		lane = 12;
		lifes--;

	}

	/**
	 * Hace que la rana salta en la direccion indicada
	 *
	 * @param direction Caracter direccion del salto, puede ser 'U', 'D', 'R' o 'L'.
	 */
	public void jump(char direction) {
		this.direction =direction;
		speed = 50;
		move();
	}

	/**
	 * Indica que puede tomar algo
	 */
	public void take() {

	}

	/**
	 * Hace que se deslice, es decir el efecto de que pueda ser transportada
	 *
	 * @param isToRight booleano indicando la direccion
	 * @param velocity  velocidad de desplazamiento
	 * @param distance  distancia de desplazamiento
	 */
	public void slide(boolean isToRight, int velocity, int distance) {

	}

	/**
	 * Cambia la posicion en X e Y de la rana reflejando el salto
	 */
	public void move() {

		if(direction == 'U') {
			if (super.yPosition > 50) {
				super.yPosition -= speed;
				lane--;
			}

		}

		if(direction == 'D') {
			if (super.yPosition < 617) {
				super.yPosition += speed;
				lane++;
			}
		}

		if(direction == 'L') {
			if (super.xPosition > 0) {
				super.xPosition -= speed;
			}
		}

		if(direction == 'R') {
			if (super.xPosition < 650) {
				super.xPosition += speed;
			}
		}
	}

	/**
	 * Devuelve las coordenadas de posicion actual
	 *
	 * @return arreglo con las coordenadas
	 */
	public int[] getPosition() {
		int[] position = new int[2];
		position[0] = super.xPosition;
		position[1] = super.yPosition;
		return position;
	}

	/**
	 * devuelve el núemro de carril en el que está
	 *
	 * @return número que inidca el carril.
	 */
	public int getLane() {
		return lane;
	}

	/**
	 * Muestra la cantidad de vidas.
	 *
	 * @return entero con la cantidad de vidas.
	 */
	public int getLifes() {
		return lifes;
	}

	/**
	 * Cambia la cantidad de vidas.
	 *
	 * @param l vidas de la rana
	 */
	public void setLifes(int l) {
		lifes = l;
	}
}