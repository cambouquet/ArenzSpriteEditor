package com.arenz.spriteeditor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.arenz.spriteeditor.model.SpriteCategories;
import com.arenz.spriteeditor.model.SpriteCategory;
import com.arenz.spriteeditor.ui.SpriteSelectionView;
import com.arenz.spriteeditor.ui.Viewable;
import com.arenz.spriteeditor.ui.components.CategoryButton;

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
		view.addSpriteSelectionListener(category, new CategorySelectionListener(category));
	}
	
	public class CategorySelectionListener implements ActionListener {
		private SpriteCategory category;
		
		public CategorySelectionListener(SpriteCategory category) {
			this.category = category;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.selectCategory(category);
			((CategoryButton) arg0.getSource()).setEnabled(false);
		}
	}
}
