package com.arenz.spriteeditor.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.arenz.spriteeditor.controller.file.ImageFileFilter;
import com.arenz.spriteeditor.controller.menu.MenuController;
import com.arenz.spriteeditor.model.DisplayableElement;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.model.Sprite;
import com.arenz.spriteeditor.model.SpriteCategories;
import com.arenz.spriteeditor.model.SpriteCategory;
import com.arenz.spriteeditor.ui.MainWindowView;
import com.arenz.spriteeditor.ui.SpriteConfigurationView;
import com.arenz.spriteeditor.ui.SpriteSelectionView;
import com.arenz.spriteeditor.ui.Viewable;
import com.arenz.spriteeditor.ui.menu.MenuView;

public class MainController extends AbstractController {

	private MainWindowView mainView;

	private MenuController menuController;

	private SpriteSelectionController spriteSelectionController;

	private SpriteConfigurationController spriteConfigurationController;

	private Project project;

	private static final String SOFTWARE_NAME = "Sprite Editor";
	
	public MainController() {
		mainView = new MainWindowView(this, SOFTWARE_NAME);

		createMenu();
		createMainPanels();
	}

	private void createMainPanels() {
		createSpriteSelectionPanel();
		createSpriteConfigurationPanel();
	}

	private void createSpriteConfigurationPanel() {
		SpriteConfigurationView spriteConfigurationView = new SpriteConfigurationView();
		spriteConfigurationController = new SpriteConfigurationController(this, spriteConfigurationView);
		mainView.setSpriteConfigurationPanel(spriteConfigurationView);
	}

	private void createSpriteSelectionPanel() {
		SpriteCategories categories = new SpriteCategories();
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
	 * 
	 * @param newProject
	 */
	public void setNewProject(Project newProject) {
		this.project = newProject;
		createSpriteSelectionPanel();
		mainView.updateTitle(SOFTWARE_NAME + " - " + project.getTitle());
		loadImages();
	}

	private void loadImages() {
		File projectFolder = project.getRootFolder();
		int id = 0;
		for (File child : projectFolder.listFiles()) {
			if (isValidCategoryFolder(child)) {
				ArrayList<DisplayableElement> listImages = loadImagesFromFolder(child);
				createCategory(child.getName(), listImages, id);
				id++;
			}

		}
	}

	private boolean isValidCategoryFolder(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return false;
	}

	private void createCategory(String name, ArrayList<DisplayableElement> listImages, int id) {
		SpriteCategory category = new SpriteCategory(name, id, listImages);
		spriteSelectionController.addCategory(category);
		System.out.println("New category added: " + category.getName() + " - " + category.getId());
	}

	private ArrayList<DisplayableElement> loadImagesFromFolder(File file) {
		FileFilter fileFilter = new ImageFileFilter();
		ArrayList<DisplayableElement> spriteList = null;

		spriteList = new ArrayList<DisplayableElement>();
		for (File child : file.listFiles(fileFilter)) {
			try {
				Image image = ImageIO.read(child);
				Sprite sprite = new Sprite(image, child.getName());
				spriteList.add(sprite);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return spriteList;
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

	public void configureNewSprite(Sprite sprite) {
		spriteConfigurationController.configureNewSprite(sprite);

		mainView.getViewWindow().revalidate();
		mainView.getViewWindow().repaint();
	}
}
