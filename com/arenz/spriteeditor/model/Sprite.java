package com.arenz.spriteeditor.model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
	public String getName() {
		return this.name;
	}

	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(image);
	}

	private int computeScaleFactor() {
		int maxWidthHeight = Math.max(image.getWidth(null), image.getHeight(null));
		
		return 32 / maxWidthHeight;
	}
}