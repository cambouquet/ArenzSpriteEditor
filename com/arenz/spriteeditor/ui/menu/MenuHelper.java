package com.arenz.spriteeditor.ui.menu;

import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author Camille
 * 
 */
public abstract class MenuHelper {

	public static void setAccelerator(JMenuItem menuItem, int keyCode, int keyModifier) {
		menuItem.setAccelerator(KeyStroke.getKeyStroke(keyCode, keyModifier));
	}
}
