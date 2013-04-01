/**
 * 
 */
package com.arenz.spriteeditor.model;

/**
 * @author Camille
 *
 */
public class Project {
	private String title;
	private String path;
	
	public Project(String title, String path) {
		this.title = title;
		this.path = path;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getPath() {
		return this.path;
	}
}
