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

import com.arenz.spriteeditor.controller.menu.NewProjectListener;
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
		
		MenuHelper.configureMenuElement(menuNew, KeyEvent.VK_N, new NewProjectListener());
		MenuHelper.configureMenuElement(menuSave, KeyEvent.VK_S, new SaveProjectListener());
		MenuHelper.configureMenuElement(menuLoad, KeyEvent.VK_L, new LoadProjectListener());
		MenuHelper.configureMenuElement(menuQuit, KeyEvent.VK_Q, quitActionListener);
		
		MenuHelper.setAccelerator(menuNew, KeyEvent.VK_N,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuSave, KeyEvent.VK_S,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuLoad, KeyEvent.VK_L,  KeyEvent.CTRL_MASK);
		MenuHelper.setAccelerator(menuQuit, KeyEvent.VK_Q,  KeyEvent.CTRL_MASK);
	}

	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
	
	public class SaveProjectListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			DialogHelper.displayNotImplementedDialog();
		}
	}

	public class LoadProjectListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			DialogHelper.displayNotImplementedDialog();
		}
	}
}
