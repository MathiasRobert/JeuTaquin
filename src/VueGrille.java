import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class VueGrille extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 399659093994244734L;
	Grille grille;
	Controleur controleur;
	private JButton ajoutLigne;
	private JButton suppLigne;
	private JButton ajoutColonne;
	private JButton suppColonne;

	public VueGrille(Grille grille) {
		this.grille = grille;
		initBoutons();
	}

	/**
	 * @return the ajoutLigne
	 */
	public JButton getAjoutLigne() {
		return ajoutLigne;
	}

	/**
	 * @return the suppLigne
	 */
	public JButton getSuppLigne() {
		return suppLigne;
	}

	/**
	 * @return the ajoutColonne
	 */
	public JButton getAjoutColonne() {
		return ajoutColonne;
	}

	/**
	 * @return the suppColonne
	 */
	public JButton getSuppColonne() {
		return suppColonne;
	}

	private void initBoutons() {
		this.setLayout(null);
		
		ajoutLigne = new JButton("Ajout Ligne");
		ajoutLigne.setBounds(25, Constantes.NBRE_DE_LIGNES
				* Constantes.CASE_EN_PIXELS + 20, 150, 50);
		add(ajoutLigne);
		
		suppLigne = new JButton("Supprimer Ligne");
		suppLigne.setBounds(225, Constantes.NBRE_DE_LIGNES
				* Constantes.CASE_EN_PIXELS + 20, 150, 50);
		add(suppLigne);
		
		ajoutColonne = new JButton("Ajout Colonne");
		ajoutColonne.setBounds(Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20, 25, 150, 50);
		add(ajoutColonne);
		
		suppColonne = new JButton("Supprimer Colonne");
		suppColonne.setBounds(Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20,
				Constantes.CASE_EN_PIXELS + 25, 150, 50);
		add(suppColonne);
	}
	
	public void reinitialiserBoutons() {
		ajoutLigne.setBounds(50, Constantes.NBRE_DE_LIGNES
				* Constantes.CASE_EN_PIXELS + 20, 125, 50);
		suppLigne.setBounds(225, Constantes.NBRE_DE_LIGNES
				* Constantes.CASE_EN_PIXELS + 20, 125, 50);
		ajoutColonne.setBounds(Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20, 25, 150, 50);
		suppColonne.setBounds(Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20,
				Constantes.CASE_EN_PIXELS + 25, 150, 50);
	}
	
	public void initControleurBouton(Controleur controleur) {
		this.controleur = controleur;
		controleur.newControleurClickBouton(ajoutLigne);
		controleur.newControleurClickBouton(suppLigne);
		controleur.newControleurClickBouton(ajoutColonne);
		controleur.newControleurClickBouton(suppColonne);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Jeton box : grille.getListeGrille()) {
			g.setColor(box.getColor());
			g.fillRect(box.getX() + 1, box.getY() + 1, box.getLargeur() - 2,
					box.getHauteur() - 2);
			g.setColor(Color.black);
			g.drawLine(box.getX(), box.getY(), box.getX()
					+ Constantes.CASE_EN_PIXELS, box.getY());
			g.drawLine(box.getX(), box.getY(), box.getX(), box.getY()
					+ Constantes.CASE_EN_PIXELS);
			g.drawLine(box.getX() + Constantes.CASE_EN_PIXELS, box.getY()
					+ Constantes.CASE_EN_PIXELS, box.getX()
					+ Constantes.CASE_EN_PIXELS, box.getY());
			g.drawLine(box.getX() + Constantes.CASE_EN_PIXELS, box.getY()
					+ Constantes.CASE_EN_PIXELS, box.getX(), box.getY()
					+ Constantes.CASE_EN_PIXELS);
			g.drawString(Integer.toString(box.getNumero()), box.getX()
					+ Constantes.CASE_EN_PIXELS / 2, box.getY()
					+ Constantes.CASE_EN_PIXELS / 2);
		}
		g.drawLine(grille.getCaseVide().getX(), grille.getCaseVide().getY(),
				grille.getCaseVide().getX() + Constantes.CASE_EN_PIXELS, grille
						.getCaseVide().getY());
		g.drawLine(grille.getCaseVide().getX(), grille.getCaseVide().getY(),
				grille.getCaseVide().getX(), grille.getCaseVide().getY()
						+ Constantes.CASE_EN_PIXELS);
		g.drawLine(grille.getCaseVide().getX() + Constantes.CASE_EN_PIXELS,
				grille.getCaseVide().getY() + Constantes.CASE_EN_PIXELS, grille
						.getCaseVide().getX() + Constantes.CASE_EN_PIXELS,
				grille.getCaseVide().getY());
		g.drawLine(grille.getCaseVide().getX() + Constantes.CASE_EN_PIXELS,
				grille.getCaseVide().getY() + Constantes.CASE_EN_PIXELS, grille
						.getCaseVide().getX(), grille.getCaseVide().getY()
						+ Constantes.CASE_EN_PIXELS);
	}
}
