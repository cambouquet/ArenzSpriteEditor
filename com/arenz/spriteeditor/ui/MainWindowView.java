/**
 * 
 */
package com.arenz.spriteeditor.ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

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
		window.setMinimumSize(new Dimension(500, 500));
		
//		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		window.setLayout(new GridLayout(2,1));
		
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
		if (wasEmpty) {
			spriteSelection = spriteSelectionView;
			//window.add(spriteSelection.getMainComponent(), LayoutHelper.getGridBagConstraints(0, 0, 1, 1));
			window.add(spriteSelection.getMainComponent());
		} else {
			window.remove(spriteSelection.getMainComponent());
			spriteSelection = spriteSelectionView;
			window.add(spriteSelection.getMainComponent());
			
		}
		window.revalidate();
		window.repaint();
	}

	public void setSpriteConfigurationPanel(SpriteConfigurationView spriteConfigurationView) {
		// TODO: refactor with setSpriteSelectionPanel when it will work
		boolean wasEmpty = (spriteConfiguration == null);
		if (wasEmpty) {
			spriteConfiguration = spriteConfigurationView;
			window.add(spriteConfiguration.getMainComponent());
			//window.add(spriteConfiguration.getMainComponent(), LayoutHelper.getGridBagConstraints(0, 1, 1, 1));
		} else {
			window.remove(spriteConfiguration.getMainComponent());
			spriteConfiguration = spriteConfigurationView;
			window.add(spriteConfiguration.getMainComponent());
		}

		window.revalidate();
		window.repaint();
		
	}
}
