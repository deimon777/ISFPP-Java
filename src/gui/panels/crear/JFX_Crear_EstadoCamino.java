package gui.panels.crear;

import conexion.db.entidades.Rec_EstadoCamino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JFX_Crear_EstadoCamino extends Pane{
	VBox panel = new VBox();

	public JFX_Crear_EstadoCamino() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Estado Camino");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gp = new GridPane();		
//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		
		Label nombre = new Label("Nombre:");
		TextField nombreTextField = new TextField();
		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0);
		
		GridPane.setHalignment(nombre, HPos.RIGHT);
		
		int fila = 0;
		gp.add(nombre, 0, fila);
		gp.add(nombreTextField, 1, fila++);
		gp.add(outputNombre, 1, fila++);
		
		Button btn = new Button("Crear");
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, fila++);

		Label output = new Label("");
		output.setOpacity(0);
		gp.add(output, 1, fila);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {	
				String nombre = nombreTextField.getText();
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setOpacity(1);
					output.setText("No se pudo crear, controlar los errores");
				}else {
					Rec_EstadoCamino record = new Rec_EstadoCamino();
					record.insertar(nombre);
					nombreTextField.setText("");
					outputNombre.setOpacity(0);
					output.setText("Estado Camino Creado");
				}
				output.setOpacity(1);
			}
		});

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo,gp);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
