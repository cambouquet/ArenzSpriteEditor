/**
 * 
 */
package com.arenz.spriteeditor.ui.dialogs;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Camille
 *
 */
public abstract class DialogHelper {
	public static void displayNotImplementedDialog() {
		JOptionPane.showMessageDialog(null, "This feature has not been implemented yet", "Not implemented yet", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static JFileChooser createDefaultFileChooser() {
		FileSystemView systemView = FileSystemView.getFileSystemView();
		File homeFile = systemView.getHomeDirectory();
		
		return new JFileChooser(homeFile);
	}
}
