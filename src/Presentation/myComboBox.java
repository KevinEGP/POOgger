package Presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class myComboBox extends JComboBox<Object> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public myComboBox() {
		super();
		setSize(400,55);
		setOpaque(false);

		setFont(new Font("Arial", Font.BOLD, 40));
		setForeground(new Color(30,30,30));
		setBackground(new Color(29,82,64,150));
		setFocusable(false);
		
	}
	
}
