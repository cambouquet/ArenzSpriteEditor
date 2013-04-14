package com.arenz.spriteeditor.model;

import java.util.ArrayList;
import java.util.Iterator;

public class SpriteCategory {
	private ArrayList<DisplayableElement> elements = new ArrayList<DisplayableElement>();
	private String name;
	private int id;

	public SpriteCategory(String nom, int id, ArrayList<DisplayableElement> elements) {
		this.name = nom;
		this.id = id;
		this.elements = elements;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public ArrayList<DisplayableElement> getElements() {
		return this.elements;
	}
	
	public Iterator<DisplayableElement> getElementsIterator() {
		return this.elements.iterator();
	}

	public DisplayableElement getElement(String nom) {
		DisplayableElement returnElement = null;
		
		for (DisplayableElement element : elements) {
			if (element.getName().equals(nom)) {
				returnElement = element;
			}
		}

		return returnElement;
	}

	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof SpriteCategory)) {
			return false;
		}

		final SpriteCategory cat = (SpriteCategory) other;

		if ( !(cat.getId() == this.id) ) {
			return false;
		}

		return true;
	}
}
