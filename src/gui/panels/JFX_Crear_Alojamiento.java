package gui.panels;

import conexion.db.entidades.Ciudades;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class JFX_Crear_Alojamiento extends Pane{
	VBox panel = new VBox();

	public JFX_Crear_Alojamiento() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Alojamiento");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gp = new GridPane();
//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		
		Label nombre = new Label("Nombre del Alojamiento:");
		TextField nombreTextField = new TextField();
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(true);
		Label city = new Label("Ciudad:");
		ComboBox<String> list = new ComboBox<String>();
	    ObservableList<String> data = FXCollections.observableArrayList(new Ciudades().getCiudades());
	    list.setItems(data);

		GridPane.setHalignment(nombre, HPos.RIGHT);
		GridPane.setHalignment(activo, HPos.RIGHT);
		GridPane.setHalignment(city, HPos.RIGHT);	    
	    
		gp.add(nombre, 0, 0);
		gp.add(nombreTextField, 1, 0);
		gp.add(activo, 0, 1);
		gp.add(cb, 1, 1);
		gp.add(city, 0, 2);
		gp.add(list, 1, 2);
		
		Button btn = new Button("Crear");
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, 3);

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
