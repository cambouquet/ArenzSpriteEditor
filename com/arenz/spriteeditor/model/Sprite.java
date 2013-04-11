package com.arenz.spriteeditor.model;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Sprite implements DisplayableElement {
	private Image image;
	private String name;
	
	public Sprite(Image image, String name) {
		this.image = image;
		this.name = name;
	}
	
	@Override
	public Image getImage() {
		return this.image;
	}

	@Override
	public String getNom() {
		return this.name;
	}

	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(image);
	}
}