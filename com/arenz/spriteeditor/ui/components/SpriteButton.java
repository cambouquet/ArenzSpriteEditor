package com.arenz.spriteeditor.ui.components;

import javax.swing.JButton;

import com.arenz.spriteeditor.model.DisplayableElement;

public class SpriteButton extends JButton {
	private DisplayableElement displayableElement;
	
	public SpriteButton(DisplayableElement dispEl) {
		super(dispEl.getIcon());
		displayableElement = dispEl;
	}
}
