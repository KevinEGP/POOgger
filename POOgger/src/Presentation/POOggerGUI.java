package Presentation;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Domain.POOgger;

public class POOggerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container container;
	private Background background, logo;
	private myButton start, exit;

	private POOggerGUI() {
		
		super("POOGGER");
		setSize(745, 750);
		container = getContentPane();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setIconImage(new ImageIcon(getClass().getResource("/Resources/Icon/Icon.png")).getImage());
		prepareElementos();
		prepareAcciones();
	}

	private void prepareElementos() {
		background = new Background();
		background.setBackground(new ImageIcon(getClass().getResource("/Resources/Icon/background.jpg")));
		background.setBounds (0,0,745,750);
		logo = new Background();
		logo.setBackground(new ImageIcon(getClass().getResource("/Resources/Icon/Icon.png")));
		logo.setBounds (72,50,600,360);
			
		
		container.setLayout(null);
		
		start = new myButton("START");
		start.setLocation(225,500);
		start.setForeground(Color.YELLOW);
		exit = new myButton("EXIT");
		exit.setLocation(225,600);
		exit.setForeground(Color.MAGENTA);
		
		container.add(start);
		container.add(exit);
		container.add(logo);
		container.add(background);
		
	}
	
	private void prepareAcciones() {
		ActionListener exitListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				exit();				
			}
		};
		
		exit.addActionListener(exitListener);
		
		ActionListener startListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				start();				
			}
		};
		
		start.addActionListener(startListener);
	}
	
	private void exit() {
		POOggerGUI.this.dispose();
		System.exit(0);
	}
	
	private void start() {
		POOgger.newPoogger();
		update();
		POOggerGameGUI pooggerGameGUI = new POOggerGameGUI();
		pooggerGameGUI.setVisible(true);
	}
	
	private void update() {
		
	}
	
	public static void main(String[] args) {
		POOggerGUI pooggerGUI = new POOggerGUI();
		pooggerGUI.setVisible(true);
	}

}
