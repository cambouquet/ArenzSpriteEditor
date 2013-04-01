/**
 * 
 */
package com.arenz.spriteeditor.action.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.ui.dialogs.DialogHelper;

/**
 * @author Camille
 *
 */
public class NewProjectListener implements ActionListener
{
	private JFileChooser newFileChooser;
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		newFileChooser = DialogHelper.createDefaultFileChooser();
		if (newFileChooser.showDialog(null, "Create") == JFileChooser.APPROVE_OPTION) {
			createNewProject();
		}
		
	}

	private void createNewProject() {
		File file = newFileChooser.getSelectedFile();
		try {
			String path = file.getCanonicalPath();
			String title = file.getName();
			Project newProject = new Project(title, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
