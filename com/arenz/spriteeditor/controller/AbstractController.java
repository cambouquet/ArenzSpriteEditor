package com.arenz.spriteeditor.controller;

import com.arenz.spriteeditor.ui.Viewable;
import com.arenz.spriteeditor.ui.dialogs.DialogHelper;

public abstract class AbstractController {
	public void displayErrorMessage(String title, String text) {
		DialogHelper.displayErrorMessage(getWindow().getViewWindow(), title, text);
	}

	public void transferErrorMessage(String title, String text) {
		getParentController().displayErrorMessage(title, text);
	}
	
	public abstract AbstractController getParentController();
	public abstract Viewable getWindow();	
}