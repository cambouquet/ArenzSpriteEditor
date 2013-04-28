package com.arenz.spriteeditor.ui;

import java.awt.Component;
import java.awt.Dimension;

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
		
		spritesScrollPane = PanelConstructorHelper.createScrollPane("Display", spriteView, Constants.SPRITE_PANEL_HEIGHT*3, Constants.WINDOW_WIDTH/3);
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
