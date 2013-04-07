package com.arenz.spriteeditor.model;

import java.awt.Image;
import java.io.File;

public class Sprite {
	private Image image;
	private File file;
	
	public Sprite(File file) {
		this.file = file;
	}

	public Sprite(Image image, File folder, String name) {
		this.image = image;
		this.file = new File(folder, name);
	}
	
	public Image getImage() {
		return this.image;
	}

	public File getFile() {
		return this.file;
	}
}