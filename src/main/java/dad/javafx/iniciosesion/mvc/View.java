package dad.javafx.iniciosesion.mvc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends BorderPane {
	
	private Label userLabel;
	private Label passLabel;
	
	private TextField userText;
	private PasswordField passField;
	
	private Button accederButton;
	private Button cancelButton;
	
	public View() {
		super();
		
		userLabel = new Label("Usuario: ");
		passLabel = new Label("Contraseña: ");
		
		userText = new TextField();
		passField = new PasswordField();
		
		accederButton = new Button("Acceder");
		cancelButton = new Button("Cancelar");
		
		
		HBox user = new HBox(userLabel,userText);
		user.setSpacing(40);
		HBox pass = new HBox (passLabel,passField);
		pass.setSpacing(40);
		HBox botones = new HBox(accederButton,cancelButton);
		botones.setAlignment(Pos.CENTER);
		VBox externo = new VBox(user,pass,botones);
		this.setCenter(externo);
		
	}

	public Label getUserLabel() {
		return userLabel;
	}

	public Label getPassLabel() {
		return passLabel;
	}

	public TextField getUserText() {
		return userText;
	}

	public PasswordField getPassField() {
		return passField;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}
}
