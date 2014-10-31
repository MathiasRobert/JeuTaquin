import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

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
	VueGrille vueGrille;

	public Vue(Modele modele) {
		setTitle("Jeu du taquin");
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.modele = modele;
		modele.addObserver(this);
				
		vueGrille = new VueGrille(modele.getGrille());
		add(vueGrille);
		setFocusable(false);
		vueGrille.setFocusable(true);
		setVisible(true);
		vueGrille.setBounds(100,100,900,900);
	}
	
	/**
	 * @return the vueGrille
	 */
	public VueGrille getVueGrille() {
		return vueGrille;
	}

	@Override
	public void update(Observable o, Object arg) {
		vueGrille.repaint();
	}

	public void addControleur(Controleur controleur) {
		this.controleur = controleur;
		controleur.newControleurClavier();
		vueGrille.initControleurBouton(controleur);
	}

}
