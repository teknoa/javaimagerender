package de.imagetest;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame{

	private Graphview graphview;

	public Main() {
		graphview = new Graphview();
		setSize(600,400);
		setLayout(new BorderLayout());
		add(graphview, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		graphview.createNodes();
		graphview.repaint();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					graphview.updateNodePos();
					graphview.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
