package Presentation;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class POOggerGUI extends Canvas {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 745, HEIGHT = 745;
	private static final String WINDOWNAME = "POOGER";
	private static JFrame windowGame;
	
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
	
	public static void main(String[] args) {
		POOggerGUI pooggerGUI = new POOggerGUI();
	}
}