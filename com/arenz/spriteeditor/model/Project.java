/**
 * 
 */
package com.arenz.spriteeditor.model;

import java.io.File;
import java.util.Properties;

/**
 * @author Camille
 *
 */
public class Project {
	private String title;
	private File rootFolder;
	
	public Project(String title, File rootFolder) {
		this.title = title;
		this.rootFolder = rootFolder;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public File getRootFolder() {
		return this.rootFolder;
	}
}
