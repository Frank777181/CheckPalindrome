package dad.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application {

	private TextField nombreText;
	private Button saludarButton;
	private Label saludoLabel;

	@Override
	public void start(Stage primaryStage) throws Exception {

		nombreText = new TextField();
		nombreText.setPromptText("Introduce una sentencia");
		nombreText.setMaxWidth(150);

		saludoLabel = new Label("Respuesta correcta");

		saludarButton = new Button("Comprobar");
		saludarButton.setDefaultButton(true);
		saludarButton.setOnAction(event -> onSaludarButtonAction(event));

		VBox root = new VBox();
		root.setSpacing(25);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(nombreText, saludarButton, saludoLabel);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("CheckPalindrome");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onSaludarButtonAction(ActionEvent event) {

		String nombre = nombreText.getText();

		int ini = 0;
		int fin = nombre.length() - 1;
		boolean esPalindromo = true;

		if (nombre.length() == 0) {

			esPalindromo = true;

		}

		else {

			while (ini < fin && esPalindromo) {
				if (nombre.charAt(ini) == nombre.charAt(fin)) {
					ini++;
					fin--;
				} else {
					esPalindromo = false;
				}
			}

			if (esPalindromo) {

				saludoLabel.setText("Es palindromo");
				saludoLabel.setStyle("-fx-text-fill: green;-fx-font: Italic bold 20 consolas;");

			} else {

				saludoLabel.setText("No es palindromo");
				saludoLabel.setStyle("-fx-text-fill: red;-fx-font: Italic bold 20 consolas;");

			}
		}
	}

	public static void main(String[] args) {

		launch(args);

	}
}
