package ihm;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChoixFilms implements Initializable {

	@FXML
	private VBox root;
	@FXML
	private Label nbFilmsLabel;

	private final String NB_FILMS_STRING = "Veuillez sélectionner %d films";
	private int nbFilmsMax = 3;
	private int nbSelect = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nbFilmsLabel.setText(NB_FILMS_STRING);
		int i = 0;
		try (Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("films.txt"))) {
			HBox hbox = null;
			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split(";");
				if (i % 3 == 0) {
					hbox = new HBox(50);
					hbox.setAlignment(Pos.CENTER);
					root.getChildren().add(hbox);
				}
				CheckBox checkBox = new CheckBox(line[0] + " (" + line[1] + ")");
				checkBox.setOnAction(e -> onSelect(e));
				hbox.getChildren().add(checkBox);
				i++;
			}
		}
	}
	
	private void onSelect(ActionEvent e) {
		CheckBox checkBox = (CheckBox) e.getSource();
		if(checkBox.isSelected()) {
			if(nbSelect == 3) {
				checkBox.setSelected(false);
				return;
			}
			nbSelect++;
			System.out.println(nbSelect);
		}
		else {
			nbSelect--;
			System.out.println(nbSelect);
		}
	}

}
