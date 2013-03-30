/**
 * 
 */
package com.arenz.spriteeditor.ui;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author Camille
 *
 */
public class MainWindowView {
	
	private JFrame window = new JFrame();

	public MainWindowView() {
		window.setTitle("Sprite Editor");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setMinimumSize(new Dimension(500, 500));
		
		window.setVisible(true);
	}
}
