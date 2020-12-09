package Domain;

public class Home extends Component {

	private boolean isHabitable;
	private boolean hasBeenTaken;
	private Component occupator;
	

	public Home(String name, int xPos, int yPos) {
		super(name, xPos, yPos, 38, 50);
		hasBeenTaken = false;
		isHabitable = true;
		isVisible = false;
	}

	public void setHabitable(boolean b) {
		isHabitable = b;
		if (!isHabitable) {
			generateOccupier();
		}
	}

	public void generateOccupier() {

	}

	public boolean itsTaken() {
		return hasBeenTaken;
	}

	@Override
	public void affect(Frog frog) {
		if (isHabitable) {
			isVisible = true;
			isHabitable = false;
			frog.lifes++;
			POOgger.getPoogger().homes--;
			frog.restart();
		}
	}

}