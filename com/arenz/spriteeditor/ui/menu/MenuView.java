/**
 * 
 */
package com.arenz.spriteeditor.ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
		createsMenuItems();
		createsMenu();
	}
	
	private void createsMenu() {
		menuProject.add(menuNew);
		menuProject.add(menuSave);
		menuProject.add(menuLoad);
		menuProject.add(menuQuit);
		
		menuBar.add(menuProject);
	}

	private void createsMenuItems() {
		ActionListener quitActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		};
		MenuHelper.configureMenuElement(menuProject, KeyEvent.VK_P, null);
		
		MenuHelper.configureMenuElement(menuNew, KeyEvent.VK_N, null);
		MenuHelper.configureMenuElement(menuSave, KeyEvent.VK_S, null);
		MenuHelper.configureMenuElement(menuLoad, KeyEvent.VK_L, null);
		MenuHelper.configureMenuElement(menuQuit, KeyEvent.VK_Q, quitActionListener);
		
		MenuHelper.setAccelerator(menuNew, KeyEvent.VK_N,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuSave, KeyEvent.VK_S,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuLoad, KeyEvent.VK_L,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuQuit, KeyEvent.VK_Q,  KeyEvent.CTRL_MASK);
	}

	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
}
