package vues;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import controleurs.Controleur;
import modeles.Modele;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class Vue extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -598600068637201269L;
	Modele modele;
	Controleur controleur;
	VueEnJeu vueEnJeu;

	public Vue(Modele modele) {
		setTitle("Jeu du taquin");
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.modele = modele;
		modele.addObserver(this);

		vueEnJeu = new VueEnJeu(modele);
		setContentPane(vueEnJeu);
		setFocusable(false);
		vueEnJeu.setFocusable(true);

		setVisible(true);
	}

	/**
	 * @return the vueGrille
	 */
	public VueEnJeu getVueEnJeu() {
		return vueEnJeu;
	}

	@Override
	public void update(Observable o, Object arg) {
		vueEnJeu.repaint();
		vueEnJeu.majLabelNbDeCoups();
	}

	public void addControleur(Controleur controleur) {
		this.controleur = controleur;
		controleur.newControleurClavier();
		controleur.newControleurClickJeton();
		vueEnJeu.initControleurBouton(controleur);
	}

}
