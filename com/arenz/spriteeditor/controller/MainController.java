package com.arenz.spriteeditor.controller;

import javax.swing.JFrame;

import com.arenz.spriteeditor.controller.menu.MenuController;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.ui.MainWindowView;
import com.arenz.spriteeditor.ui.menu.MenuView;

public class MainController {

	private MainWindowView mainView;
	
	private MenuController menuController;
	
	private Project project;
	
	public MainController() {
		mainView = new MainWindowView(this, "Sprite Editor");
		
		createsMenu();
	}
	
	public void displayErrorMessage(String title, String text) {
		mainView.displayErrorMessage(title, text);
	}

	private void createsMenu() {
		MenuView menuView = new MenuView();
		menuController = new MenuController(this, menuView);
		mainView.setMenu(menuView);
	}

	public void setProject(Project newProject) {
		this.project = newProject;
		mainView.updateTitle(project.getTitle());
	}
}
