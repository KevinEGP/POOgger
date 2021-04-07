package Presentation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image backGround;

	public void paintComponent(Graphics g) {
		int width = this.getSize().width;
		int height = this.getSize().height;
		if (this.backGround != null) {
			g.drawImage(this.backGround, 0, 0, width, height, null);
		}
		super.paintComponent(g);
	}

	public void setBackground(ImageIcon image) {
		this.setOpaque(false);
		this.backGround = image.getImage();
		repaint();
	}
}
