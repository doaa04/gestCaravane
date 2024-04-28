package interfaceGraphique;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainClasses.Membre;

public class interfaceConnexion extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		// stage
		primaryStage.setTitle("formulaire de connexion");
		
		// grid
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
		
		// scène
		Scene scene = new Scene(grid, 450, 550);
        primaryStage.setScene(scene);
        
        // logo
        Image logoImage = new Image("file:C:/Users/rigui_vf/eclipse-workspace/GestionDesCaravanes/src/images/logo cas blue.png"); // Replace with the actual path to your logo image
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(300); // Set the width of the image
        logoImageView.setFitHeight(300); // Set the height of the image
        logoImageView.setPreserveRatio(true); // Maintain the aspect ratio
        grid.add(logoImageView, 0, 0, 2, 1);
        
        // titre 
        Text title = new Text("________ Welcome ________");
        grid.add(title, 0, 1, 2, 1);

        // input
        Label usernameLabel = new Label("username:");
        TextField usernameTextField = new TextField();

        Label passwordLabel = new Label("password:");
        PasswordField passwordTextField = new PasswordField();

        // boutton
        Button loginButton = new Button("Login");
        
        // text affiché
        Label message = new Label();
		message.setLayoutX(10);
		message.setLayoutY(100);
		message.setTextFill(Color.RED);

        // positions dans le grid
        grid.add(usernameLabel, 0, 2);
        grid.add(usernameTextField, 1, 2);
        grid.add(passwordLabel, 0, 3);
        grid.add(passwordTextField, 1, 3);
        grid.add(loginButton, 1, 4);
        grid.add(message, 1, 5);
        
        // action
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				for (Membre membre : Membre.getMembres()) {
		            if (membre.getUsername().equals(usernameTextField.getText())) {
		            	message.setText("welcome" + usernameTextField.getText());
		            	return;
		            }
		        }
				message.setText("veuillez vérifier vos informations");
			}
		});
        
        // affichage
        primaryStage.show();
	}

}
