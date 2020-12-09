package Domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Lane implements Serializable {

	private final int NUMBER;
	private boolean isInteractive;
	private ArrayList<Component> components;

	public Lane(final int NUMBER, POOgger poogger) {
		this.NUMBER = NUMBER;
		components = new ArrayList<Component>();
		if (NUMBER >= 7) { // If is a river part:
			isInteractive = true; // Frog dies if fall into river
		} else { // Is a roadway part
			isInteractive = false;
		}
	}
	/**
	 * 
	 * @param component
	 */
	public void addComponent(Component component) {
		components.add(component);
	}

	public void affect(Frog frog) {
		boolean intersects = false;
		boolean atLeastOneintersects = false;
		for (Component c: components) {
			int[] corners = c.getCorners();
			intersects = intersect(frog.getCorners(), corners);
			if (intersects) {
				c.affect(frog);
				atLeastOneintersects = false;
				break;
			}
		}
		
		if (
				NUMBER <=5  && (!intersects || atLeastOneintersects)){
			frog.restart();
		}
	}

	private boolean intersect(int[] frog_corners, int[] corners) {
		Rectangle frog = new Rectangle(frog_corners[0],frog_corners[1],frog_corners[2],frog_corners[3]);
		Rectangle component = new Rectangle(corners[0],corners[1],corners[2],corners[3]);
		return frog.intersects(component);
	}

	public void moveComponents() {
		for (Component c : components) {
			try {
				((Movable) c).move();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Component> getComponents(){
		return components;
	}
}