package Domain;

public class Snake extends Movable {

	public Snake(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, WIDTH, HEIGHT, 'L', 2);
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
		// TODO Auto-generated method stub
		
	}
}