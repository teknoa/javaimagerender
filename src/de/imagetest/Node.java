package de.imagetest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Node extends JPanel {

	BufferedImage renderedImage;
	
	int moveX;
	int moveY;
	
	public Node(Point pos) {
		setBounds(pos.x, pos.y, 20, 20);
		setBackground(Color.white);
		
		moveX = Math.random() < 0.5 ? -1 : 1;
		moveY = Math.random() < 0.5 ? -1 : 1;
	} 
	
	public void recreate() {
		renderedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		drawShape(renderedImage.getGraphics());
	}

	private void drawShape(Graphics graphics) {
		Graphics2D g = (Graphics2D)graphics;
		g.setBackground(Color.white);
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, getWidth(), getHeight());
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
//		super.paintComponent(g);
		
		if(renderedImage == null)
			recreate();
		
		g.drawImage(renderedImage, 0, 0, null);
	}

	public void invertMoveX(){
		moveX *= -1;
	}

	public void invertMoveY(){
		moveY *= -1;
	}

	public void moveNode() {
		setBounds(getX() + moveX, getY() + moveY, getWidth(), getHeight());
	}
}
