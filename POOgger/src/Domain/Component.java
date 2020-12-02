package Domain;

import java.awt.Rectangle;

public abstract class Component {

	// private int color;
	private int xPosition;
	private int yPosition;
	private final int WIDTH;
	private final int HEIGHT;

	public Component(int xPos, int yPos, final int WIDTH, final int HEIGHT) {
		xPosition = xPos;
		yPosition = yPos;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
	}

	public boolean stillInRange() {
		if (xPosition < 0 || xPosition > 745) {
			return false;
		}
		return true;
	}

	public boolean intersects(int[] values) {
		Rectangle me = new Rectangle(xPosition, yPosition, WIDTH, HEIGHT);
		Rectangle other = new Rectangle(values[0], values[1], values[2], values[3]);
		if (me.intersects(other))
			return true;
		return false;
	}

	public int[][] getCorners() {
		int[][] corners = new int[4][2];
		corners[0] = new int[] { xPosition, yPosition };
		corners[1] = new int[] { xPosition + WIDTH, yPosition };
		corners[2] = new int[] { xPosition + WIDTH, yPosition + HEIGHT };
		corners[3] = new int[] { xPosition, yPosition + HEIGHT };
		return corners;
	}

	public int[] getValues() {
		return new int[] { xPosition, yPosition, WIDTH, HEIGHT };
	}

	public abstract void affect();

}
