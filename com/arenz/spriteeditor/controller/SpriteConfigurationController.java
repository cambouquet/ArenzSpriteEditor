package com.arenz.spriteeditor.controller;

import com.arenz.spriteeditor.model.Sprite;
import com.arenz.spriteeditor.ui.SpriteConfigurationView;
import com.arenz.spriteeditor.ui.Viewable;

public class SpriteConfigurationController extends AbstractController {
	
	private MainController parentController;
	
	private SpriteConfigurationView view;
	
	public SpriteConfigurationController(MainController parentController, SpriteConfigurationView view) {
		this.parentController = parentController;
		this.view = view;
	}
	
	public void configureNewSprite(Sprite sprite) {
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

}
