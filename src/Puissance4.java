public class Puissance4 {
	char [][] grille = new char [8][8];
	char [] colonne = {'1','2','3','4','5','6','7'}; // Pour afficher le numero de la colonne
	int i, j;

	
	public void initialise() { // Initialise le tableau par des points
		for (i = 1; i < grille.length; i++) {
			for (j = 1; j < grille.length; j++) {
				if (i == 1) {
					grille[i][j] = colonne [j - 1]; // Si i == 1, alors, on met des chiffres
				} else {
					grille[i][j] = '.';
				}
			}
		}
	}
	public void affiche() { // Affiche le tableau
		for (i = 1; i < grille.length; i++) {
			for (j = 1; j < grille.length; j++) {
				System.out.print(grille[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public boolean mettre(char s, int c) { // Met un symbole "s", dans la colonne "c"
		for (i = 7; i > 0 ; i--) { // On part depuis le bas de la grille et on remonte
			if (i == 2 && (grille[i][c] == 'O' || grille[i][c] == 'X')) {  // Si la colonne est deja rempli, on retourne false
				System.out.println("Colonne deja rempli, choississez une autre colonne !");
				return false;
			}
			
			if (grille[i - 1][c] == '.' && (grille[i][c] == 'O' || grille[i][c] == 'X')) {  // Si la case actuelle est occupe et que celle d'au-dessus est vide, on retourne true
				grille[i - 1][c] = s;
				return true;
			}
			
			if (i == 7 && grille[i][c] == '.') {  // Si la rangee la plus basse est vide, on retourne true
				grille[i][c] = s;
				return true;
			}
		}
		return false;
	}
	
	public int verifie(char s) { // Verifie dans quel cas, il y a un alignement de 4 jetons identiques
		int compteur = 4;
		int tmpI = 0;  // Variable temporaire qui stockera une position i
		int tmpJ = 0;  // Variable temporaire qui stockera une position j
		
		for (i = 1; i < grille.length; i++) { // Verifie horizontalement
			for (j = 1; j < grille.length; j++) {
				
				if (grille[i][j] == s) {  // Si un symbole s'y trouve
					compteur--;
					
					if (compteur == 0) {
						System.out.println("Puissance 4 !");
						return 1;
					}
					if (compteur != 4 && j == 7) // Pour ne pas compter le jeton de la ligne suivante
						compteur = 4;
				} else {
					compteur = 4;
				}
			}
		}
		compteur = 4; // Reinitialise le compteur
		
		for (j = 1; j < grille.length; j++) { // Verifie verticalement
			for (i = 1; i < grille.length; i++) {
				if (grille[i][j] == s) {
					compteur--;
					
					if (compteur == 0) {
						System.out.println("Puissance 4 !");
						return 1;
					}
					if (compteur != 4 && i == 7)
						compteur = 4;
				} else {
					compteur = 4;
				}
			}
		}
		compteur = 4;
		
		for (i = 7; i > 0; i--) { // Verifie diagonalement depuis bas/gauche vers haut/droite
			for (j = 1; j < grille.length; j++) {
				if (grille[i][j] == s) { // Si un symbole s'y trouve
					compteur--;
					if (tmpI == 0 && tmpJ == 0) { // tmpI et tmpJ stockeront UNE fois la position actuelle du tableau
						tmpI = i;
						tmpJ = j;
					}
					if (compteur != 0 && i == 1) { // Ne compte pas a droite du symbole, a la ligne 1
						break;
					}
					if (i > 1)
						i--;  // Deplace i pour faire l'effet de diagonale
					if (compteur == 0) {
						System.out.println("Puissance 4 !");
						return 1;
					}
					if (compteur != 4 && (j == 7)) {  // Pour ne pas compter le jeton de la diagonale suivante si on se trouve deja en haut et/ou a droite
						compteur = 4;
						i = tmpI;  // i recoit sa position initiale
						j = tmpJ;  // pareil
						tmpI = 0;  // Reinitialise tmpI et tmpJ
						tmpJ = 0;
					}
				} else {
					compteur = 4;
					if (tmpI != 0 && tmpJ != 0 && tmpI != i && tmpJ != j) { // Si tmpI et tmpJ ne valent pas 0 et qu'on s'est deja deplace dans le tableau 
						i = tmpI;  // i recoit sa position initiale
						j = tmpJ;  // pareil
						tmpI = 0;  // Reinitialise tmpI et tmpJ
						tmpJ = 0;
					}
				}
			}
		}
		compteur = 4;
		tmpI = 0;
		tmpJ = 0;

		for (i = 1; i < grille.length; i++) { // Verifie diagonalement depuis haut/gauche vers bas/droite
			for (j = 1; j < grille.length; j++) {
				if (grille[i][j] == s) {
					compteur--;
					if (tmpI == 0 && tmpJ == 0) {
						tmpI = i;
						tmpJ = j;
					}
					if (compteur != 0 && i == 7) { // Ne compte pas a droite du symbole, a la ligne 7
						break;
					}
					if (i < 7)
						i++;
					if (compteur == 0) {
						System.out.println("Puissance 4 !");
						return 1;
					}
					if (compteur != 4 && j == 7) {  // Pour ne pas compter le jeton de la diagonale suivante si on se trouve deja en bas et/ou a droite
						compteur = 4;
						i = tmpI;  // i recoit sa position initiale
						j = tmpJ;  // pareil
						tmpI = 0;  // Reinitialise tmpI et tmpJ
						tmpJ = 0;
					}
				} else {
					compteur = 4;
					if (tmpI != 0 && tmpJ != 0 && tmpI != i && tmpJ != j) {
						i = tmpI;
						j = tmpJ;
						tmpI = 0;
						tmpJ = 0;
					}
				}
			}
		}
		compteur = 4;
		tmpI = 0;
		tmpJ = 0;
		return 0;
	}
	
/**
*@
*/
	public boolean matchNul () {
		int rempli = 0;
		for (i = 1; i < grille.length; i++) {
			for (j = 1; j < grille.length; j++) {
				if (grille [i][j] == 'O' || grille [i][j] == 'X') {
					rempli++;
				} else {
					rempli = 0;
				}
			}
		}
		if (rempli == 42)
			return true;
		return false;
	}
		
	
}
