/**
 * 
 */
package com.arenz.spriteeditor.ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.arenz.spriteeditor.ui.LayoutHelper;
import com.arenz.spriteeditor.ui.Viewable;

/**
 * @author Camille
 *
 */
public class NewProjectDialog extends JDialog implements Viewable {
	private JPanel buttonsPanel = new JPanel();
	private JPanel elementsPanel = new JPanel();
	
	private JTextField nameTextField;
	private JTextField rootFolderTextField;
	private JLabel nameLabel;
	private JLabel rootFolderLabel;
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
		nameTextField = new JTextField(20);
		rootFolderTextField = new JTextField(50);
		nameLabel = new JLabel("Name");
		rootFolderLabel = new JLabel("Root folder");
		browseButton = new JButton("Browse");
	}

	private void addElements() {
		elementsPanel.add(nameLabel, LayoutHelper.getGridBagConstraints(0, 0, 1, 1));
		elementsPanel.add(nameTextField, LayoutHelper.getGridBagConstraints(1, 0, 2, 1));
		elementsPanel.add(rootFolderLabel, LayoutHelper.getGridBagConstraints(0, 1, 1, 1));
		elementsPanel.add(rootFolderTextField, LayoutHelper.getGridBagConstraints(1, 1, 1, 1));
		elementsPanel.add(browseButton, LayoutHelper.getGridBagConstraints(2, 1, 1, 1));
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
	
	public void addBrowseButtonListener(ActionListener browseListener) {
		browseButton.addActionListener(browseListener);
	}

	public String getProjectName() {
		return this.nameTextField.getText();
	}

	public String getProjectRootFolder() {
		return this.rootFolderTextField.getText();
	}

	@Override
	public Component getViewWindow() {
		return this;
	}

	public void fillRootPath(String canonicalPath) {
		rootFolderTextField.setText(canonicalPath);
	}
}
