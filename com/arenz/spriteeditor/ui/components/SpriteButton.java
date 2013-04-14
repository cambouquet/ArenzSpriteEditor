package com.arenz.spriteeditor.ui.components;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import javax.swing.plaf.metal.MetalToolTipUI;

import com.arenz.spriteeditor.model.DisplayableElement;

public class SpriteButton extends SelectableButton {
	private DisplayableElement displayableElement;
	
	public SpriteButton(DisplayableElement dispEl) {
		// super(dispEl.getIcon());
		super();
		displayableElement = dispEl;
		setMinimumSize(SizeHelper.getSpriteButtonSize());
		setPreferredSize(SizeHelper.getSpriteButtonSize());
		setOpaque(false);
		setToolTipText(displayableElement.getName());
		setBorder(BorderFactory.createRaisedBevelBorder());
		revalidate();
		repaint();
	}
	
	@Override
	public void selectButton(boolean selected) {
		super.selectButton(selected);
		if (selected) {
			setBorder(BorderFactory.createLoweredBevelBorder());
		} else {
			setBorder(BorderFactory.createRaisedBevelBorder());
		}
	}
	
	public DisplayableElement getElement() {
		return this.displayableElement;
	}

	@Override
	public void paintComponent(Graphics g) {
		int vMargin = SizeHelper.getSpriteButtonMargin().height;
		int hMargin = SizeHelper.getSpriteButtonMargin().width;

		if (displayableElement.getImage() != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.drawImage(displayableElement.getImage(),hMargin, vMargin, getWidth() - hMargin, getHeight() - vMargin, null);
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

	// TODO: see UI type
	class ImageToolTipUI extends MetalToolTipUI {
		private static final int V_MARGING_TOOLTIP = 5;
		private static final int H_MARGING_TOOLTIP = 5;

		public void paint(Graphics g, JComponent c) {
			FontMetrics metrics = c.getFontMetrics(g.getFont());
			g.setColor(c.getForeground());
			g.drawString(((JToolTip) c).getTipText(), 1, metrics.getHeight());
			g.drawImage(displayableElement.getImage(), 1, metrics.getHeight() + V_MARGING_TOOLTIP, c);
		}

		public Dimension getPreferredSize(JComponent c) {
			FontMetrics metrics = c.getFontMetrics(c.getFont());
			String tipText = ((JToolTip) c).getTipText();
			if (tipText == null) {
				tipText = "";
			}

			Image image = displayableElement.getImage();
			int width = SwingUtilities.computeStringWidth(metrics, tipText) + H_MARGING_TOOLTIP;
			int height = metrics.getHeight() + image.getHeight(c) + V_MARGING_TOOLTIP;

			if (width < image.getWidth(c)) {
				width = image.getWidth(c);
			}
			return new Dimension(width, height);
		}
	}
}
