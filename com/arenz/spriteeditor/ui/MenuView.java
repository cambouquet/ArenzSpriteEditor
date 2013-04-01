/**
 * 
 */
package com.arenz.spriteeditor.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Camille
 *
 */
public class MenuView {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuProject = new JMenu("Project");
	private JMenuItem menuNew = new JMenuItem("New");
	private JMenuItem menuSave = new JMenuItem("Save");
	private JMenuItem menuLoad = new JMenuItem("Load");
	private JMenuItem menuQuit = new JMenuItem("Quit");
	
	public MenuView() {
		menuProject.add(menuNew);
		menuProject.add(menuSave);
		menuProject.add(menuLoad);
		menuProject.add(menuQuit);
		
		menuBar.add(menuProject);
	}
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
}
