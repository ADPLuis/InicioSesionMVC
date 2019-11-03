package dad.javafx.iniciosesion.mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {
	View view = new View();
	Model model = new Model();
	
	public Controller() {
		super();
		view.getAccederButton().setOnAction(e -> {
			try {
				onAccederButton(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getCancelButton().setOnAction(e -> onCancelButton(e));
		
		
		model.user.bind(view.getUserText().textProperty());
		model.pass.bind(view.getPassField().textProperty());
	}

	private void onCancelButton(ActionEvent e) {
		Stage stage = (Stage) view.getCancelButton().getScene().getWindow();
	    stage.close();
		
	}

	private void onAccederButton(ActionEvent e) throws IOException {
		
		File users = new File("usuarios.csv");
		FileReader fr = new FileReader(users);
		BufferedReader br = new BufferedReader(fr);
		String lector,user,pass;
		
		user = model.getUser();
		pass = DigestUtils.md5Hex(model.getPass()).toUpperCase();
		
		lector = br.readLine();
		String[] recolector;
		
		Boolean coincide = false;
		
		while (lector != null && coincide == false) {
			recolector = lector.split(",");
			if(user.contentEquals(recolector[0]) && pass.contentEquals(recolector[1])) {
				coincide = true;
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Iniciar Sesion");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("Las credenciales de acceso son válidas.");

				alert.showAndWait();
			} 
			
			lector = br.readLine();
		}
		br.close();
		fr.close();
		
		if (coincide == false) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Iniciar Sesion");
			alert.setHeaderText("Acceso denegado");
			alert.setContentText("Usuario y/o contraseña no validos");

			alert.showAndWait();
		}
	}
	public View getview() {
		return view;
	}
}
