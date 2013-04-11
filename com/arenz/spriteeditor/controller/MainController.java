package com.arenz.spriteeditor.controller;

import java.util.ArrayList;
import java.util.Locale.Category;

import com.arenz.spriteeditor.controller.menu.MenuController;
import com.arenz.spriteeditor.model.DisplayableElement;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.model.SpriteCategories;
import com.arenz.spriteeditor.model.SpriteCategory;
import com.arenz.spriteeditor.ui.MainWindowView;
import com.arenz.spriteeditor.ui.SpriteSelectionView;
import com.arenz.spriteeditor.ui.Viewable;
import com.arenz.spriteeditor.ui.menu.MenuView;

public class MainController extends AbstractController {

	private MainWindowView mainView;
	
	private MenuController menuController;
	
	private SpriteSelectionController spriteSelectionController;
	
	private Project project;
	
	private static final String SOFTWARE_NAME = "Sprite Editor";
	
	public MainController() {
		mainView = new MainWindowView(this, SOFTWARE_NAME);
		
		createMenu();
		createMainPanels();
	}
	
	private void createMainPanels() {
		createSpriteSelectionPanel();
	}

	private void createSpriteSelectionPanel() {
		SpriteCategories categories = new SpriteCategories();
		SpriteCategory category = new SpriteCategory("New", 0, new ArrayList<DisplayableElement>());
		categories.add(category);
		SpriteSelectionView spriteSelectionView = new SpriteSelectionView(categories);
		spriteSelectionController = new SpriteSelectionController(this, spriteSelectionView);
		mainView.setSpriteSelectionPanel(spriteSelectionView);
	}

	private void createMenu() {
		MenuView menuView = new MenuView();
		menuController = new MenuController(this, menuView);
		mainView.setMenu(menuView);
	}

	public void setProject(Project newProject) {
		this.project = newProject;
		mainView.updateTitle(SOFTWARE_NAME + " - " + project.getTitle());
	}

	@Override
	public AbstractController getParentController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viewable getWindow() {
		return mainView;
	}
}
