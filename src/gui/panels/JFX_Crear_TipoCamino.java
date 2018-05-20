package gui.panels;

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
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import conexion.db.entidades.DB_Rec_TipoCamino;

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

		Label name = new Label("Nombre:");
		TextField nameTextField = new TextField();
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();
		cb.setSelected(true);

		GridPane.setHalignment(name, HPos.RIGHT);
		GridPane.setHalignment(activo, HPos.RIGHT);   

		gp.add(name, 0, 0);
		gp.add(nameTextField, 1, 0);
		gp.add(activo, 0, 1);
		gp.add(cb, 1, 1);

		Button btn = new Button("Crear");
		//btn.setDisable(true);
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);

		gp.add(hbBtn, 1, 2);

		Label output = new Label("Salida");
		output.setOpacity(0);
		gp.add(output, 1, 3);


		/* ACCIONES */		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {				
				String n = nameTextField.getText();
				Boolean a = cb.selectedProperty().getValue();
				if (nameTextField.getText() == null || nameTextField.getText().trim().isEmpty()) {
					output.setTextFill(Color.RED);
					output.setText("Nombre Vacio");
				}else {
					DB_Rec_TipoCamino tc = new DB_Rec_TipoCamino();
					tc.insertar(n, a);
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
