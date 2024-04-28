package interfaceGraphique;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mainClasses.Data;
import mainClasses.Membre;

public class interfaceGestionMembres extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// stage
		primaryStage.setTitle("gestion des membres");
		
		// grid
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(30);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		// ajout d'un membre
        Label ajouter = new Label("Ajouter un membre :");
        grid.add(ajouter, 0, 0);
        ajouter.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #6a9edd; -fx-underline: true;");
        // id
        Label idMembreLabel = new Label("id");
        grid.add(idMembreLabel, 1, 0);
        TextField idMembre = new TextField();
        grid.add(idMembre, 2, 0);
        // nom
        Label nomLabel = new Label("nom");
        grid.add(nomLabel, 1, 1);
        TextField nom = new TextField();
        grid.add(nom, 2, 1);
        // prenom
        Label prenomLabel = new Label("prénom");
        grid.add(prenomLabel, 1, 2);
        TextField prenom = new TextField();
        grid.add(prenom, 2, 2);
        // filière
        Label filiereLabel = new Label("filière");
        grid.add(filiereLabel, 1, 3);
        TextField filiere = new TextField();
        grid.add(filiere, 2, 3);
        // ine
        Label ineLabel = new Label("ine");
        grid.add(ineLabel, 1, 4);
        TextField ine = new TextField();
        grid.add(ine, 2, 4);
        // date de naissance
        Label dateNaissanceLabel = new Label("jj-mm-aaaa");
        grid.add(dateNaissanceLabel, 1, 5);
        TextField dateNaissance = new TextField();
        grid.add(dateNaissance, 2, 5);
        // numéro de téléphone
        Label numTelLabel = new Label("téléphone");
        grid.add(numTelLabel, 1, 6);
        TextField numTel = new TextField();
        grid.add(numTel, 2, 6);
        // boutton d'ajout
        Button bouttonAjouter = new Button("Ajouter");
        grid.add(bouttonAjouter, 2, 7);
        // action
        /*
        bouttonAjouter.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {		
				Membre membre = new Membre(
						Integer.parseInt(idMembre.getText()),
						nom.getText(), 
						prenom.getText(), 
						dateNaissance.getText(), 
						Integer.parseInt(numTel.getText()),
						filiere.getText(), 
						Integer.parseInt(ine.getText())
						);
				Data.ajouterMembre(membre);
			}
        	
        });
        */
        
        // recherche d'un membre
        Label rechercher = new Label("Rechercher des membres :");
        grid.add(rechercher, 0, 10);
        rechercher.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #6a9edd; -fx-underline: true;");
        // choice box
        Label rechercheFiliere = new Label("filière");
        grid.add(rechercheFiliere, 1, 10);
        ChoiceBox<String> choice = new ChoiceBox();
        ObservableList<String> filieres = choice.getItems();
        filieres.addAll("ASEDS", "AMOA", "CLOUD", "DATA", "ICCN", "SESSNUM", "SMART");
        grid.add(choice, 2, 10);
        // boutton rechercher
        Button bouttonRechercher = new Button("Rechercher");
        grid.add(bouttonRechercher, 2, 11);
        
        // suppression d'un membre
        Label supprimer = new Label("Supprimer un membre :");
        grid.add(supprimer, 0, 13);
        supprimer.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #6a9edd; -fx-underline: true;");
        // id
        Label idLabel = new Label("id");
        grid.add(idLabel, 1, 13);
        TextField id = new TextField();
        grid.add(id, 2, 13);
        // boutton supprimer
        Button bouttonSupprimer = new Button("supprimer");
        grid.add(bouttonSupprimer, 2, 14);
        
		// scène
		Scene scene = new Scene(grid, 550, 550);
		primaryStage.setScene(scene);
		
		// affichage
        primaryStage.show();
		
	}

}
