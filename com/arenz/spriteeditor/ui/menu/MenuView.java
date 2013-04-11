/**
 * 
 */
package com.arenz.spriteeditor.ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.arenz.spriteeditor.controller.menu.MenuController;
import com.arenz.spriteeditor.model.Project;
import com.arenz.spriteeditor.ui.dialogs.DialogHelper;

/**
 * @author Camille
 *
 */
public class MenuView {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuProject = new JMenu("Project");
	private JMenuItem menuNew = new JMenuItem("New");
	private JMenuItem menuSave = new JMenuItem("Save");
	private JMenuItem menuOpen = new JMenuItem("Open");
	private JMenuItem menuQuit = new JMenuItem("Quit");
	
	public MenuView() {
		createsMenuItems();
		createsMenu();
	}
	
	private void createsMenu() {
		menuProject.add(menuNew);
		menuProject.add(menuSave);
		menuProject.add(menuOpen);
		menuProject.add(menuQuit);
		
		menuBar.add(menuProject);
	}

	private void createsMenuItems() {
		menuProject.setMnemonic(KeyEvent.VK_P);
		
		menuNew.setMnemonic(KeyEvent.VK_N);
		menuSave.setMnemonic(KeyEvent.VK_S);
		menuOpen.setMnemonic(KeyEvent.VK_O);
		menuQuit.setMnemonic(KeyEvent.VK_Q);
		
		MenuHelper.setAccelerator(menuNew, KeyEvent.VK_N,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuSave, KeyEvent.VK_S,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuOpen, KeyEvent.VK_O,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuQuit, KeyEvent.VK_Q,  KeyEvent.CTRL_MASK);
	}

	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
	
	public void addNewProjectListener(ActionListener newProjectListener) {
		menuNew.addActionListener(newProjectListener);
	}
	
	public void addSaveProjectListener(ActionListener saveProjectListener) {
		menuSave.addActionListener(saveProjectListener);
	}
	
	public void addOpenProjectListener(ActionListener loadProjectListener) {
		menuOpen.addActionListener(loadProjectListener);
	}
	
	public void addQuitProjectListener(ActionListener quitProjectListener) {
		menuQuit.addActionListener(quitProjectListener);
	}
}
