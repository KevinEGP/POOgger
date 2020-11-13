package Package Diagram.Domain;

public abstract class Component {

	private int color;

	private int xPosition;

	private int yPosition;

	private int width;

	private int height;

	public boolean stillInRange() {
		return false;
	}

	public boolean intersects(int[] corners) {
		return false;
	}

	public int[] getCorners() {
		return null;
	}

	public abstract void affect();

}
