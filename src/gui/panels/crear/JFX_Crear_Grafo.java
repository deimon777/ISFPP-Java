package gui.panels.crear;

import org.controlsfx.control.textfield.TextFields;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Ciudades;
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

public class JFX_Crear_Grafo extends Pane{
	VBox panel = new VBox();

	public JFX_Crear_Grafo() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Unir Ciudades");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gp = new GridPane();
//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		
		Label camino = new Label("Nombre del Camino:");
		TextField caminoTextField = new TextField();
		Label ciudad1 = new Label("Nombre del Ciudad:");
		TextField ciudad1TextField = new TextField();
		Label ciudad2 = new Label("Nombre del Ciudad:");
		TextField ciudad2TextField = new TextField();		
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(true);
		
		TextFields.bindAutoCompletion(caminoTextField,new Caminos().getCaminosNombre());
		TextFields.bindAutoCompletion(ciudad1TextField,new Ciudades().getCiudadesNombre());
		TextFields.bindAutoCompletion(ciudad2TextField,new Ciudades().getCiudadesNombre());
		
		
		GridPane.setHalignment(camino, HPos.RIGHT);
		GridPane.setHalignment(caminoTextField, HPos.LEFT);
		GridPane.setHalignment(ciudad1, HPos.RIGHT);
		GridPane.setHalignment(ciudad2TextField, HPos.LEFT);
		GridPane.setHalignment(ciudad2, HPos.RIGHT);
		GridPane.setHalignment(ciudad2TextField, HPos.LEFT);		
		GridPane.setHalignment(activo, HPos.RIGHT);
		GridPane.setHalignment(cb, HPos.LEFT);

		gp.add(camino, 0, 0);
		gp.add(caminoTextField, 1, 0);
		gp.add(ciudad1, 0, 1);
		gp.add(ciudad1TextField, 1, 1);
		gp.add(ciudad2, 0, 2);
		gp.add(ciudad2TextField, 1, 2);		
		gp.add(activo, 0, 3);
		gp.add(cb, 1, 3);
		
		Button btn = new Button("Crear");
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, 4);

		Label output = new Label("");
		output.setOpacity(0);
		gp.add(output, 1, 5);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean valido = true;
				String camino = caminoTextField.getText();
				String ciudad1 = ciudad1TextField.getText();				
				String ciudad2 = ciudad2TextField.getText();
				Boolean activo = cb.selectedProperty().getValue();

				if (camino == null || camino.trim().isEmpty()) {
					output.setTextFill(Color.RED);
					output.setText("Nombre Vacio"); //poner el output debajo de textfield
					valido = false;					
				}
				
				if(valido){
					//Insertar
					caminoTextField.setText("");
					cb.setSelected(true);
					output.setText("Ciudad Creada");
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
