package com.arenz.spriteeditor.controller;

import com.arenz.spriteeditor.model.Sprite;
import com.arenz.spriteeditor.ui.dialogs.DialogHelper;

public class SpriteSaver {
	private Sprite sprite;
	
	public SpriteSaver(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void save() {
		DialogHelper.displayNotImplementedDialog();
	}
}
