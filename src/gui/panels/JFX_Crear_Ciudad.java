package gui.panels;

import conexion.db.entidades.Ciudades;
import gui.utils.NumberTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JFX_Crear_Ciudad extends Pane{
	VBox panel = new VBox();

	public JFX_Crear_Ciudad() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Crear Camino");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gp = new GridPane();
//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		
		Label nombre = new Label("Nombre de la Ciudad: (*)");
		TextField nombreTextField = new TextField();
		Label habitantes = new Label("Habitantes:");
//		TextField habitantesTextField = new TextField();
		NumberTextField habitantesTextField = new NumberTextField();
		Label historia = new Label("Historia:");
		TextArea historiasTextField = new TextArea();
		historiasTextField.setPrefWidth(nombreTextField.getWidth()); //acomoda el ancho
		Label latitud = new Label("Latitud: (*)");
		TextField latitudTextField = new TextField();
		Label longitud = new Label("Longitud: (*)");
		TextField longitudTextField = new TextField();
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(true);
		
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

		gp.add(nombre, 0, 0);
		gp.add(nombreTextField, 1, 0);
		gp.add(habitantes, 0, 1);
		gp.add(habitantesTextField, 1, 1);
		gp.add(historia, 0, 2);
		gp.add(historiasTextField, 1, 2);
		gp.add(latitud, 0, 3);
		gp.add(latitudTextField, 1, 3);
		gp.add(longitud, 0, 4);
		gp.add(longitudTextField, 1, 4);
		gp.add(activo, 0, 5);
		gp.add(cb, 1, 5);
		
		Button btn = new Button("Crear");
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, 6);

		Label output = new Label("");
		output.setOpacity(0);
		gp.add(output, 1, 7);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean valido = true;
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					output.setTextFill(Color.RED);
					output.setText("Nombre Vacio"); //poner el output debajo de textfield
					valido = false;
				}
//				if (latitudTextField.getText() == null || latitudTextField.getText().trim().isEmpty()) {
//					output.setTextFill(Color.RED);
//					output.setText("Latitud Vacia");
//					valido = false;
//				}
//				if (longitudTextField.getText() == null || longitudTextField.getText().trim().isEmpty()) {
//					output.setTextFill(Color.RED);
//					output.setText("Longitud Vacia");
//					valido = false;
//				}

				String n = nombreTextField.getText();
//				int hab = Integer.parseInt(habitantesTextField.getText());
//				String his = historiasTextField.getText();
//				double lat = latitudTextField.getText();	
//				double longit = longitudTextField.getText();			
//				Boolean a = cb.selectedProperty().getValue();
				if(valido){
					Ciudades record = new Ciudades();
					record.insertar(n); //simple
//					record.insertar(n,hab,his,lat, longit,a); //completo
					nombreTextField.setText("");
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
