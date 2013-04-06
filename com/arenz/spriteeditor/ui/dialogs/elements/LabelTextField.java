package com.arenz.spriteeditor.ui.dialogs.elements;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Camille
 *
 */
public class LabelTextField extends JPanel {
	private JLabel label;
	private JTextField textField;
	
	public LabelTextField(String label, int columns) {
		super();
		this.label = new JLabel(label);
		this.textField = new JTextField(columns);
		
		this.add(this.label);
		this.add(this.textField);
	}
}
