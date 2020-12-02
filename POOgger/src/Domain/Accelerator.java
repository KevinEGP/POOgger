package Domain;

public class Accelerator extends Consumable {

	private int jumpLength;

	public Accelerator(int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(xPos, yPos, 118, 46);
		jumpLength = 100;
	}

	@Override
	public void activate() {

	}

	@Override
	public void affect() {

	}

}
