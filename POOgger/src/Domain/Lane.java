package Domain;

import java.util.ArrayList;

public class Lane extends Component {

	private final int NUMBER;
	private boolean isInteractive;
	private ArrayList<Component> components;
	private POOgger poogger;

	public Lane(int xPos, int yPos, final int WIDTH, final int HEIGHT, final int NUMBER, POOgger poogger) {
		super(xPos, yPos, WIDTH, HEIGHT);
		this.NUMBER = NUMBER;
		this.poogger = poogger;
		components = new ArrayList<Component>();
	}

	public void addComponent(Component component) {
		components.add(component);
	}

	private void generateComponents() {

	}

	public void makeInteractive(boolean b) {
		isInteractive = b;
	}

	public void affect() {

	}
}
