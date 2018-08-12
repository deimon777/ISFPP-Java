package gui.panels.crear;

import conexion.db.entidades.TipoVertice;
import conexion.db.entidades.Vertices;
import gui.utiles.DoubleField;
import gui.utiles.NumberField;
import gui.utiles.TextoUtiles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JFX_CrearCiudad extends Pane{
	VBox panel = new VBox();

	public JFX_CrearCiudad() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Crear Ciudad");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gp = new GridPane();
//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		
		Label nombre = new Label("Nombre de la Ciudad: (*)");
		TextField nombreTextField = new TextField();
		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0);
		Label habitantes = new Label("Habitantes:");
		NumberField habitantesTextField = new NumberField();
		Label historia = new Label("Historia:");
		TextArea historiasTextField = new TextArea();
		historiasTextField.setPrefWidth(nombreTextField.getWidth()); //acomoda el ancho
		Label latitud = new Label("Latitud: (*)");
		DoubleField latitudTextField = new DoubleField();
		Label outputLatitud = new Label("Latitud Vacia");
		outputLatitud.setTextFill(Color.RED);
		outputLatitud.setOpacity(0);
		Label longitud = new Label("Longitud: (*)");
		DoubleField longitudTextField = new DoubleField();
		Label outputLongitud = new Label("Longitud Vacia");
		outputLongitud.setTextFill(Color.RED);
		outputLongitud.setOpacity(0);
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(true);
		ComboBox<String> listaTipoVertice = new ComboBox<String>();
		listaTipoVertice.setItems(new TipoVertice().getTipoVertice());
		
		
		
		GridPane.setHalignment(nombre, HPos.RIGHT);
		GridPane.setHalignment(nombreTextField, HPos.LEFT);
		GridPane.setHalignment(habitantes, HPos.RIGHT);	 
		GridPane.setHalignment(habitantesTextField, HPos.LEFT);
		GridPane.setHalignment(historia, HPos.RIGHT);	   
		GridPane.setHalignment(historiasTextField, HPos.LEFT);
		GridPane.setHalignment(latitud, HPos.RIGHT);  
		GridPane.setHalignment(latitudTextField, HPos.LEFT);
		GridPane.setHalignment(longitud, HPos.RIGHT);  
		GridPane.setHalignment(longitudTextField, HPos.LEFT);
		GridPane.setHalignment(activo, HPos.RIGHT);
		GridPane.setHalignment(cb, HPos.LEFT);

		int fila = 0;
		gp.add(nombre, 0, fila);
		gp.add(nombreTextField, 1, fila++);
		gp.add(outputNombre, 1, fila++);
		gp.add(habitantes, 0, fila);
		gp.add(habitantesTextField, 1, fila++);
		gp.add(historia, 0, fila);
		gp.add(historiasTextField, 1, fila++);
		gp.add(latitud, 0, fila);
		gp.add(latitudTextField, 1, fila++);
		gp.add(outputLatitud, 1, fila++);
		gp.add(longitud, 0, fila);
		gp.add(longitudTextField, 1, fila++);
		gp.add(outputLongitud, 1, fila++);
		gp.add(activo, 0, fila);
		gp.add(cb, 1, fila++);
		
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
				output.setOpacity(0);
				boolean valido = true;
				String nombre = nombreTextField.getText();
				Integer habitantes = null;
				String historia = historiasTextField.getText();
				Double latitud = null;
				Double longitud = null;
				Boolean activo = cb.selectedProperty().getValue();
				String tipo = null;
				

				TextoUtiles tu = new TextoUtiles();

				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					valido = false;
					outputNombre.setOpacity(1);
				}else {
					nombre = tu.Capitalizar(nombre);
					outputNombre.setOpacity(0);
				}
				if (latitudTextField.getText() == null || latitudTextField.getText().trim().isEmpty()) {
					outputLatitud.setOpacity(1);
					valido = false;
				}else {
					latitud = Double.parseDouble(latitudTextField.getText());
					outputLatitud.setOpacity(0);
				}	
				if (longitudTextField.getText() == null || longitudTextField.getText().trim().isEmpty()) {
					outputLongitud.setOpacity(1);
					valido = false;
				}else {
					longitud = Double.parseDouble(longitudTextField.getText());
					outputLongitud.setOpacity(0);
				}
				if (!habitantesTextField.getText().trim().isEmpty()) {
					habitantes = Integer.parseInt(habitantesTextField.getText());
				}
				if (!(listaTipoVertice.getValue() == null || !listaTipoVertice.getValue().trim().isEmpty())) {
					tipo = listaTipoVertice.getValue();
				}else {
					valido = false;						
				}
				
				if(valido){
					Vertices record = new Vertices();
					//ver todos!!
					
					
//					record.insertar(nombre,habitantes,historia,latitud,longitud,activo,tipo);
					nombreTextField.setText("");
					habitantesTextField.setText("");
					historiasTextField.setText("");
					latitudTextField.setText("");
					longitudTextField.setText("");
					cb.setSelected(true);
					output.setText("Ciudad Creada");
				}else {
					output.setText("Controlar los errores");	
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
