/**
 * 
 */
package com.arenz.spriteeditor.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.arenz.spriteeditor.ui.LayoutHelper;
import com.arenz.spriteeditor.ui.dialogs.elements.LabelTextField;

/**
 * @author Camille
 *
 */
public class NewProjectDialog extends JDialog {
	private boolean isValidated = false;
	
	private JPanel buttonsPanel = new JPanel();
	private JPanel elementsPanel = new JPanel();
	
	private LabelTextField nameTextField;
	private LabelTextField pathTextField;
	private JButton browseButton;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public NewProjectDialog() {
		super();
		setTitle("Create a new project");
		
		this.buildDialog();
	}
	
	private void buildDialog() {
		initPanels();
		initElements();
		addElements();
		initButtons();
		addButtons();
	}

	private void initPanels() {
		elementsPanel.setLayout(new GridBagLayout());
		buttonsPanel.setLayout(new GridBagLayout());
		
		this.add(elementsPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}

	private void initElements() {
		nameTextField = new LabelTextField("Name", 20);
		pathTextField = new LabelTextField("Path", 50);
		browseButton = new JButton("Browse");
	}

	private void addElements() {
		elementsPanel.add(nameTextField, LayoutHelper.getGridBagConstraints(0, 0, 2, 1));
		elementsPanel.add(pathTextField, LayoutHelper.getGridBagConstraints(0, 1, 1, 1));
		elementsPanel.add(browseButton, LayoutHelper.getGridBagConstraints(1, 1, 1, 1));
	}

	private void addButtons() {
		buttonsPanel.add(okButton);
		buttonsPanel.add(cancelButton);
	}

	private void initButtons() {
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
	}
	
	public void addOkButtonListener(ActionListener okListener) {
		okButton.addActionListener(okListener);
	}

	public void addCancelButtonListener(ActionListener cancelListener) {
		cancelButton.addActionListener(cancelListener);
	}
}
