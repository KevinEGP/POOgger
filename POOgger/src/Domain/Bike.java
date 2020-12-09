package Domain;

public class Bike extends Movable {

	public Bike(String name) {
		super("Bike", 745, 750, 78, 46, 'L', 2);
		isVisible = true;
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