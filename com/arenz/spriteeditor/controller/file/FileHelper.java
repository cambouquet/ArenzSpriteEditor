/**
 * 
 */
package com.arenz.spriteeditor.controller.file;

import java.io.File;
import java.io.IOException;

import com.arenz.spriteeditor.controller.AbstractController;

/**
 * @author Camille
 *
 */
public class FileHelper {
	public static String getCannonicalPath(File file, AbstractController controller) {
		String filePath = null;
		try {
			filePath = file.getCanonicalPath();
		} catch (IOException e) {
			controller.displayErrorMessage("IOException", "An IO exception occured when trying to get the file cannonical path.");
			e.printStackTrace();
		}
		
		return filePath;
	}
	
	public static File createNewFolder(File rootFolder, String folderName) {
		File newFolder = new File(rootFolder, folderName);
		newFolder.mkdir();
		
		return newFolder;
	}
}
