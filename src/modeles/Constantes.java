package modeles;

public abstract class Constantes {
	/**
	 * nombre de lignes de la surface de jeu
	 */
	public static int NBRE_DE_LIGNES = 4;

	/**
	 * nombre de colonnes de la surface de jeu
	 */
	public static int NBRE_DE_COLONNES = 4;
	
	/**
	 * nombre de lignes maximum de la surface de jeu
	 */
	public static int NBRE_DE_LIGNES_MAX = 6;

	/**
	 * nombre de colonnes maximum de la surface de jeu
	 */
	public static int NBRE_DE_COLONNES_MAX = 6;
	
	/**
	 * nombre de lignes minimum de la surface de jeu
	 */
	public static int NBRE_DE_LIGNES_MIN = 2;

	/**
	 * nombre de colonnes minimum de la surface de jeu
	 */
	public static int NBRE_DE_COLONNES_MIN = 2;

	/**
	 * dimension d'une case en pixels
	 */
	public final static int CASE_EN_PIXELS = 100;
	
	public enum Direction {
		HAUT, DROITE, BAS, GAUCHE;
	}

}
