package mainClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Data {
	
	static String url = "jdbc:mysql://localhost:3307/caravanes";
    static String utilisateur = "root";
    static String motDePasse = "root";
	
	public static Connection connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, utilisateur, motDePasse);
        } 
		catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	public static void ajouterMembre(Membre membre) {
		try (Connection con = connexion()) {
            if (con != null) {
                String requete = "INSERT INTO membre (idMembre, nom, prenom, numTelephone, dateNaissance, filiere, ine, score, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(requete);
            	pst.setInt(1, membre.getId());
                pst.setString(2, membre.getNom());
                pst.setString(3, membre.getPrenom());
                pst.setInt(4, membre.getNumTelephone());
                pst.setString(5, membre.getDateNaissance().toString());
                pst.setString(6, membre.getFiliere());
                pst.setInt(7, membre.getIne());
                pst.setInt(8, membre.getScore());
                pst.setString(9, membre.getUsername());
                pst.setString(10, membre.getPassword());

                pst.executeUpdate();
            }
        } 
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void supprimerMembre(int id) {
		try (Connection con = connexion()) {
            if (con != null) {
                String requete = "DELETE FROM membre WHERE idMembre=?";
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setInt(1, id);
                pst.executeUpdate();
            }
        } 
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static ArrayList<String> chercherMembreParFiliere(String filiere) {
        ArrayList<String> membresTrouves = new ArrayList<>();

        try (Connection con = connexion()) {
            if (con != null) {
                String requete = "SELECT * FROM membre WHERE filiere=?";
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setString(1, filiere);
                ResultSet resultat = pst.executeQuery();
                while (resultat.next()) {
                    membresTrouves.add(resultat.getInt("idMembre") + " : " + resultat.getString("nom") + " " + resultat.getString("prenom"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return membresTrouves;
    }
	
}
