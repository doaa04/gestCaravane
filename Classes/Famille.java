package mainClasses;
import java.util.ArrayList;

public class Famille {
	
	private int idFamille;
	public ArrayList<Habitant> membresFamille = new ArrayList<Habitant>();
	public ArrayList<Paquet> paquets = new ArrayList<Paquet>();
	Village village;
	
	public Famille(int idFamille, Village village) {
		this.idFamille = idFamille;
		this.village = village;
	}

	public int getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}

	
	// fonction qui vérifie si une famille ne contient pas une persone qui appartient a une categorie d'age
	public boolean estSansMembresDansCategorie(int ageMin, int ageMax) {
	    for (Beneficiaire membre : this.membresFamille) {
	        if (membre.getAge() >= ageMin && membre.getAge() <= ageMax) {
	            return false;  // Il y a au moins un membre dans la catégorie d'âge spécifiée
	        }
	    }
	    return true;  // Aucun membre dans la catégorie d'âge spécifiée
	}
	
	public boolean estSansEnfants() { //famille sans enfants
	    return estSansMembresDansCategorie(0, 12);
	}

	public boolean estSansAdolescent() { //famille sans adolescent
	    return estSansMembresDansCategorie(13, 17);
	}

	public boolean estSansJeuneAdulte() {//famille sans jeune adulte
	    return estSansMembresDansCategorie(18, 24);
	}

	public boolean estSansAdulte() {//famille sans adulte
	    return estSansMembresDansCategorie(25, 64);
	}

	public boolean estSansPersonneAgee() {//famille sans agée
	    return estSansMembresDansCategorie(65, Integer.MAX_VALUE);
	}
	
}
