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
	private File rootFolder;
	
	public Project(File rootFolder) {
		this.rootFolder = rootFolder;
	}
	
	public String getTitle() {
		return rootFolder.getName();
	}
	
	public File getRootFolder() {
		return this.rootFolder;
	}
}
