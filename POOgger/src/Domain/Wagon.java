package Domain;

public class Wagon extends Movable {

	public Wagon(String name) {
		super(name, 745, 750, 67, 46, 'L', 2);
		isVisible = true;
	}

	public void vacate() {

	}

	@Override
	public void move() {
		if (super.xPosition <= -super.WIDTH) {
			super.xPosition = 745;
		}
		if(direction == 'L') {
			if (super.xPosition > -super.WIDTH) {
				super.xPosition -= speed;
			}	
		}
		
		if(direction == 'R') {
			if (super.xPosition < 745) {
				super.xPosition += speed;
			}
		}
		
	}

	@Override
	public void affect(Frog frog) {
		frog.restart();		
	}

}