package com.arenz.spriteeditor.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.arenz.spriteeditor.model.Sprite;
import com.arenz.spriteeditor.ui.components.ImagePanel;
import com.arenz.spriteeditor.ui.components.PanelConstructorHelper;

public class SpriteConfigurationView {
	private JPanel mainPanel = new JPanel();
	private ImagePanel spriteView = new ImagePanel(null);
	private Sprite sprite;
	private JScrollPane spritesScrollPane;
	private JTextField spriteNameTextField;
	private JButton saveButton = new JButton("Save");
	
	public SpriteConfigurationView() {
		mainPanel.add(spriteView);
		mainPanel.setMinimumSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SPRITE_PANEL_HEIGHT*3));
		mainPanel.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - Constants.SPRITE_PANEL_HEIGHT*3));
		
		mainPanel.setLayout(new GridBagLayout());
		//mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addPanels();
		
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
	private void addPanels() {
		spritesScrollPane = PanelConstructorHelper.createScrollPane("Display", spriteView, Constants.WINDOW_WIDTH/2, Constants.WINDOW_WIDTH/2);
		
		mainPanel.add(spritesScrollPane, LayoutHelper.getGridBagConstraints(0, 0, 1, 1));

		// description panel
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setLayout(new GridBagLayout());
		spriteNameTextField = new JTextField(15);
		descriptionPanel.add(new JLabel("Name"), LayoutHelper.getGridBagConstraints(0, 0, 1, 1));
		descriptionPanel.add(spriteNameTextField, LayoutHelper.getGridBagConstraints(1, 0, 1, 1));
		mainPanel.add(descriptionPanel, LayoutHelper.getGridBagConstraints(0, 1, 1, 1));
		
		// save button
		mainPanel.add(saveButton, LayoutHelper.getGridBagConstraints(0, 2, GridBagConstraints.REMAINDER, GridBagConstraints.REMAINDER));
	}

	public void displayNewSprite(Sprite sprite) {
		//spritesScrollPane.remove(spriteView);
		this.sprite = sprite;
		this.spriteView = new ImagePanel(sprite.getImage());
		//spritesScrollPane.add(spriteView);

		spritesScrollPane.setViewportView(spriteView);
		spritesScrollPane.revalidate();
		spritesScrollPane.repaint();
		
		spriteNameTextField.setText(sprite.getName());
		//spriteNameTextField.revalidate();
		//spriteNameTextField.repaint();
		
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	public Component getMainComponent() {
		return mainPanel;
	}

	public void addSaveButtonListener(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
}
