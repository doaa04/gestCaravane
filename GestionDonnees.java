package mainClasses;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionDonnees {

	public static void sauvegarderCaravanes(List<Caravane> caravanes, String fichier) throws IOException {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
	        for (Caravane caravane : caravanes) {
	            oos.writeObject(caravane);
	        }
	    }
	}//sauvegarder les donnees des caravanes dans des fichiers (Serialization);


	public static List<Caravane> chargerCaravanes(String fichier) throws IOException, ClassNotFoundException {
	    List<Caravane> caravanes = new ArrayList<>();
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
	        try {
	            while (true) {
	                Caravane caravane = (Caravane) ois.readObject();
	                caravanes.add(caravane);
	            }
	        } catch (EOFException e) {
	        	 // Fin du fichier.
	        }catch (ClassNotFoundException e) {
	    			System.err.println("Erreur lors de la désérialisation : classe non trouvée.");
	    	}
	    }
	    return caravanes;
	}//recuperer les donnes des caravanes stocker dans un fichier en utilisant la deserialization;


    public static void sauvegarderFamilles(List<Famille> familles, String fichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
        	for(Famille famille:familles) {
                 oos.writeObject(famille);
        	}
        }
    }//sauvegarder les donnees des familles dans des fichiers (Serialization);

    public static List<Famille> chargerFamilles(String fichier) throws IOException, ClassNotFoundException {
    	 List<Famille> familles = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
        	try {
	            while (true) {
	                Famille famille = (Famille) ois.readObject();
	                familles.add(famille);
	            }
        	 } catch (EOFException e) {
	        	 // Fin du fichier.
	         }catch (ClassNotFoundException e) {
	    			System.err.println("Erreur lors de la désérialisation : classe non trouvée.");
	    	 }
	    }
	    return familles;
    }//recuperer les donnes des familles stocker dans un fichier en utilisant la deserialization;
    public static void sauvegarderMembres(List<Membre> membres, String fichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
        	for(Membre membre: membres) {
               oos.writeObject(membre);
        	}
        }
    }//sauvegarder les donnees des membres du CAS dans des fichiers (Serialization);

    public static List<Membre> chargerMembres(String fichier) throws IOException, ClassNotFoundException {
    	List<Membre> membres = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
        	try {
	            while (true) {
	                Membre membre = (Membre) ois.readObject();
	                membres.add(membre);
	            }
	        }catch (EOFException e) {
	        	 // Fin du fichier.
	        }catch (ClassNotFoundException e) {
	    			System.err.println("Erreur lors de la désérialisation : classe non trouvée.");
	    	}
	    }
	    return membres;
    }//recuperer les donnes des membres stocker dans un fichier en utilisant la deserialization;
}
