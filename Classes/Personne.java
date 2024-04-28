package mainClasses;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class Personne {
	
	private String nom;
	private String prenom;
	private String dateNaissance; // "dd-mm-yyyy"
	private int numTelephone; 
	
	public Personne() {
	}

	public Personne(String nom, String prenom, String dateNaissance, int numTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.numTelephone = numTelephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}
	
	/*
	 * fonction qui calcule l'age d'une personne à partir de sa date de naissance,
	 * cette fonction sera utile pour simplifier le code de la fonction contientEnfants
	 * dans la classe Famille.
	 */
	
    
    public int getAge() throws ParseException {
    	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		Date naissance = sdf1.parse(dateNaissance);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	Date actuelle = new Date();
    	return (Integer.parseInt(sdf.format(actuelle)) - Integer.parseInt(sdf.format(naissance))); 
    }
	
}
