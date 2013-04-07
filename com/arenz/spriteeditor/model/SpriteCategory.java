package com.arenz.spriteeditor.model;

import java.util.ArrayList;

public class SpriteCategory {
	private ArrayList<DisplayableElement> elements = new ArrayList<DisplayableElement>();
	private String nom;
	private String id = "0";

	public SpriteCategory(String nom, String id, ArrayList<DisplayableElement> elements) {
		this.nom = nom;
		this.id = id;
		this.elements = elements;
	}

	public SpriteCategory(String nom, ArrayList<DisplayableElement> elements) {
		this(nom, "0", elements);
	}

	public String getNom() {
		return this.nom;
	}

	public String getId() {
		return this.id;
	}

	public ArrayList<DisplayableElement> getElements() {
		return this.elements;
	}

	public DisplayableElement getElement(String nom) {
		DisplayableElement returnElement = null;
		
		for (DisplayableElement element : elements) {
			if (element.getNom().equals(nom)) {
				returnElement = element;
			}
		}

		return returnElement;
	}

}
