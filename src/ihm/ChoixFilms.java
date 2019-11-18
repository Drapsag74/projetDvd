package ihm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChoixFilms implements Initializable {

	@FXML
	private VBox root;
	@FXML
	private Label nbFilmsLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for (int i = 0; i < 3; i++) {
			HBox hbox = new HBox(50);
			for (int j = 0; j < 3; j++) {
				hbox.getChildren().add(new Button(Integer.toString(3 * i + j)));
			}
			hbox.setAlignment(Pos.CENTER);
			root.getChildren().add(hbox);
		}
	}

}
