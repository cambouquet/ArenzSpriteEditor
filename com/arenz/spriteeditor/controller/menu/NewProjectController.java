/**
 * 
 */
package com.arenz.spriteeditor.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.arenz.spriteeditor.controller.AbstractController;
import com.arenz.spriteeditor.controller.file.FileHelper;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.ui.Viewable;
import com.arenz.spriteeditor.ui.dialogs.DialogHelper;
import com.arenz.spriteeditor.ui.dialogs.NewProjectDialog;

/**
 * @author Camille
 *
 */
public class NewProjectController extends AbstractController {
	private NewProjectDialog view;
	private MenuController parentController;
	
	public NewProjectController(MenuController parentController, NewProjectDialog newProjectView) {
		this.parentController = parentController;
		this.view = newProjectView;
		
		addListeners();
	}

	private void addListeners() {
		view.addOkButtonListener(new OkButtonListener());
		view.addCancelButtonListener(new CancelButtonListener());
		view.addBrowseButtonListener(new BrowseButtonListener());
	}

	public void displayErrorMessage(String title, String text) {
		DialogHelper.displayErrorMessage(view, title, text);
	}
	
	private class OkButtonListener implements ActionListener {
		private File rootFolder;
		private String projectName;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			projectName = view.getProjectName();
			String projectRootFolder= view.getProjectRootFolder();
			
			boolean areValid = areDataValid(projectRootFolder);
			
			if (areValid) {
				Project project = createNewProject();
				parentController.setNewProject(project);
				closeView();
			} else {
				displayErrorMessage(
						"Invalid data",
						"Please enter valid data.");
			}
		}
		
		private boolean areDataValid(String projectRootFolder) {
			boolean areValid = true;
			
			if (projectName.isEmpty() || projectRootFolder.isEmpty()) {
				areValid = false;
			}
			
			rootFolder = new File(projectRootFolder);
			if (!rootFolder.exists() || !rootFolder.isDirectory()) {
				areValid = false;
			}
			
			return areValid;
		}

		private Project createNewProject() {
			File projectFolder = FileHelper.createNewFolder(rootFolder, projectName);
			Project newProject = new Project(projectFolder);
			createSpriteFolders(projectFolder);
			
			return newProject;
		}

		private void createSpriteFolders(File projectFolder) {
			createSpriteFolder(projectFolder, "New");
			createSpriteFolder(projectFolder, "Ground");
			createSpriteFolder(projectFolder, "Wall");
			createSpriteFolder(projectFolder, "Door");
			createSpriteFolder(projectFolder, "Character");
			createSpriteFolder(projectFolder, "Furniture");
		}

		private void createSpriteFolder(File projectFolder, String folderName) {
			FileHelper.createNewFolder(projectFolder, folderName);
		}
	}
	
	private class CancelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			closeView();
		}
	}

	private class BrowseButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser rootChooser = DialogHelper.createHomeFileChooser();
			rootChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			if (rootChooser.showDialog(getWindow().getViewWindow(), "Select") == JFileChooser.APPROVE_OPTION) {
				File rootFolder = rootChooser.getSelectedFile();
				String rootFolerPath = FileHelper.getCannonicalPath(rootFolder, NewProjectController.this);
				view.fillRootPath(rootFolerPath);
		       }
		}
	}
	
	private void closeView() {
		view.setVisible(false);
	}
	
	public void displayView() {
		view.pack();
		view.setVisible(true);
	}

	@Override
	public AbstractController getParentController() {
		return parentController;
	}

	@Override
	public Viewable getWindow() {
		return view;
	}
}
