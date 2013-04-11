package com.arenz.spriteeditor.controller;

import com.arenz.spriteeditor.model.SpriteCategories;
import com.arenz.spriteeditor.model.SpriteCategory;
import com.arenz.spriteeditor.ui.SpriteSelectionView;
import com.arenz.spriteeditor.ui.Viewable;

public class SpriteSelectionController extends AbstractController {
	private MainController parentController;
	private SpriteSelectionView view;
	private SpriteCategories categories;
	
	public SpriteSelectionController(MainController parentController, SpriteSelectionView view, SpriteCategories categories) {
		this.parentController = parentController;
		this.view = view;
		this.categories = categories;
	}
	
	@Override
	public AbstractController getParentController() {
		return parentController;
	}

	@Override
	public Viewable getWindow() {
		return parentController.getWindow();
	}
	
	public void addCategory(SpriteCategory category) {
		categories.add(category);
		view.updateCategories();
	}
}
