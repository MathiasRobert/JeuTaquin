package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.VueEnJeu;
import modeles.Constantes;
import modeles.Modele;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class ControleurClickBouton implements ActionListener {
	Modele modele;
	VueEnJeu vueEnJeu;

	public ControleurClickBouton(Modele modele, VueEnJeu vueEnJeu) {
		this.modele = modele;
		this.vueEnJeu = vueEnJeu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vueEnJeu.getAjoutLigne())) {
			if (Constantes.NBRE_DE_LIGNES < Constantes.NBRE_DE_LIGNES_MAX) {
				Constantes.NBRE_DE_LIGNES++;
				modele.recommencer();
				vueEnJeu.reinitialiserBoutons();
			}
		} else if (e.getSource().equals(vueEnJeu.getSuppLigne())) {
			if (Constantes.NBRE_DE_LIGNES > Constantes.NBRE_DE_LIGNES_MIN) {
				Constantes.NBRE_DE_LIGNES--;
				modele.recommencer();
				vueEnJeu.reinitialiserBoutons();
			}
		} else if (e.getSource().equals(vueEnJeu.getAjoutColonne())) {
			if (Constantes.NBRE_DE_COLONNES < Constantes.NBRE_DE_COLONNES_MAX) {
				Constantes.NBRE_DE_COLONNES++;
				modele.recommencer();
				vueEnJeu.reinitialiserBoutons();
			}
		} else if (e.getSource().equals(vueEnJeu.getSuppColonne())) {
			if (Constantes.NBRE_DE_COLONNES > Constantes.NBRE_DE_COLONNES_MIN) {
				Constantes.NBRE_DE_COLONNES--;
				modele.recommencer();
				vueEnJeu.reinitialiserBoutons();
			}
		}
		vueEnJeu.requestFocus();
	}

}
