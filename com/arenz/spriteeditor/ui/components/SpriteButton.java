package com.arenz.spriteeditor.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import javax.swing.plaf.metal.MetalToolTipUI;

import com.arenz.spriteeditor.model.DisplayableElement;

public class SpriteButton extends SelectableButton {
	private DisplayableElement displayableElement;
	private static final int HEIGHT_BUTTON = 32;
	private static final int WIDTH_BUTTON = 32;

	public SpriteButton(DisplayableElement dispEl) {
		// super(dispEl.getIcon());
		super();
		displayableElement = dispEl;
		setMinimumSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
		setPreferredSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
		setOpaque(false);
		setToolTipText(displayableElement.getName());

		revalidate();
		repaint();
	}
	
	public DisplayableElement getElement() {
		return this.displayableElement;
	}

	@Override
	public void paintComponent(Graphics g) {
		if (displayableElement.getImage() != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.drawImage(displayableElement.getImage(), 0, 0, getWidth(), getHeight(), null);
		}
		
		if (isSelected()) {
			g.setColor(Color.RED);
			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		}
	}

	@Override
	public JToolTip createToolTip() {
		return new ImageToolTip();
	}

	class ImageToolTip extends JToolTip {
		public ImageToolTip() {
			setUI(new ImageToolTipUI());
		}
	}

	// TODO: see UI
	class ImageToolTipUI extends MetalToolTipUI {
		private static final int V_MARGING = 5;
		private static final int H_MARGING = 5;

		public void paint(Graphics g, JComponent c) {
			FontMetrics metrics = c.getFontMetrics(g.getFont());
			g.setColor(c.getForeground());
			g.drawString(((JToolTip) c).getTipText(), 1, metrics.getHeight());
			g.drawImage(displayableElement.getImage(), 1, metrics.getHeight() + V_MARGING, c);
		}

		public Dimension getPreferredSize(JComponent c) {
			FontMetrics metrics = c.getFontMetrics(c.getFont());
			String tipText = ((JToolTip) c).getTipText();
			if (tipText == null) {
				tipText = "";
			}

			Image image = displayableElement.getImage();
			int width = SwingUtilities.computeStringWidth(metrics, tipText) + H_MARGING;
			int height = metrics.getHeight() + image.getHeight(c) + V_MARGING;

			if (width < image.getWidth(c)) {
				width = image.getWidth(c);
			}
			return new Dimension(width, height);
		}
	}
}
