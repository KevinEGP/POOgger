package Presentation;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class POOggerGameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container container;
	private Background gameBackGround;

	POOggerGameGUI() {
		super("POOGGER");
		setSize(745, 750);
		container = getContentPane();
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon/Icon.png")).getImage());
		prepareElementos();
	}

	private void prepareElementos() {
		gameBackGround = new Background();
		gameBackGround.setBackground(new ImageIcon(getClass().getResource("/Resources/Maps/AtDay/MapDay.jpg")));
		gameBackGround.setBounds (0,0,745,750);
		
		container.setLayout(null);
		JLabel frog = new JLabel(new ImageIcon(getClass().getResource("/Resources/Froggs/Frog1.png")));
		frog.setBounds(347, 713, 50, 37);
		
		container.add(frog);
		container.add(gameBackGround);
		
	}
}
