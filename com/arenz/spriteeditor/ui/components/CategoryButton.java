package com.arenz.spriteeditor.ui.components;

import java.util.Locale.Category;

import javax.swing.JButton;

import com.arenz.spriteeditor.model.SpriteCategory;

public class CategoryButton extends JButton {
	private SpriteCategory category;
	
	public CategoryButton(SpriteCategory category) {
		super(category.getName());
		this.category = category;
	}
	
	public SpriteCategory getCategory() {
		return this.category;
	}
	
	public boolean isSameCategory(SpriteCategory otherCategory) {
		if (category.equals(otherCategory)) {
			return true;
		}
		
		return false;
	}
}
