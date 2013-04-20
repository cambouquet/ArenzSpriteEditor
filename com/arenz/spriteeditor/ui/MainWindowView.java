/**
 * 
 */
package com.arenz.spriteeditor.ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;

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
	private SpriteConfigurationView spriteConfiguration;
	
	public MainWindowView(MainController controller, String title) {
		window.setTitle(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setMinimumSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
		
		window.getContentPane().setLayout(new GridBagLayout());
		
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
		boolean wasEmpty = (spriteSelection == null);
		if (!wasEmpty) {
			window.remove(spriteSelection.getMainComponent());
		}
		
		spriteSelection = spriteSelectionView;
		window.add(spriteSelection.getMainComponent(), LayoutHelper.getGridBagConstraints(0, 0, 1, 1));
		
		window.revalidate();
		window.repaint();
	}

	public void setSpriteConfigurationPanel(SpriteConfigurationView spriteConfigurationView) {
		// TODO: refactor with setSpriteSelectionPanel when it will work
		boolean wasEmpty = (spriteConfiguration == null);
		if (!wasEmpty) {
			window.remove(spriteConfiguration.getMainComponent());
		}
		spriteConfiguration = spriteConfigurationView;
		window.add(spriteConfiguration.getMainComponent(), LayoutHelper.getGridBagConstraints(0, 1, 1, 1));

		window.revalidate();
		window.repaint();
		
	}
}
