package ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(FXMLLoader.load(ClassLoader.getSystemResource("ChoixFilms.fxml")));
		primaryStage.setScene(scene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
