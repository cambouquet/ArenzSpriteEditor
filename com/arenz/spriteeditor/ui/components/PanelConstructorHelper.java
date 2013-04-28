package com.arenz.spriteeditor.ui.components;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import com.arenz.spriteeditor.ui.Constants;

public abstract class PanelConstructorHelper {
	private static final int HEIGHT_BUTTON = 35;
	private static final int WIDTH_BUTTON = 35;
	
	private static final int V_MARGIN_BUTTON = 3;
	private static final int H_MARGIN_BUTTON = 3;

	public static Dimension getSpriteButtonSize() {
		return new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON);
	}

	public static Dimension getSpriteButtonMargin() {
		return new Dimension(H_MARGIN_BUTTON, V_MARGIN_BUTTON);
	}	
	
	public static JScrollPane createScrollPane(String titre, JPanel contenu) {
		return createScrollPane(titre, contenu, Constants.SPRITE_PANEL_HEIGHT, Constants.WINDOW_WIDTH);
	}

	public static JScrollPane createScrollPane(String titre, JPanel contenu, int height, int width) {
		JScrollPane jsp = new JScrollPane(contenu);
		jsp.setBorder(new TitledBorder(BorderFactory.createLoweredBevelBorder(), titre));
		
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setMinimumSize(new Dimension(width, height));
		jsp.setPreferredSize(new Dimension(width, height));
		return jsp;
	}
}
