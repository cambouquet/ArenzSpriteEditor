package com.arenz.spriteeditor.ui.components;

import java.awt.Dimension;

public abstract class SizeHelper {
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
}
