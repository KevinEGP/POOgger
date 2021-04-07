package Domain;

public class Canoe extends Movable{
	private int color = (int)Math.round(Math.random());
	public Canoe(String name, int xPos, int yPos, int WIDTH, int HEIGHT) {
		super(name, xPos, yPos, 0, 0, 'L', 2);
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
	public void affect(Frog g) {
		if (color == 0) {
			
		}
		
	}

}
