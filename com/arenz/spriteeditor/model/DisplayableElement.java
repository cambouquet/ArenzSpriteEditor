package com.arenz.spriteeditor.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public interface DisplayableElement {

	public String getName();

	public Image getImage();
	
	public ImageIcon getIcon();
}
