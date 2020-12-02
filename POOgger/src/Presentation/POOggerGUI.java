package Presentation;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class POOggerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container container;
	private BackGroundFormat gameBackGround;

	private POOggerGUI() {
		super("POOGGER");
		setSize(745 + 18, 745 + 45);
		container = getContentPane();
		setResizable(false);
		setLocationRelativeTo(null);
		prepareElementos();
	}

	private void prepareElementos() {
		setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon/Icon.png")).getImage());
		gameBackGround = new BackGroundFormat();
		gameBackGround.setLayout(new FlowLayout());
		gameBackGround.setBackground(new ImageIcon(getClass().getResource("/Resources/Maps/AtDay/MapDay.jpg")));
		container.add(gameBackGround);
	}

	public static void main(String[] args) {
		POOggerGUI pooggerGUI = new POOggerGUI();
		pooggerGUI.setVisible(true);
	}

}
