package Presentation;

import java.awt.Font;

import javax.swing.*;

public class myButton extends JButton {
	
	public myButton(String name) {
		super(name);
		setSize(300,90);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFont(new Font("Arial", Font.BOLD, 80));
		setFocusable(false);
	}
}
