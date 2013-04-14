/**
 * 
 */
package com.arenz.spriteeditor.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.arenz.spriteeditor.controller.AbstractController;
import com.arenz.spriteeditor.controller.MainController;
import com.arenz.spriteeditor.controller.file.FileHelper;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.ui.Viewable;
import com.arenz.spriteeditor.ui.dialogs.DialogHelper;
import com.arenz.spriteeditor.ui.dialogs.NewProjectDialog;
import com.arenz.spriteeditor.ui.menu.MenuView;

/**
 * @author Camille
 * 
 */
public class MenuController extends AbstractController {
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
		menuView.addOpenProjectListener(new OpenProjectListener());
		
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
		}
	}

	public class SaveProjectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DialogHelper.displayNotImplementedDialog();
		}
	}

	public class OpenProjectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser rootChooser = DialogHelper.createHomeFileChooser();
			rootChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			if (rootChooser.showDialog(getWindow().getViewWindow(), "Select") == JFileChooser.APPROVE_OPTION) {
				File rootFolder = rootChooser.getSelectedFile();
				openProject(rootFolder);
		       }
		}

		private void openProject(File rootFolder) {
			Project newProject = new Project(rootFolder);
			setNewProject(newProject);
		}
	}

	public void setNewProject(Project project) {
		parentController.setNewProject(project);
	}

	@Override
	public AbstractController getParentController() {
		return parentController;
	}

	@Override
	public Viewable getWindow() {
		return parentController.getWindow();
	}
}
