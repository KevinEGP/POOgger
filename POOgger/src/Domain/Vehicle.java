package Domain;

public class Vehicle extends Movable {

	public Vehicle(String name) {
		super(name, 745, 750, 123, 46, 'L', 2);
		isVisible = true;
	}
	

	void leaveElement(int probability) {

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