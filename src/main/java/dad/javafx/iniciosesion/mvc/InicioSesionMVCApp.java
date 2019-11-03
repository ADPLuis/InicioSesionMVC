package dad.javafx.iniciosesion.mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioSesionMVCApp extends Application {
	Controller controller = new Controller();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(controller.getview(),320,200);
		
		primaryStage.setTitle("InicioSesionMVC");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
