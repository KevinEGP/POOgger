package Domain;

public class Turtles extends Movable {

	private int quantity;

	public Turtles(String name) {
		super(name, 745, 750, 58, 46, 'L', 2);
		isVisible = true;
	}

	public void move() {
		double ran =  Math.random()*200;//Generate random number between 0 and WIDTH.
		int respown = (int) ran;//respown x random position.
		if (super.xPosition <= -WIDTH-respown) {
			super.xPosition = 745;
		}
		if(super.direction == 'L') {
			if (super.xPosition > -super.WIDTH) {
				super.xPosition -= super.speed;
			}	
		}
		
		if(super.direction == 'R') {
			if (super.xPosition < 745) {
				super.xPosition += super.speed;
			}
		}	
	}
	
	@Override
	public void affect(Frog frog) {
		frog.speed = speed;
		frog.direction = direction;		
		frog.move();
	}
}