package mainClasses;

public class Village {
	
	private int id;
	private String nom;
	private String adresse;
	public int nombreVisites;
	
	public Village(int id, String nom, String adresse) {
		this.setId(id); 
		this.nom = nom;
		this.adresse = adresse;
		this.nombreVisites = 0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
