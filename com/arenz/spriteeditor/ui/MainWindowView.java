/**
 * 
 */
package com.arenz.spriteeditor.ui;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

import com.arenz.spriteeditor.controller.MainController;
import com.arenz.spriteeditor.ui.menu.MenuView;

/**
 * @author Camille
 *
 */
public class MainWindowView implements Viewable {
	
	private JFrame window = new JFrame();
	private MenuView menu;
	private SpriteSelectionView spriteSelection;
	
	public MainWindowView(MainController controller, String title) {
		window.setTitle(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setMinimumSize(new Dimension(100, 100));
		
		window.setVisible(true);
	}
	
	public void setMenu(MenuView menu) {
		window.setJMenuBar(menu.getMenuBar());
	}

	public void updateTitle(String title) {
		window.setTitle(title);
	}

	public Frame getViewWindow() {
		return window;
	}

	public void setSpriteSelectionPanel(SpriteSelectionView spriteSelectionView) {
		if (spriteSelection != null) {
			window.remove(this.spriteSelection.getMainComponent());
		}
		spriteSelection = spriteSelectionView;
		window.add(spriteSelection.getMainComponent());
		window.revalidate();
		window.repaint();
	}
}
