import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class ControleurClickBouton implements ActionListener {
	Modele modele;
	VueGrille vueGrille;
	
	public ControleurClickBouton(Modele modele, VueGrille vueGrille) {
		this.modele = modele;
		this.vueGrille = vueGrille;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vueGrille.getAjoutLigne())) {
			if(Constantes.NBRE_DE_LIGNES < Constantes.NBRE_DE_LIGNES_MAX) {
				Constantes.NBRE_DE_LIGNES++;
				modele.recommencer();
				vueGrille.reinitialiserBoutons();
			}
		}
		else if (e.getSource().equals(vueGrille.getSuppLigne())) {
			if(Constantes.NBRE_DE_LIGNES > Constantes.NBRE_DE_LIGNES_MIN) {
				Constantes.NBRE_DE_LIGNES--;
				modele.recommencer();
				vueGrille.reinitialiserBoutons();
			}
		}
		else if (e.getSource().equals(vueGrille.getAjoutColonne())) {
			if(Constantes.NBRE_DE_COLONNES < Constantes.NBRE_DE_COLONNES_MAX) {
				Constantes.NBRE_DE_COLONNES++;
				modele.recommencer();
				vueGrille.reinitialiserBoutons();
			}
		}
		else if (e.getSource().equals(vueGrille.getSuppColonne())) {
			if(Constantes.NBRE_DE_COLONNES > Constantes.NBRE_DE_COLONNES_MIN) {
				Constantes.NBRE_DE_COLONNES--;
				modele.recommencer();
				vueGrille.reinitialiserBoutons();
			}
		}
		vueGrille.requestFocus();
	}

}
