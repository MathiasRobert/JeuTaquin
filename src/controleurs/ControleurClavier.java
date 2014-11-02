package controleurs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import modeles.Modele;
import modeles.Constantes;

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
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // fleche droite
			modele.deplacement(Constantes.Direction.DROITE);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // fleche gauche
			modele.deplacement(Constantes.Direction.GAUCHE);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) { // fleche haut
			modele.deplacement(Constantes.Direction.HAUT);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // fleche bas
			modele.deplacement(Constantes.Direction.BAS);
		}
	}
}
