package com.arenz.spriteeditor.model;

import java.util.ArrayList;
import java.util.Iterator;

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

	public Iterator<SpriteCategory> getCategoriesAsArray() {
		// TODO Auto-generated method stub
		return categories.iterator();
	}
}
