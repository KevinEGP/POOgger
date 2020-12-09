package Domain;

import java.awt.Rectangle;
import java.io.Serializable;

public abstract class Component implements Serializable {

	// private int color;
	protected int xPosition;
	protected int yPosition;
	protected final int WIDTH;
	protected final int HEIGHT;
	protected final String name;
	public boolean isVisible;

	public Component(String name, int xPos, int yPos, final int WIDTH, final int HEIGHT) {
		xPosition = xPos;
		yPosition = yPos;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.name = name;
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

	public int[] getCorners() {
		int[] corners = new int[4];
		corners[0] = xPosition;
		corners[1] = yPosition;
		corners[2] = WIDTH;
		corners[3] = HEIGHT;
		return corners;
	}

	public int[] getValues() {
		return new int[] { xPosition, yPosition, WIDTH, HEIGHT };
	}

	public abstract void affect(Frog frog);
	
	public String getName() {
		return name;
	}
	
	public void setPosition(int xPos, int yPos) {
		xPosition = xPos;
		yPosition = yPos;
	}

}
