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
	public static String getCannonicalPathWithoutException(File file, AbstractController controller) {
		String filePath = null;
		try {
			filePath = file.getCanonicalPath();
		} catch (IOException e) {
			controller.displayErrorMessage("IOException", "An IO exception occured when trying to get the file cannonical path.");
			e.printStackTrace();
		}
		
		return filePath;
	}
}
