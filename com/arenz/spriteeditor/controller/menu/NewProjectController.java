/**
 * 
 */
package com.arenz.spriteeditor.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.arenz.spriteeditor.ui.dialogs.DialogHelper;
import com.arenz.spriteeditor.ui.dialogs.NewProjectDialog;

/**
 * @author Camille
 *
 */
public class NewProjectController {
	private NewProjectDialog view;
	private MenuController parentcontroller;
	
	public NewProjectController(MenuController parentController, NewProjectDialog newProjectView) {
		this.parentcontroller = parentController;
		this.view = newProjectView;
		
		addListeners();
	}

	private void addListeners() {
		view.addOkButtonListener(new OkButtonListener());
		view.addCancelButtonListener(new CancelButtonListener());
	}

	private class OkButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DialogHelper.displayNotImplementedDialog();
		}
	}
	
	private class CancelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.setVisible(false);
		}
	}
	
	public void displayView() {
		view.pack();
		view.setVisible(true);
	}
}
