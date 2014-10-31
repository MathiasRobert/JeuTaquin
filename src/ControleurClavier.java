import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class ControleurClavier extends KeyAdapter {
	Modele modele;

	public ControleurClavier(Modele modele) {
		this.modele = modele;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // flèche droite
			modele.deplacement(Constantes.Direction.DROITE);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // flèche gauche
			modele.deplacement(Constantes.Direction.GAUCHE);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) { // flèche haut
			modele.deplacement(Constantes.Direction.HAUT);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // flèche bas
			modele.deplacement(Constantes.Direction.BAS);
		}
	}
}
