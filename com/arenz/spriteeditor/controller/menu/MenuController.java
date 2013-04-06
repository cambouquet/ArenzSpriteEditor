/**
 * 
 */
package com.arenz.spriteeditor.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import com.arenz.spriteeditor.controller.MainController;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.ui.dialogs.DialogHelper;
import com.arenz.spriteeditor.ui.dialogs.NewProjectDialog;
import com.arenz.spriteeditor.ui.menu.MenuView;

/**
 * @author Camille
 * 
 */
public class MenuController {
	private MainController parentController;
	private MenuView menuView;

	public MenuController(MainController mainController, MenuView menuView) {
		this.parentController = mainController;
		this.menuView = menuView;
		
		addListeners();
	}

	private void addListeners() {
		menuView.addNewProjectListener(new NewProjectListener());
		menuView.addSaveProjectListener(new SaveProjectListener());
		menuView.addLoadProjectListener(new LoadProjectListener());
		
		menuView.addQuitProjectListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
	}


	public class NewProjectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			NewProjectDialog newProjectDialog = new NewProjectDialog();
			NewProjectController newProjectController = new NewProjectController(MenuController.this, newProjectDialog);
			newProjectController.displayView();
			/*
			JFileChooser newFileChooser = DialogHelper
					.createHomeFileChooser();
			newFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			if (newFileChooser.showDialog(null, "Create") == JFileChooser.APPROVE_OPTION) {
				createNewProject(newFileChooser.getSelectedFile());
			}
			*/
		}

		void createNewProject(File file) {
			try {
				String path = file.getCanonicalPath();
				String title = file.getName();
				
				Project newProject = new Project(title, path);
				parentController.setProject(newProject);
			} catch (IOException IOE) {
				IOE.printStackTrace();
				parentController
				.displayErrorMessage(
						"IOException",
						"An IO exception was raised during creation of the new project.\nPlease try again.");
			}
		}
	}

	public class SaveProjectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DialogHelper.displayNotImplementedDialog();
		}
	}

	public class LoadProjectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DialogHelper.displayNotImplementedDialog();
		}
	}
}
