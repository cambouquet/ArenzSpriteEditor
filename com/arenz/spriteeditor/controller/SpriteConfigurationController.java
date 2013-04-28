package com.arenz.spriteeditor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.arenz.spriteeditor.model.Sprite;
import com.arenz.spriteeditor.ui.SpriteConfigurationView;
import com.arenz.spriteeditor.ui.Viewable;

public class SpriteConfigurationController extends AbstractController {
	
	private MainController parentController;
	
	private SpriteConfigurationView view;
	
	private Sprite sprite;
	
	public SpriteConfigurationController(MainController parentController, SpriteConfigurationView view) {
		this.parentController = parentController;
		this.view = view;
		view.addSaveButtonListener(new SpriteSaveListener());
	}
	
	public void configureNewSprite(Sprite sprite) {
		this.sprite = sprite;
		view.displayNewSprite(sprite);
	}
 
	@Override
	public AbstractController getParentController() {
		return parentController;
	}

	@Override
	public Viewable getWindow() {
		return parentController.getWindow();
	}

	public class SpriteSaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SpriteSaver spriteSaver = new SpriteSaver(sprite);
			spriteSaver.save();
		}
		
	}
}
