package controleurs;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import modeles.Constantes;
import modeles.Jeton;
import modeles.Modele;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class ControleurClickJeton extends MouseInputAdapter {
	Modele modele;

	public ControleurClickJeton(Modele modele) {
		this.modele = modele;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int caseVideX, caseVideY;
		Constantes.Direction direction = Constantes.Direction.GAUCHE;
		boolean depPossible = false;
		caseVideX = modele.getGrille().getCaseVide().getIndiceX();
		caseVideY = modele.getGrille().getCaseVide().getIndiceY();

		for (Jeton box : modele.getGrille().getListeGrille()) {
			if (box.getRectJeton().contains(
					e.getX() - Constantes.POSITION_X_VUEGRILLE,
					e.getY() - Constantes.POSITION_Y_VUEGRILLE)) {
				if (box.getIndiceX() == caseVideX - 1
						&& box.getIndiceY() == caseVideY) {
					direction = Constantes.Direction.GAUCHE;
					depPossible = true;
				}
				else if (box.getIndiceX() == caseVideX + 1
						&& box.getIndiceY() == caseVideY) {
					direction = Constantes.Direction.DROITE;
					depPossible = true;
				}
				else if (box.getIndiceX() == caseVideX
						&& box.getIndiceY() == caseVideY - 1) {
					direction = Constantes.Direction.HAUT;
					depPossible = true;
				}
				else if (box.getIndiceX() == caseVideX
						&& box.getIndiceY() == caseVideY + 1) {
					direction = Constantes.Direction.BAS;
					depPossible = true;
				}
				if (depPossible) {
					modele.deplacement(direction);
				}
				break;
			}
		}
	}
}
