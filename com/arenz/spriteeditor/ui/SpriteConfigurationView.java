package com.arenz.spriteeditor.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.arenz.spriteeditor.model.Sprite;
import com.arenz.spriteeditor.ui.components.ImagePanel;
import com.arenz.spriteeditor.ui.components.PanelConstructorHelper;

public class SpriteConfigurationView {
	private JPanel mainPanel = new JPanel();
	private ImagePanel spriteView = new ImagePanel(null);
	private Sprite sprite;
	private JScrollPane spritesScrollPane;
	
	public SpriteConfigurationView() {
		mainPanel.add(spriteView);
		mainPanel.setMinimumSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SPRITE_PANEL_HEIGHT*3));
		mainPanel.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SPRITE_PANEL_HEIGHT*3));
		
		//mainPanel.setLayout(new GridBagLayout());
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		spritesScrollPane = PanelConstructorHelper.createScrollPane("Display", spriteView, Constants.WINDOW_WIDTH/2, Constants.WINDOW_WIDTH/2);
		
		//mainPanel.add(spritesScrollPane, LayoutHelper.getGridBagConstraints(0, 0, 1, 1));
		mainPanel.add(spritesScrollPane);
		
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
	public void displayNewSprite(Sprite sprite) {
		//spritesScrollPane.remove(spriteView);
		this.sprite = sprite;
		this.spriteView = new ImagePanel(sprite.getImage());
		//spritesScrollPane.add(spriteView);

		spritesScrollPane.setViewportView(spriteView);
		spritesScrollPane.revalidate();
		spritesScrollPane.repaint();
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	public Component getMainComponent() {
		return mainPanel;
	}
}
