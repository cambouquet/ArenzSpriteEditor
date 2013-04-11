package com.arenz.spriteeditor.model;

import java.util.ArrayList;

public class SpriteCategory {
	private ArrayList<DisplayableElement> elements = new ArrayList<DisplayableElement>();
	private String nom;
	private int id;

	public SpriteCategory(String nom, int id, ArrayList<DisplayableElement> elements) {
		this.nom = nom;
		this.id = id;
		this.elements = elements;
	}

	public String getNom() {
		return this.nom;
	}

	public int getId() {
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
