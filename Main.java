package mainClasses;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		// instanciation de 60 membres aléatoires pour faire des tests
				
		try {
			String[] filieres = {"ASEDS","AMOA","CLOUD","SMART","ICCN","SESSNUM","DATA"};
			Random rnd = new Random();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			Date date = sdf.parse("2002-05-01"); // par exemple
			for (int i = 1; i <= 60; i++) {
				Membre membre = new Membre(i, "nom", "prenom",sdf.format(date) , rnd.nextInt(100000000)+600000000, filieres[rnd.nextInt(7)] , 3-rnd.nextInt(3));
				membre.setScore(rnd.nextInt(100));
				membre.setUsername("user" + i);
				Data.ajouterMembre(membre);
			}
		}
		catch (ParseException e) {
            System.err.println("format invalide. Veuillez saisir une date de la forme : jj-mm-aaaa");
        }
		
		
		// test de la classe Data
				
	
		/* 
		 * instantiation d'une caravane pour tester la modification du fichier contenant
		 * ses informations.
		 * les informations de la caravane sont automatiquement stockés dans le fichier.
		 * la liste des participants est mise à jour automatiquement après modification 
		 * des scores des membres.
		 */
		
		
		try {
			Caravane caravane = new Caravane("caravane de test", null, null, new Village(0, "village de test", null));
			System.out.println(caravane);
			System.out.println("informations de la caravane ___________________________________");
			Caravane.lireInfosCaravane();

		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * test de sérialisation et de désérialisation
		 */
		
		System.out.println("sérialisation et déserialisation ___________________________________");
		enregistrerMembres(Membre.getMembres());
		List<Membre> membresCharges = chargerMembres();
	    afficherMembres(membresCharges);
	    
	    /*
	     * lecture à partir de la base de données 
	     */
	    
	    System.out.println("membres ASEDS _________________________________________");
	    ArrayList<String> membresASEDS = Data.chercherMembreParFiliere("ASEDS");
        for (String membre : membresASEDS) {
            System.out.println(membre);
        }
        
        // test de la classe Personne 
        
    	Personne personne = new Personne("nom", "personne", "24-08-2004", 622105151);
    	
    	try {
			System.out.println("agee : " + personne.getAge());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	}
	
	public static void enregistrerMembres(List<Membre> membres) {
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\rigui_vf\\eclipse-workspace\\GestionDesCaravanes\\membres.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(membres);
			oos.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("unchecked")
	public static List<Membre> chargerMembres() {
        List<Membre> membres = new ArrayList<>();
        try {
        	FileInputStream fis = new FileInputStream("C:\\Users\\rigui_vf\\eclipse-workspace\\GestionDesCaravanes\\membres.txt");
        	ObjectInputStream ois = new ObjectInputStream(fis);
            membres = (List<Membre>) ois.readObject();
            ois.close();
        } 
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return membres;
    }
	
	public static void afficherMembres(List<Membre> membres) {
        System.out.println("Liste des membres :");
        for (Membre membre : membres) {
            System.out.println(membre.toString());
        }
    }
	
}
