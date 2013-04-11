package com.arenz.spriteeditor.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale.Category;

import javax.imageio.ImageIO;

import com.arenz.spriteeditor.controller.file.ImageFileFilter;
import com.arenz.spriteeditor.controller.menu.MenuController;
import com.arenz.spriteeditor.model.DisplayableElement;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.model.Sprite;
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
		spriteSelectionController = new SpriteSelectionController(this, spriteSelectionView, categories);
		mainView.setSpriteSelectionPanel(spriteSelectionView);
	}

	private void createMenu() {
		MenuView menuView = new MenuView();
		menuController = new MenuController(this, menuView);
		mainView.setMenu(menuView);
	}

	/**
	 * Called for a new or a newly opened project.
	 * @param newProject
	 */
	public void setNewProject(Project newProject) {
		this.project = newProject;
		mainView.updateTitle(SOFTWARE_NAME + " - " + project.getTitle());
		loadImages();
	}

	private void loadImages() {
		File projectFolder = project.getRootFolder();
		for (File child : projectFolder.listFiles()) {
			loadImagesFromFolder(child);
		}
	}

	private void loadImagesFromFolder(File file) {
		FileFilter fileFilter = new ImageFileFilter();
		
		if (file.isDirectory()) {
			ArrayList<DisplayableElement> spriteList = new ArrayList<DisplayableElement>();
			for (File child : file.listFiles(fileFilter)) {
				Image image;
				try {
					image = ImageIO.read(child);
					Sprite sprite = new Sprite(image, child.getName());
					spriteList.add(sprite);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			SpriteCategory category = new SpriteCategory(file.getName(), 0, spriteList);
			spriteSelectionController.addCategory(category);
			System.out.println("New category added: " + category.getNom());
		}
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
