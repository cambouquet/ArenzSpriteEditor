package com.arenz.spriteeditor.controller;

import com.arenz.spriteeditor.ui.MainWindowView;
import com.arenz.spriteeditor.ui.menu.MenuView;

public class MainController {

	private MainWindowView mainView;
	
	public MainController() {
		mainView = new MainWindowView(this, "Sprite Editor");
		
		createsMenu();
	}

	private void createsMenu() {
		MenuView menuView = new MenuView();
		mainView.setMenu(menuView);
	}
}
