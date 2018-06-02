package gui.panels.modificar;

import com.deimon.isfpp.Main;

import conexion.db.entidades.Ciudades;
import gui.utils.NumberTextField;
import gui.panels.ver.JFX_Ver_Ciudad;
import gui.utils.DoubleTextField;

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

public class JFX_Modificar_Ciudad extends Pane{
	VBox panel = new VBox();

	public JFX_Modificar_Ciudad(int nId, String nNombre, int nHabitantes, String nHistoria, double nLatitud, double nLongitud, boolean nActivo) {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Modificar Ciudad");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gp = new GridPane();
//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		
		Label nombre = new Label("Nombre de la Ciudad: (*)");
		TextField nombreTextField = new TextField(nNombre);
		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0);
		Label habitantes = new Label("Habitantes:");
		NumberTextField habitantesTextField = new NumberTextField(nHabitantes);
		Label historia = new Label("Historia:");
		TextArea historiasTextField = new TextArea(nHistoria);
		historiasTextField.setPrefWidth(nombreTextField.getWidth()); //acomoda el ancho
		Label latitud = new Label("Latitud: (*)");
		DoubleTextField latitudTextField = new DoubleTextField(nLatitud);
		Label longitud = new Label("Longitud: (*)");
		DoubleTextField longitudTextField = new DoubleTextField(nLongitud);
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(nActivo);
		
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
		gp.add(longitud, 0, fila);
		gp.add(longitudTextField, 1, fila++);
		gp.add(activo, 0, fila);
		gp.add(cb, 1, fila++);
		
		Button btn = new Button("Modificar");
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
				boolean valido = true;
				String nombre = nombreTextField.getText();
				Integer habitantes = null;
				String historia = null;
				Double latitud = null;
				Double longitud = null;
				Boolean activo = cb.selectedProperty().getValue();

				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setOpacity(1);
					output.setText("Controlar los errores");	
					valido = false;					
				}
				if (!(habitantesTextField.getText() == null || habitantesTextField.getText().trim().isEmpty())) {
					habitantes = Integer.parseInt(habitantesTextField.getText());					
				}
				if (!(historiasTextField.getText() == null || historiasTextField.getText().trim().isEmpty())) {
					historia = historiasTextField.getText();				
				}
				if (!(latitudTextField.getText() == null || latitudTextField.getText().trim().isEmpty())) {
					latitud = Double.parseDouble(latitudTextField.getText());				
				}
				if (!(longitudTextField.getText() == null || longitudTextField.getText().trim().isEmpty())) {
					longitud = Double.parseDouble(longitudTextField.getText());			
				}
				
				if(valido){
					Ciudades ciudad = new Ciudades();
					ciudad.actualizar(nId,nombre,habitantes,historia,latitud,longitud,activo);
					nombreTextField.setText("");
					habitantesTextField.setText("");
					historiasTextField.setText("");
					latitudTextField.setText("");
					longitudTextField.setText("");
					cb.setSelected(true);
					output.setText("Ciudad Modificada");
					new Main<VBox>().cambiarVista(new JFX_Ver_Ciudad().getPanel());
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
