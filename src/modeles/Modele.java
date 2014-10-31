package modeles;

import java.util.Observable;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class Modele extends Observable{
	Grille grille;
	int nbDeCoups;
	
	public Modele() {
		grille = new Grille();
		nbDeCoups = 1;
	}
	
	public void recommencer() {
		grille.reinitialiser();
		nbDeCoups = 0;
		setChanged();
		notifyObservers();
	}
	
	public void deplacement(Constantes.Direction direction) {
		int tmpX, tmpY;
		boolean mouvFait = false;
		tmpX = grille.getCaseVide().getIndiceX();
		tmpY = grille.getCaseVide().getIndiceY();
		if (deplacementPossible(direction)) {
			for (Jeton box : grille.getListeGrille()) {
				switch (direction) {
				case GAUCHE:
					if (box.getIndiceX() == tmpX - 1
							&& box.getIndiceY() == tmpY) {
						grille.getCaseVide().setIndiceX(box.getIndiceX());
						box.setIndiceX(tmpX);
						mouvFait = true;
					}
					break;
				case DROITE:
					if (box.getIndiceX() == tmpX + 1
							&& box.getIndiceY() == tmpY) {
						grille.getCaseVide().setIndiceX(box.getIndiceX());
						box.setIndiceX(tmpX);
						mouvFait = true;
					}
					break;
				case HAUT:
					if (box.getIndiceY() == tmpY - 1
							&& box.getIndiceX() == tmpX) {
						grille.getCaseVide().setIndiceY(box.getIndiceY());
						box.setIndiceY(tmpY);
						mouvFait = true;
					}
					break;
				case BAS:
					if (box.getIndiceY() == tmpY + 1
							&& box.getIndiceX() == tmpX) {
						grille.getCaseVide().setIndiceY(box.getIndiceY());
						box.setIndiceY(tmpY);
						mouvFait = true;
					}
					break;
				}
				if (mouvFait) {
					box.verifPlacement();
					box.majCouleur();
					nbDeCoups++;
					setChanged();
					notifyObservers();
					break;
				}
			}
		}
	}

	public boolean deplacementPossible(Constantes.Direction direction) {
		if (grille.getCaseVide().getIndiceX() == Constantes.NBRE_DE_COLONNES - 1
				&& direction == Constantes.Direction.DROITE)
			return false;
		else if (grille.getCaseVide().getIndiceX() == 0 && direction == Constantes.Direction.GAUCHE)
			return false;
		else if (grille.getCaseVide().getIndiceY() == Constantes.NBRE_DE_LIGNES - 1
				&& direction == Constantes.Direction.BAS)
			return false;
		else if (grille.getCaseVide().getIndiceY() == 0 && direction == Constantes.Direction.HAUT)
			return false;
		return true;
	}

	public Grille getGrille() {
		return grille;
	}

	public int getNbDeCoups() {
		return nbDeCoups;
	}

}
