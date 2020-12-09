package Domain;

import java.io.Serializable;

public abstract class Movable extends Component implements Serializable {

	public Movable(String name, int xPos, int yPos, int WIDTH, int HEIGHT, char direction, int speed) {
		super(name, xPos, yPos, WIDTH, HEIGHT);
		this.direction = direction;
		this.speed = speed;
	}

	protected int speed;

	protected char direction;

	public abstract void move();

}
