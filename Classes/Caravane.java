package mainClasses;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Caravane {
    
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	private Village village;
	static List<Membre> participants = new ArrayList<Membre>();
	
	public Caravane(String nom,Date dateDebut, Date dateFin, Village village) throws IOException {
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.village = village;
		this.village.nombreVisites++;
		/*
		 * création d'un fichier contenant les informations de la caravane. 
		 * ce fichier va permettre les administrateurs de réaliser plus facilement les
		 * affiches et les annonces liées à la caravane.
		 */
		FileWriter infosCaravaneWriter = new FileWriter("C:\\Users\\rigui_vf\\eclipse-workspace\\GestionDesCaravanes\\infosCaravane.txt");
		infosCaravaneWriter.write(
				"nom : " + nom + "\n"
				+ "date de début : " + dateDebut + "\n"
				+ "date de fin : " + dateFin + "\n"
				+ "destination : " + village.getNom() + "\n"
				+ "liste des participants :\n"
				);
		for (int i = 0; i< updateParticipants().size(); i++) {
			infosCaravaneWriter.write(updateParticipants().get(i).toString()+"\n");
		}
		infosCaravaneWriter.close();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}
	
	/*
	 * affichage des membres qui peuvent participer à la caravane, seuls 50 étudiants peuvent y 
	 * participer et ils sont classés selon leurs scores.
	 */
	
	public static List<Membre> updateParticipants() {
		Collections.sort(Membre.getMembres());
		if (Membre.getMembres().size()<=50) {
			return Membre.getMembres();
		}
		participants = Membre.getMembres().subList(0, 50);
		return participants;
	}
	
	/*
	 * lecture du fichier contenant les informations de la caravane
	 */
	
	public static void lireInfosCaravane() throws IOException {
		FileReader infosCaravaneReader = new FileReader("infosCaravane.txt");
		int data = infosCaravaneReader.read();
		while (data!=-1) {
			System.out.print((char) data);
			data = infosCaravaneReader.read();
		}
		infosCaravaneReader.close();
	}
	
}
