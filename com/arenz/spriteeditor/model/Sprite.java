package com.arenz.spriteeditor.model;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Sprite implements DisplayableElement {
	private Image image;
	private File file;
	
	public Sprite(File file) {
		this.file = file;
	}

	public Sprite(Image image, File folder, String name) {
		this.image = image;
		this.file = new File(folder, name);
	}
	
	@Override
	public Image getImage() {
		return this.image;
	}

	public File getFile() {
		return this.file;
	}

	@Override
	public String getNom() {
		return file.getName();
	}

	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(image);
	}
}