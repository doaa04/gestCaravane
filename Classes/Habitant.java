package mainClasses;
import java.util.Date;

public class Habitant extends Personne {
	
	private int idHabitant;
	private Famille famille;
	private Character genre; // f ou m
	private String profession; 
	private String etatSanitaire; // sain ou malade

	public Habitant(int idHabitant, String nom, String prenom, String dateNaissance, int numTelephone, Famille famille, Character genre, String profession, String etatSanitaire) {
		super(nom, prenom, dateNaissance, numTelephone);
		this.setIdHabitant(idHabitant);
		this.famille = famille;
		this.genre = genre;
		this.setProfession(profession);
		this.etatSanitaire = etatSanitaire;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
		famille.membresFamille.add(this);
	}

	public Character getGenre() {
		return genre;
	}

	public void setGenre(Character genre) {
		this.genre = genre;
	}

	public String getEtatSanitaire() {
		return etatSanitaire;
	}

	public void setEtatSanitaire(String etatSanitaire) {
		this.etatSanitaire = etatSanitaire;
	}

	public int getIdHabitant() {
		return idHabitant;
	}

	public void setIdHabitant(int idHabitant) {
		this.idHabitant = idHabitant;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
}
