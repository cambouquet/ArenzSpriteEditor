/**
 * 
 */
package com.arenz.spriteeditor.controller.menu;

import java.io.File;
import java.io.IOException;

import com.arenz.spriteeditor.controller.MainController;
import com.arenz.spriteeditor.model.Project;

/**
 * @author Camille
 *
 */
public class MenuController {
	private MainController parentController;
	
	public MenuController(MainController mainController) {
		this.parentController = mainController;
	}

	public void createNewProject(File file) {
		try {
			String path = file.getCanonicalPath();
			String title = file.getName();
			Project newProject = new Project(title, path);
			parentController.setProject(newProject);
		} catch (IOException IOE) {
			IOE.printStackTrace();
			parentController.displayErrorMessage("IOException", "An IO exception was raised during creation of the new project.\nPlease try again.");
		}
	}
}
