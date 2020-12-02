package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyBoard implements KeyListener {

	private static final int KEYS_VALUES = 120;
	private final boolean[] keys = new boolean[KEYS_VALUES];

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;

	public KeyBoard() {

	}

	public void update() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		// up = keys[KeyEvent.VK_W];
		// down = keys[KeyEvent.VK_S];
		// left = keys[KeyEvent.VK_A];
		// right = keys[KeyEvent.VK_D];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
