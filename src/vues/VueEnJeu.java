package vues;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleurs.Controleur;
import modeles.Constantes;
import modeles.Modele;

/**
 * 
 */

/**
 * @author mathias
 *
 */
public class VueEnJeu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2121291365151497623L;
	private Modele modele;
	private VueGrille vueGrille;
	private JButton ajoutLigne;
	private JButton suppLigne;
	private JButton ajoutColonne;
	private JButton suppColonne;
	private JLabel titreJeu;
	private JLabel titreNbDeCoups;
	private JLabel nbDeCoups;

	public VueEnJeu(Modele modele) {
		this.modele = modele;
		setLayout(null);

		vueGrille = new VueGrille(modele.getGrille());
		vueGrille.setBounds(200, 100, 900, 900);
		initBoutons();
		initLabels();
		add(vueGrille);
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
		ajoutLigne = new JButton("Ajout Ligne");
		ajoutLigne.setBounds(vueGrille.getX() + 25, vueGrille.getY()
				+ Constantes.NBRE_DE_LIGNES * Constantes.CASE_EN_PIXELS + 20,
				150, 50);
		add(ajoutLigne);

		suppLigne = new JButton("Supprimer Ligne");
		suppLigne.setBounds(vueGrille.getX() + 225, vueGrille.getY()
				+ Constantes.NBRE_DE_LIGNES * Constantes.CASE_EN_PIXELS + 20,
				150, 50);
		add(suppLigne);

		ajoutColonne = new JButton("Ajout Colonne");
		ajoutColonne.setBounds(vueGrille.getX() + Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20, vueGrille.getY() + 25, 150,
				50);
		add(ajoutColonne);

		suppColonne = new JButton("Supprimer Colonne");
		suppColonne.setBounds(vueGrille.getX() + Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20, vueGrille.getY()
				+ Constantes.CASE_EN_PIXELS + 25, 150, 50);
		add(suppColonne);
	}

	public void reinitialiserBoutons() {
		ajoutLigne.setBounds(vueGrille.getX() + 50, vueGrille.getY()
				+ Constantes.NBRE_DE_LIGNES * Constantes.CASE_EN_PIXELS + 20,
				125, 50);
		suppLigne.setBounds(vueGrille.getX() + 225, vueGrille.getY()
				+ Constantes.NBRE_DE_LIGNES * Constantes.CASE_EN_PIXELS + 20,
				125, 50);
		ajoutColonne.setBounds(vueGrille.getX() + Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20, vueGrille.getY() + 25, 150,
				50);
		suppColonne.setBounds(vueGrille.getX() + Constantes.NBRE_DE_COLONNES
				* Constantes.CASE_EN_PIXELS + 20, vueGrille.getY()
				+ Constantes.CASE_EN_PIXELS + 25, 150, 50);
	}

	public void initControleurBouton(Controleur controleur) {
		controleur.newControleurClickBouton(ajoutLigne);
		controleur.newControleurClickBouton(suppLigne);
		controleur.newControleurClickBouton(ajoutColonne);
		controleur.newControleurClickBouton(suppColonne);
	}

	private void initLabels() {
		titreJeu = new JLabel("Jeu du taquin");
		titreJeu.setFont(new Font("Verdana", Font.BOLD, 30));
		titreJeu.setBounds(vueGrille.getX(), 0, 300, 100);
		add(titreJeu);

		titreNbDeCoups = new JLabel("Nombre de coups :");
		titreNbDeCoups.setFont(new Font("Verdana", Font.PLAIN, 15));
		titreNbDeCoups.setBounds(10, vueGrille.getY(), 150, 50);
		add(titreNbDeCoups);

		nbDeCoups = new JLabel(Integer.toString(modele.getNbDeCoups()));
		nbDeCoups.setFont(new Font("Verdana", Font.PLAIN, 25));
		nbDeCoups.setBounds(20, titreNbDeCoups.getY() + 20, 150, 100);
		add(nbDeCoups);
	}
	
	public void majLabelNbDeCoups() {
		nbDeCoups.setText(Integer.toString(modele.getNbDeCoups()));
	}
}
