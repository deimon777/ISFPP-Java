package gui.panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class JFX_Login {
	VBox panel = new VBox();

	public JFX_Login() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Bienvenido");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);

		Label usuario = new Label("Nombre de Usuario:"); //Pasar a txt
		TextField userTextField = new TextField();
		Label password = new Label("Contraseña:");
		PasswordField pwBox = new PasswordField();

		GridPane.setHalignment(usuario, HPos.RIGHT);
		GridPane.setHalignment(password, HPos.RIGHT);
		
		gp.add(usuario, 0, 0);
		gp.add(userTextField, 1, 0);
		gp.add(password, 0, 1);
		gp.add(pwBox, 1, 1);
		
		Button btn = new Button("Ingresar");
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, 2);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Login, apretado");
			}
		});

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo,gp);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
