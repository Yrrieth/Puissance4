public class Joueur {
	private char symbole;
	private String nom;
	public Joueur(char x, String n) {
		this.symbole = x;
		this.nom = n;
	}
	
	public char getSymbole() {
		return symbole;
	}
	
	public String getNom() {
		return nom;
	}
}
