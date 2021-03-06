package gui.panels;

import conexion.db.tablas.DB_Tablas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class JFX_SistemaDB {
	VBox panel = new VBox();

	public JFX_SistemaDB() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Sistema");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gpDB = new GridPane();
		gpDB.setAlignment(Pos.CENTER);
		gpDB.setHgap(10);
		gpDB.setVgap(10);

		Button btnCrearDB = new Button("Crear DB");
		Button btnDeleteDB = new Button("Borrar DB");
		Button btnVaciarDB = new Button("Vaciar DB");

		gpDB.add(btnCrearDB, 0, 0);
		gpDB.add(btnDeleteDB, 1, 0);
		gpDB.add(btnVaciarDB, 2, 0);


		btnCrearDB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new DB_Tablas().crearTodasLasTablas();
			};
		});

		btnDeleteDB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new DB_Tablas().borrarTodasLasTablas();
			};
		});

		btnVaciarDB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				new DB_Tablas().vaciarTodasLasTablas();
			};
		});

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo,gpDB);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
