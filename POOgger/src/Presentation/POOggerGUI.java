package Presentation;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class POOggerGUI extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 745, HEIGHT = 745;
	private static final String WINDOWNAME = "POOGGER";
	private static JFrame windowGame;

	private static Thread thread;

	private POOggerGUI() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		windowGame = new JFrame(WINDOWNAME);
		windowGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowGame.setResizable(false);
		windowGame.setLayout(new BorderLayout());
		windowGame.add(this, BorderLayout.CENTER);
		windowGame.pack();
		windowGame.setLocationRelativeTo(null);
		windowGame.setVisible(true);
	}

	private void begin() {
		thread = new Thread(this, "GUI Execution");
		thread.start();
	}

	private void stop() {

	}

	@Override
	public void run() {
		JOptionPane.showMessageDialog(this, "Thread is Active");
	}

	public static void main(String[] args) {
		POOggerGUI pooggerGUI = new POOggerGUI();
		pooggerGUI.begin();
	}
}