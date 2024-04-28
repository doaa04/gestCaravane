package mainClasses;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Membre extends Personne implements Comparable<Membre>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idMembre;
	private String filiere;
	private int ine;
	private int score;
	private String username;
	private transient String password;
	private static ArrayList<Membre> membres = new ArrayList<>();
	
	public Membre() {
		super();
    }
		
	public Membre(int idMembre, String nom, String prenom, String dateNaissance, int numTelephone, String filiere, int ine) {
		super(nom, prenom, dateNaissance, numTelephone);
		this.idMembre = idMembre;
		this.filiere = filiere;
		this.ine = ine;
		this.score = 0; // nouveau membre; n'a pas encore participé à des activités
		this.username = "username";
		this.password = "password";
		membres.add(this);
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public int getIne() {
		return ine;
	}

	public void setIne(int ine) {
		this.ine = ine;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getId() {
		return idMembre;
	}
	
	public void setId(int idMembre) {
		this.idMembre = idMembre;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "[id : " + idMembre + ", nom: " + super.getNom() + ", prenom: " + super.getPrenom() + ", score: " + score + "]";
	}

	@Override
	public int compareTo(Membre membre) {
		if (this.score < membre.score)
			return 1;
		return -1;
		
	}

	public static ArrayList<Membre> getMembres() {
		return membres;
	}

	
}
