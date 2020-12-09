package Domain;

public class Frog extends Movable {


	private int name;
	private int health;
	protected int lifes;
	private int score;
	
	private Consumable powers;
	
	private POOgger poogger;
	
	
	private int lane = 12;
	
	public Frog(String name, int xPos, int yPos) {
		super(name, xPos, yPos,  50, 37,'N', 0);
		
		health = 100;
		lifes = 5;
		score = 0;
		
	}

	public void affect(Frog frog) {
	}
	
	public void restart() {
		setPosition(347, 617);
		lane = 12;
		lifes--;
		
	}

	public void jump(char direction) {
		this.direction =direction; 
		speed = 50;
		move();
	}

	public void take() {

	}

	public void slide(boolean isToRight, int velocity, int distance) {

	}
	
	public void move() {
		
		if(direction == 'U') {
			if (super.yPosition > 50) {
				super.yPosition -= speed;
				lane--;
			}
			
		}
		
		if(direction == 'D') {
			if (super.yPosition < 617) {
				super.yPosition += speed;
				lane++;
			}
		}
		
		if(direction == 'L') {
			if (super.xPosition > 0) {
				super.xPosition -= speed;
			}	
		}
		
		if(direction == 'R') {
			if (super.xPosition < 650) {
				super.xPosition += speed;
			}
		}
	}
	
	public int[] getPosition() {
		int[] position = new int[2];
		position[0] = super.xPosition;
		position[1] = super.yPosition;
		return position;
	}
	
	public int getLane() {
		return lane;
	}

	public int getLifes() {
		return lifes;
	}
}
