package Domain;

public abstract class Consumable extends Component {

	private boolean wasUsed;

	public Consumable(String name, int xPos, int yPos, int width, int height) {
		super(name, xPos, yPos, width, height);
		setUsed(false);
	}

	public void setUsed(boolean value) {
		wasUsed = value;
	}

	private boolean wasUsed() {
		return wasUsed;
	}

	public abstract void activate();
}