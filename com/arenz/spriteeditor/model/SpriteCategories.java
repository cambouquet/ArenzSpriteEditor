package com.arenz.spriteeditor.model;

import java.util.ArrayList;

public class SpriteCategories {
	private ArrayList<SpriteCategory> categories;
	
	public SpriteCategories() {
		categories = new ArrayList<SpriteCategory>();
	}

	public int getCategoriesCount() {
		return categories.size();
	}

	public void add(SpriteCategory spriteCategory) {
		categories.add(spriteCategory);
	}
}
