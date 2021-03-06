package com.arenz.spriteeditor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import com.arenz.spriteeditor.model.DisplayableElement;
import com.arenz.spriteeditor.model.Sprite;
import com.arenz.spriteeditor.model.SpriteCategories;
import com.arenz.spriteeditor.model.SpriteCategory;
import com.arenz.spriteeditor.ui.SpriteSelectionView;
import com.arenz.spriteeditor.ui.Viewable;
import com.arenz.spriteeditor.ui.components.CategoryButton;
import com.arenz.spriteeditor.ui.components.SpriteButton;

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
		view.addCategory(category, new CategorySelectionListener());
	}
	
	public class CategorySelectionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CategoryButton catButton = (CategoryButton) arg0.getSource();
			view.selectCategory(catButton);
			
			displaySprites(catButton.getCategory());
		}

		private void displaySprites(SpriteCategory category) {
			Iterator<DisplayableElement> ite = category.getElementsIterator();
			
			while (ite.hasNext()) {
				DisplayableElement element = ite.next();
				view.displaySprite(element, new SpriteSelectionListener());
			}
		}
	}
	
	public class SpriteSelectionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			SpriteButton spriteButton = (SpriteButton) arg0.getSource();
			view.selectSprite(spriteButton);
			parentController.configureNewSprite((Sprite) spriteButton.getElement());
		}
	}
}
