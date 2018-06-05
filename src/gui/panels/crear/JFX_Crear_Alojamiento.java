package gui.panels.crear;

import conexion.db.entidades.Ciudades;
import conexion.db.entidades.Rec_Alojamientos;
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
import javafx.scene.paint.Color;
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
		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0);
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(true);
		Label ciudad = new Label("Ciudad:");
		ComboBox<String> lista_ciudad = new ComboBox<String>();
		lista_ciudad.setItems((ObservableList<String>) new Ciudades().getCiudadesActivas());
		Label outputCiudad = new Label("Ciudad Vacia");
		outputCiudad.setTextFill(Color.RED);
		outputCiudad.setOpacity(0);

		GridPane.setHalignment(nombre, HPos.RIGHT);
		GridPane.setHalignment(activo, HPos.RIGHT);
		GridPane.setHalignment(ciudad, HPos.RIGHT);	    
	    
		int fila = 0;
		gp.add(nombre, 0, fila);
		gp.add(nombreTextField, 1, fila++);
		gp.add(outputNombre, 1, fila++);
		gp.add(activo, 0, fila);
		gp.add(cb, 1, fila++);
		gp.add(ciudad, 0, fila);
		gp.add(lista_ciudad, 1, fila++);
		gp.add(outputCiudad, 1, fila++);
		
		Button btn = new Button("Crear");
		HBox hbBtn = new HBox();
		hbBtn.getStyleClass().add("spacing-medio");
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, fila++);

		Label output = new Label("");
		output.setOpacity(0);
		gp.add(output, 1, fila);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean valido = true;
				String nombre = nombreTextField.getText();
				Boolean activo = cb.selectedProperty().getValue();
				
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setOpacity(1);
					output.setText("Controlar los errores");	
					valido = false;					
				}
				//Agregar la validacion de la ciudad
				
				if(valido){
					int id = new Ciudades().getCiudadesID(lista_ciudad.getValue());
					
					Rec_Alojamientos record = new Rec_Alojamientos();
					record.insertar(nombre,activo, id);
					nombreTextField.setText("");
					cb.setSelected(true);
					output.setText("Alojamiento Creado");
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
