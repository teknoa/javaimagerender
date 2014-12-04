package de.imagetest;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public class Graphview extends JComponent {

	List<Node> listNodes;
	
	
	public Graphview() {
		listNodes = new ArrayList<>();
		setLayout(null);
	}
	
	public void createNodes() {
		for(int i = 0; i < 500; i++) {
			Node n = new Node(new Point((int)((double)getWidth() * Math.random()), 
										(int)((double)getWidth() * Math.random())));
			listNodes.add(n);
			add(n);
		}
	}
	
	public void updateNodePos() {
		for(Node n : listNodes) {
			if(n.getX() <= 0 || n.getX() > getWidth())
				n.invertMoveX();
			if(n.getY() <= 0 || n.getY() > getHeight())
				n.invertMoveY();
			n.moveNode();
		}
	}
}
