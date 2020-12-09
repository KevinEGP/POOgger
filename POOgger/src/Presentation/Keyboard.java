package Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener {

	private static final int KEYS_VALUES = 120;
	private final boolean[] keys = new boolean[KEYS_VALUES];

	public boolean esc;
	public boolean[] up = new boolean[2];
	public boolean[] down = new boolean[2];
	public boolean[] left = new boolean[2];
	public boolean[] right = new boolean[2];
	
	public long ts = 0;
	
	/*
	 * Updates the keyboard keys pressed.
	 */
	public void update() {
		
		esc = keys[KeyEvent.VK_ESCAPE];
	
		up[0] = keys[KeyEvent.VK_UP];
		down[0] = keys[KeyEvent.VK_DOWN];
		left[0] = keys[KeyEvent.VK_LEFT];
		right[0] = keys[KeyEvent.VK_RIGHT];
		
		up[1] = keys[KeyEvent.VK_W];
		down[1] = keys[KeyEvent.VK_S];
		left[1] = keys[KeyEvent.VK_A];
		right[1] = keys[KeyEvent.VK_D];
		
		keys[KeyEvent.VK_UP] = false;
		keys[KeyEvent.VK_UP] = false; 
		keys[KeyEvent.VK_DOWN] = false;
		keys[KeyEvent.VK_LEFT] = false;
		keys[KeyEvent.VK_RIGHT] = false;
		
		keys[KeyEvent.VK_W] = false;
		keys[KeyEvent.VK_S] = false;
		keys[KeyEvent.VK_A] = false;
		keys[KeyEvent.VK_D] = false;
		
				
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		//keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

}
