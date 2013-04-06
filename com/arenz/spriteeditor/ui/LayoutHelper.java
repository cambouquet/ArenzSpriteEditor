/**
 * 
 */
package com.arenz.spriteeditor.ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * @author Camille
 *
 */
public abstract class LayoutHelper {
	public static GridBagConstraints getGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight) {
		return new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 0.0, 0.0,
		        GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0);
	}
}
