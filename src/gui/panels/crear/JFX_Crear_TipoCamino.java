package gui.panels.crear;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import conexion.db.entidades.Rec_TipoCamino;

public class JFX_Crear_TipoCamino extends Pane{
	VBox panel = new VBox();

	public JFX_Crear_TipoCamino() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Tipo Camino");
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
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();
		cb.setSelected(true);

		GridPane.setHalignment(nombre, HPos.RIGHT);
		GridPane.setHalignment(activo, HPos.RIGHT);   

		int fila = 0;
		gp.add(nombre, 0, fila);
		gp.add(nombreTextField, 1, fila++);
		gp.add(outputNombre, 1, fila++);
		gp.add(activo, 0, fila);
		gp.add(cb, 1, fila++);

		Button btn = new Button("Crear");
		//btn.setDisable(true);
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);

		gp.add(hbBtn, 1, fila++);

		Label output = new Label("");
		output.setOpacity(0);
		gp.add(output, 1, fila);


		/* ACCIONES */		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {				
				String nombre = nombreTextField.getText();
				Boolean activo = cb.selectedProperty().getValue();
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setOpacity(1);
					output.setText("No se pudo crear, controlar los errores");
				}else {
					Rec_TipoCamino record = new Rec_TipoCamino();
					record.insertar(nombre, activo);
					nombreTextField.setText("");
					outputNombre.setOpacity(0);
					output.setText("Tipo Camino Creado");
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
