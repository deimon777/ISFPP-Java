package gui.panels.crear;


import org.controlsfx.control.textfield.TextFields;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Ciudades;
import conexion.db.entidades.Rec_EstadoCamino;
import conexion.db.entidades.Rec_TipoCamino;
import conexion.db.entidades.Rec_Trafico;
import gui.utiles.NumberTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JFX_CrearCamino {
	VBox panel = new VBox();

	public JFX_CrearCamino() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Crear Camino");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		ScrollPane scroll = new ScrollPane();
		scroll.setFitToHeight(true);
		scroll.setFitToWidth(true);
		scroll.getStyleClass().add("padding-medio");
		GridPane gp = new GridPane();
		//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);

		Label nombre = new Label("Nombre del Camino:");
		TextField nombreTextField = new TextField();
		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0); //ver como no ocupan espacio 
		Label distancia = new Label("Distancia:");
		NumberTextField distanciaTextField = new NumberTextField();
		Label outputDistancia = new Label("Este campo no puede estar vacio");
		outputDistancia.setTextFill(Color.RED);
		outputDistancia.setOpacity(0);
		Label peso_camino = new Label("Peso Camino:");
		ComboBox<Integer> lista_peso = new ComboBox<Integer>();
		lista_peso.setItems(FXCollections.observableArrayList(1, 2, 3));
		Label outputPeso = new Label("Este campo no puede estar vacio");
		outputPeso.setTextFill(Color.RED);
		outputPeso.setOpacity(0);
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(true);
		Label tipo_camino = new Label("Tipo Camino:");
		ComboBox<String> lista_tipo_camino = new ComboBox<String>();
		lista_tipo_camino.setItems(new Rec_TipoCamino().getTipoCaminoNombre());
		Label outputTipoCamino = new Label("Este campo no puede estar vacio");
		outputTipoCamino.setTextFill(Color.RED);
		outputTipoCamino.setOpacity(0);
		Label estado_camino = new Label("Estado Camino:");
		ComboBox<String> lista_estado_camino = new ComboBox<String>();
		lista_estado_camino.setItems(new Rec_EstadoCamino().getEstadoCaminoNombre());
		Label outpuEstadoCamino = new Label("Este campo no puede estar vacio");
		outpuEstadoCamino.setTextFill(Color.RED);
		outpuEstadoCamino.setOpacity(0);
		Label trafico = new Label("Trafico:");
		ComboBox<String> lista_trafico = new ComboBox<String>();
		lista_trafico.setItems(new Rec_Trafico().getTraficoNombre());
		Label outputTrafico = new Label("Este campo no puede estar vacio");
		outputTrafico.setTextFill(Color.RED);
		outputTrafico.setOpacity(0);
		Label ciudad1 = new Label("Nombre del Ciudad:");
		TextField ciudad1TextField = new TextField();
		Label outputCiudad1 = new Label("Este campo no puede estar vacio");
		outputCiudad1.setTextFill(Color.RED);
		outputCiudad1.setOpacity(0);
		Label ciudad2 = new Label("Nombre del Ciudad:");
		TextField ciudad2TextField = new TextField();
		Label outputCiudad2 = new Label("Este campo no puede estar vacio");
		outputCiudad2.setTextFill(Color.RED);
		outputCiudad2.setOpacity(0);

		TextFields.bindAutoCompletion(nombreTextField,new Caminos().getCaminosNombre());
		TextFields.bindAutoCompletion(ciudad1TextField,new Ciudades().getCiudadesActivas());
		TextFields.bindAutoCompletion(ciudad2TextField,new Ciudades().getCiudadesActivas());
		
		GridPane.setHalignment(nombre, HPos.RIGHT);
		GridPane.setHalignment(distancia, HPos.RIGHT);
		GridPane.setHalignment(peso_camino, HPos.RIGHT);
		GridPane.setHalignment(activo, HPos.RIGHT);
		GridPane.setHalignment(tipo_camino, HPos.RIGHT);
		GridPane.setHalignment(estado_camino, HPos.RIGHT);
		GridPane.setHalignment(lista_peso, HPos.RIGHT);
		GridPane.setHalignment(lista_tipo_camino, HPos.RIGHT);
		GridPane.setHalignment(trafico, HPos.RIGHT);
		GridPane.setHalignment(lista_peso, HPos.LEFT);
		GridPane.setHalignment(lista_tipo_camino, HPos.LEFT);
		GridPane.setHalignment(lista_estado_camino, HPos.LEFT);
		GridPane.setHalignment(lista_trafico, HPos.LEFT); 
		GridPane.setHalignment(ciudad1, HPos.RIGHT);
		GridPane.setHalignment(ciudad2TextField, HPos.LEFT);
		GridPane.setHalignment(ciudad2, HPos.RIGHT);
		GridPane.setHalignment(ciudad2TextField, HPos.LEFT);		
		
		int fila = 0;
		gp.add(nombre, 0, fila);
		gp.add(nombreTextField, 1, fila++);
		gp.add(outputNombre, 1, fila++);
		gp.add(distancia, 0, fila);
		gp.add(distanciaTextField, 1, fila++);
		gp.add(outputDistancia, 1, fila++);
		gp.add(peso_camino, 0, fila);
		gp.add(lista_peso, 1, fila++);
		gp.add(outputPeso, 1, fila++);		
		gp.add(activo, 0, fila);
		gp.add(cb, 1, fila++);
		gp.add(tipo_camino, 0, fila);
		gp.add(lista_tipo_camino, 1, fila++);
		gp.add(outputTipoCamino, 1, fila++);
		gp.add(estado_camino, 0, fila);
		gp.add(lista_estado_camino, 1, fila++);
		gp.add(outpuEstadoCamino, 1, fila++);
		gp.add(trafico, 0, fila);
		gp.add(lista_trafico, 1, fila++);
		gp.add(outputTrafico, 1, fila++);
		gp.add(ciudad1, 0, fila);
		gp.add(ciudad1TextField, 1, fila++);
		gp.add(outputCiudad1, 1, fila++);
		gp.add(ciudad2, 0, fila);
		gp.add(ciudad2TextField, 1, fila++);		
		gp.add(outputCiudad2, 1, fila++);

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
				boolean valido = true;
				String nombre = nombreTextField.getText();
				int distancia = distanciaTextField.getValue();
				int peso = lista_peso.getValue();
				Boolean activo = cb.selectedProperty().getValue();
				String tipo = lista_tipo_camino.getValue();
				String estado = lista_estado_camino.getValue();
				String trafico = lista_trafico.getValue();
				String ciudad1 = ciudad1TextField.getText();
				String ciudad2 = ciudad2TextField.getText();
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setOpacity(1);
					valido = false;	
				}
				//validad Todo

				if(valido){
					int tipo_id = new Rec_TipoCamino().getTipoCaminoID(tipo);
					int estado_id = new Rec_EstadoCamino().getEstadoCaminoID(estado);
					int trafico_id = new Rec_Trafico().getTraficoID(trafico);					
					Ciudades ciudad = new Ciudades();
					int ciudad_id1 = ciudad.getCiudadesID(ciudad1);
					int ciudad_id2 = ciudad.getCiudadesID(ciudad2);
					
					Caminos record = new Caminos();
					record.insertar(nombre,distancia,peso,activo,tipo_id,estado_id,trafico_id,ciudad_id1,ciudad_id2);
					nombreTextField.setText("");
					distanciaTextField.setText("");
					cb.setSelected(true);
					output.setText("Camino Creado");
					TextFields.bindAutoCompletion(nombreTextField,new Caminos().getCaminosNombre()); //controlar aca
					
				}else {
					output.setText("Controlar los errores");					
				}
				output.setOpacity(1);	
			}
		});

//		panel.getStyleClass().add("spacing-medio");
		scroll.setContent(gp);
		panel.getChildren().addAll(hbox_titulo,scroll);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
