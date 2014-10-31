import javax.swing.JButton;

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
		vue.getVueGrille().addKeyListener(new ControleurClavier(modele));
	}
	
	public void newControleurClickBouton(JButton bouton) {
		bouton.addActionListener(new ControleurClickBouton(modele, vue.getVueGrille()));
	}
}
