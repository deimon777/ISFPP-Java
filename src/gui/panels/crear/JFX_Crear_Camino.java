package gui.panels.crear;

import org.controlsfx.control.textfield.TextFields;

import conexion.db.entidades.Caminos;
import conexion.db.entidades.Ciudades;
import conexion.db.entidades.Rec_EstadoCamino;
import conexion.db.entidades.Rec_TipoCamino;
import conexion.db.entidades.Rec_Trafico;
import gui.utils.NumberTextField;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JFX_Crear_Camino {
	VBox panel = new VBox();

	public JFX_Crear_Camino() {
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

		Label nombre = new Label("Nombre del Camino:");
		TextField nombreTextField = new TextField();
		Label distancia = new Label("Distancia:");
		NumberTextField distanciaTextField = new NumberTextField();
		Label peso_camino = new Label("Peso Camino:");
		ComboBox<String> lista_peso_camino = new ComboBox<String>();
		ObservableList<String> data_peso_camino = FXCollections.observableArrayList("1", "2", "3");
		lista_peso_camino.setItems(data_peso_camino);
		Label activo = new Label("Activo:");
		CheckBox cb = new CheckBox();	
		cb.setSelected(true);
		Label tipo_camino = new Label("Tipo Camino:");
		ComboBox<String> lista_tipo_camino = new ComboBox<String>();
		lista_tipo_camino.setItems(new Rec_TipoCamino().getTipoCaminoNombre());
		Label estado_camino = new Label("Estado Camino:");
		ComboBox<String> lista_estado_camino = new ComboBox<String>();
		lista_estado_camino.setItems(new Rec_EstadoCamino().getEstadoCaminoNombre());
		Label trafico = new Label("Trafico:");
		ComboBox<String> lista_trafico = new ComboBox<String>();
		lista_trafico.setItems(new Rec_Trafico().getTraficoNombre());
		Label ciudad_inicio = new Label("Ciudad de Inicio:");
		TextField cInicioTextField = new TextField();
		Label ciudad_fin = new Label("Ciudad de Fin:");
		TextField cFinTextField = new TextField();

		//Autocompletar las ciudad
		TextFields.bindAutoCompletion(cInicioTextField,new Ciudades().getCiudadesNombre());
		TextFields.bindAutoCompletion(cFinTextField,new Ciudades().getCiudadesNombre());		

		GridPane.setHalignment(nombre, HPos.RIGHT);
		GridPane.setHalignment(distancia, HPos.RIGHT);
		GridPane.setHalignment(peso_camino, HPos.RIGHT);
		GridPane.setHalignment(activo, HPos.RIGHT);
		GridPane.setHalignment(tipo_camino, HPos.RIGHT);
		GridPane.setHalignment(estado_camino, HPos.RIGHT);
		GridPane.setHalignment(lista_peso_camino, HPos.RIGHT);
		GridPane.setHalignment(lista_tipo_camino, HPos.RIGHT);
		GridPane.setHalignment(trafico, HPos.RIGHT);
		GridPane.setHalignment(ciudad_inicio, HPos.RIGHT);
		GridPane.setHalignment(ciudad_fin, HPos.RIGHT);
		GridPane.setHalignment(lista_peso_camino, HPos.LEFT);
		GridPane.setHalignment(lista_tipo_camino, HPos.LEFT);
		GridPane.setHalignment(lista_estado_camino, HPos.LEFT);
		GridPane.setHalignment(lista_trafico, HPos.LEFT); 

		gp.add(nombre, 0, 0);
		gp.add(nombreTextField, 1, 0);
		gp.add(distancia, 0, 1);
		gp.add(distanciaTextField, 1, 1);
		gp.add(peso_camino, 0, 2);
		gp.add(lista_peso_camino, 1, 2);
		gp.add(activo, 0, 3);
		gp.add(cb, 1, 3);
		gp.add(tipo_camino, 0, 4);
		gp.add(lista_tipo_camino, 1, 4);
		gp.add(estado_camino, 0, 5);
		gp.add(lista_estado_camino, 1, 5);
		gp.add(trafico, 0, 6);
		gp.add(lista_trafico, 1, 6);
		gp.add(ciudad_inicio, 0, 7);
		gp.add(cInicioTextField, 1, 7);
		gp.add(ciudad_fin, 0, 8);
		gp.add(cFinTextField, 1, 8);

		Button btn = new Button("Crear");
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, 9);

		Label output = new Label("");
		output.setOpacity(0);
		gp.add(output, 1, 10);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean valido = true;
				String nombre = nombreTextField.getText();
				Integer distancia = null;
				Integer peso = null;
				String tipo = null; //ver aca
				String estado = null; //ver aca
				String trafico = null; //ver aca
				Boolean activo = cb.selectedProperty().getValue();
				String ciudad_inicio = cInicioTextField.getText();
				String ciudad_fin = cFinTextField.getText();

				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					output.setTextFill(Color.RED);
					output.setText("Nombre Vacio"); //poner el output debajo de textfield
					valido = false;	
				}
				if (cInicioTextField.getText() == null || cInicioTextField.getText().trim().isEmpty()) {
					output.setTextFill(Color.RED);
					output.setText("Ciudad Vacia"); //poner el output debajo de textfield
					valido = false;	
				}
				if (cFinTextField.getText() == null || cFinTextField.getText().trim().isEmpty()) {
					output.setTextFill(Color.RED);
					output.setText("Ciudad Vacia"); //poner el output debajo de textfield
					valido = false;	
				}				

				if(valido){
					Caminos record = new Caminos();
					record.insertar(nombre,distancia,peso,tipo,estado,trafico,activo);
					nombreTextField.setText("");
					distanciaTextField.setText("");
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
