/**
 * 
 */
package com.arenz.spriteeditor.ui.dialogs;

import java.awt.Component;
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

	public static void displayErrorMessage(Component parent, String title, String message) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static JFileChooser createHomeFileChooser() {
		FileSystemView systemView = FileSystemView.getFileSystemView();
		File homeFile = systemView.getHomeDirectory();
		
		return new JFileChooser(homeFile);
	}
}
