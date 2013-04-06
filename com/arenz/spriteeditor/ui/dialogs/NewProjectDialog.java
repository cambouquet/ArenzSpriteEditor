/**
 * 
 */
package com.arenz.spriteeditor.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Camille
 *
 */
public class NewProjectDialog extends JDialog {
	private boolean isValidated = false;
	
	private JPanel buttonsPanel = new JPanel();
	private JPanel elementsPanel = new JPanel();
	
	private JTextField nameTextField = new JTextField(20);
	private JTextField pathTextField = new JTextField(50);
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

	private void initElements() {
		browseButton = new JButton("Browse");
	}

	private void initPanels() {
		elementsPanel.setLayout(new GridBagLayout());
		buttonsPanel.setLayout(new GridBagLayout());
		
		this.add(elementsPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}

	private void addElements() {
		elementsPanel.add(nameTextField);
		elementsPanel.add(pathTextField);
		elementsPanel.add(browseButton);
	}

	private void addButtons() {
		buttonsPanel.add(okButton);
		buttonsPanel.add(cancelButton);
	}

	private void initButtons() {
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
	}

	public boolean setVisible() {
		this.pack();
		this.setVisible(true);
		return isValidated;
	}
}
