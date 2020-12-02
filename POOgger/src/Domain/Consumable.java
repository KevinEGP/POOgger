package Domain;

public abstract class Consumable extends Component {

	public Consumable(int xPos, int yPos, final int WIDTH, final int HEIGHT) {
		super(xPos, yPos, WIDTH, HEIGHT);
	}

	public abstract void activate();

	public abstract void affect();

}
