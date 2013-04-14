package com.arenz.spriteeditor.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import com.arenz.spriteeditor.controller.SpriteSelectionController.SpriteSelectionListener;
import com.arenz.spriteeditor.model.DisplayableElement;
import com.arenz.spriteeditor.model.SpriteCategories;
import com.arenz.spriteeditor.model.SpriteCategory;
import com.arenz.spriteeditor.ui.components.ButtonSelectionPanel;
import com.arenz.spriteeditor.ui.components.CategoryButton;
import com.arenz.spriteeditor.ui.components.SpriteButton;

public class SpriteSelectionView {
	private JPanel spriteSelectionPanel = new JPanel();
	private JScrollPane categoriesScrollPane;
	private JScrollPane spritesScrollPane;
	private ButtonSelectionPanel categoriesPanel = new ButtonSelectionPanel();
	private ButtonSelectionPanel spritesPanel = new ButtonSelectionPanel();
	private CategoryButton selectedCategory;
	private SpriteButton selectedSprite;

	private SpriteCategories categories;

	public SpriteSelectionView(SpriteCategories categories) {
		this.categories = categories;
		spriteSelectionPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		spriteSelectionPanel.setLayout(new BorderLayout());

		categoriesScrollPane = createScrollPane("Categories", categoriesPanel);
		spritesScrollPane = createScrollPane("Sprites", spritesPanel);

		verifyCategoryNumber();
		spriteSelectionPanel.add(spritesScrollPane, BorderLayout.CENTER);
	}

	private JScrollPane createScrollPane(String titre, JPanel contenu) {
		JScrollPane jsp = new JScrollPane(contenu);
		jsp.setBorder(new TitledBorder(BorderFactory.createLoweredBevelBorder(), titre));

		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		return jsp;
	}

	private void verifyCategoryNumber() {
		int nbrCategories = categories.getCategoriesCount();
		if (nbrCategories > 1) {
			spriteSelectionPanel.add(categoriesScrollPane, BorderLayout.NORTH);
		}
	}

	/*
	 * public void selectionnerCategorie(SpriteCategory categorie) {
	 * spritesPanel.removeAll();
	 * 
	 * Component[] composantspCategories = categoriesPanel.getComponents(); for
	 * (Component composant : composantspCategories) { if (composant instanceof
	 * JButton) { JButton bouton = ((JButton) composant); if
	 * (bouton.getText().equalsIgnoreCase(categorie.getNom()) &&
	 * bouton.isEnabled()) { ((JButton) composant).doClick(); } } }
	 * 
	 * ArrayList<DisplayableElement> elements = categorie.getElements(); for
	 * (DisplayableElement element : elements) { JButton bElement = new
	 * JButton(element.getIcon()); bElement.setName(element.getNom());
	 * bElement.addActionListener(new ActionListener(){
	 * 
	 * @Override public void actionPerformed(ActionEvent arg0) { JButton
	 * boutonClique = ((JButton)arg0.getSource()); if (selectedSprite != null) {
	 * selectedSprite.setEnabled(true); }
	 * 
	 * selectedSprite = boutonClique; boutonClique.setEnabled(false);
	 * ctrlPS.selectionnerElement(boutonClique.getName()); }
	 * 
	 * }); spritesPanel.add(bElement); }
	 * 
	 * spritesPanel.revalidate(); spritesPanel.repaint();
	 * spritesScrollPane.revalidate(); spritesScrollPane.repaint();
	 * spriteSelectionPanel.revalidate(); spriteSelectionPanel.repaint(); }
	 * 
	 * public void deselectionnerCategories() {
	 * this.selectedCategory.setEnabled(true); this.selectedCategory = null;
	 * this.selectionnerCategorie(null); }
	 */

	public Component getMainComponent() {
		return spriteSelectionPanel;
	}

	public void addCategory(SpriteCategory category, ActionListener categoryListener) {
		CategoryButton catButton = new CategoryButton(category);
		catButton.addActionListener(categoryListener);
		categoriesPanel.addButton(catButton);

		verifyCategoryNumber();
		spriteSelectionPanel.revalidate();
	}

	public void selectCategory(CategoryButton categoryButton, ActionListener spriteListener) {
		this.selectedCategory = categoryButton;
		categoriesPanel.selectButton(selectedCategory);
		
		SpriteCategory category = categoryButton.getCategory();
		displayImages(category, spriteListener);
		System.out.println("Category " + category.getName() + " selected");
	}

	private void displayImages(SpriteCategory category, ActionListener spriteListener) {
		spritesPanel.removeAllButtons();
		Iterator<DisplayableElement> ite = category.getElementsIterator();
		while (ite.hasNext()) {
			DisplayableElement sprite = ite.next();
			SpriteButton spriteButton = new SpriteButton(sprite);
			spriteButton.addActionListener(spriteListener);
			spritesPanel.addButton(spriteButton);
		}

		spritesPanel.revalidate();
		spritesPanel.repaint();
	}

	public void selectSprite(SpriteButton spriteButton) {
		this.selectedSprite = spriteButton;
		spritesPanel.selectButton(selectedSprite);
		System.out.println("Sprite " + spriteButton.getElement().getName() + " selected");
	}
}
