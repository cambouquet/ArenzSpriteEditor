package com.arenz.spriteeditor.ui.components;

import javax.swing.JButton;

public class SelectableButton extends JButton {
	private boolean isSelected = false;
	
	public SelectableButton() {
		super();
	}
	
	public SelectableButton(String name) {
		super(name);
	}
	
	public void selectButton(boolean selected) {
		setEnabled(!selected);
		isSelected = selected;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
}
