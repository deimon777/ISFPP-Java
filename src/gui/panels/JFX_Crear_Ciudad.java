package gui.panels;

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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
		
		Label nombre = new Label("Nombre de la Ciudad:");
		TextField nombreTextField = new TextField();
		Label habitantes = new Label("Habitantes:");
//		TextField habitantesTextField = new TextField();
		NumberTextField habitantesTextField = new NumberTextField();
		Label historia = new Label("Historia:");
		TextArea historiasTextField = new TextArea();
		historiasTextField.setPrefWidth(nombreTextField.getWidth()); //acomoda el ancho
		Label latitud = new Label("Latitud:");
		TextField latitudTextField = new TextField();
		Label longitud = new Label("Longitud:");
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

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Ciudad, apretado");
			}
		});

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo,gp);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
