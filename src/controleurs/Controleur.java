package controleurs;

import javax.swing.JButton;

import vues.Vue;
import modeles.Modele;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class Controleur {
	private Modele modele;
	private Vue vue;

	public Controleur(Modele modele, Vue vue) {
		this.modele = modele;
		this.vue = vue;
		vue.addControleur(this);
	}

	public void newControleurClavier() {
		vue.getVueEnJeu().addKeyListener(new ControleurClavier(modele));
	}
	
	public void newControleurClickBouton(JButton bouton) {
		bouton.addActionListener(new ControleurClickBouton(modele, vue.getVueEnJeu()));
	}
}
