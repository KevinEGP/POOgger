package Domain;

public class Eagle extends Movable {

	public Eagle(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, WIDTH, HEIGHT,'L', 2);
	}

	@Override
	public void move() {

	}

	@Override
	public void affect(Frog frog) {

	}
}