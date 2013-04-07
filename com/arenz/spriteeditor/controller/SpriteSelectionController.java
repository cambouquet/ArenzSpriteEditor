package com.arenz.spriteeditor.controller;

import com.arenz.spriteeditor.ui.SpriteSelectionView;
import com.arenz.spriteeditor.ui.Viewable;

public class SpriteSelectionController extends AbstractController {
	private MainController parentController;
	private SpriteSelectionView view;
	
	public SpriteSelectionController(MainController parentController, SpriteSelectionView view) {
		this.parentController = parentController;
		this.view = view;
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
