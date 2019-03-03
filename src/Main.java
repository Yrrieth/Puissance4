import java.util.Scanner; // Interface clavier

public class Main {
	public static void main (String [] args) throws Ex1, Ex2, Ex3, Ex4{
		Puissance4 p1 = new Puissance4();
		p1.initialise();
		
		int x = 0;  // Variable pour la boucle du jeu
		boolean t = false;  // Variable pour la boucle du joueur 1
		boolean tt = false;  // Variable pour la boucle du joueur 2
		boolean mNul = false;  // Variable pour matchNul();
		int colonne = 0;  // Variable qui recuperera l'entree au clavier
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Veuillez saisir le nom du joueur 1 :"); 
		String nomJoueur1 = sc.nextLine();
		System.out.println("Vous avez saisi : " + nomJoueur1 + ", joli nom !");
		
		System.out.println("Veuillez saisir le nom du joueur 2 :");
		String nomJoueur2 = sc.nextLine();
		System.out.println("Vous avez saisi : " + nomJoueur2 + ", tres beau nom !");
		
		Joueur j1 = new Joueur ('X', nomJoueur1);
		Joueur j2 = new Joueur ('O', nomJoueur2);
		
		p1.affiche();
		
		while (x == 0) {  // Boucle du jeu
			mNul = p1.matchNul();
			if (mNul == true) {
				System.out.println("Match nul !");
				break;
			}
			while (t == false) {  // Verifie si on a saisie les bon chiffres pour le joueur 1
				System.out.println(j1.getNom() + " (" + j1.getSymbole() + ")" + " ,veuillez saisir le numero de la colonne :");
				colonne = sc.nextInt();
				if (colonne > 0 && colonne < 8) {  // Si oui, on sort de la boucle
					t = p1.mettre(j1.getSymbole(), colonne);
				} else {  // Sinon, on continue a demander la saisie
					System.out.println("Saisie impossible.");
				}
			}
			t = false;  // Reinitialise la boucle precedente
			p1.affiche();
			x = p1.verifie(j1.getSymbole());
			if (x == 1) {  // Si x == 1, alors victoire, on sort de la boucle du jeu
				System.out.println("Victoire de " + j1.getNom() + " !");
				break;
			}
			
			
			mNul = p1.matchNul();
			if (mNul == true) {
				System.out.println("Match nul !");
				break;
			}
			while (tt == false) {  // Verifie si on a saisie les bon chiffres pour le joueur 2
				System.out.println(j2.getNom() + " (" + j2.getSymbole() + ")" + " ,veuillez saisir le numero de la colonne :");
				colonne = sc.nextInt();
				if (colonne > 0 && colonne < 8) {
					tt = p1.mettre(j2.getSymbole(), colonne);
				} else {
					System.out.println("Saisie impossible.");
				}
			}
			tt = false;  // Reinitialise la boucle precedente
			p1.affiche();
			x = p1.verifie(j2.getSymbole());
			if (x == 1)
				System.out.println("Victoire de " + j2.getNom() + " !");
		}
		
	}
}

class Ex1 extends Exception{}
class Ex2 extends Exception{}
class Ex3 extends Exception{}
class Ex4 extends Exception{}
