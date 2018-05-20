package gui.panels;

import com.deimon.isfpp.configuracion.Constantes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class JFX_Ver_Publico{
	VBox panel = new VBox();

	public JFX_Ver_Publico() {
		/*
		 * Mapa de los caminos
		 */
		HBox josm = new HBox();
		josm.setPrefHeight(450); //Tamaño
		josm.setAlignment(Pos.TOP_CENTER);
		josm.getChildren().add(new Label("MAPA!!!"));
		josm.getStyleClass().add("josm");

		/*
		 * Seccion de busqueda de caminos
		 */
		// Izquierda
		HBox buscar_ruta = new HBox();
		buscar_ruta.setPrefHeight(150); //Tamaño		
		//		buscar_ruta.setAlignment(Pos.CENTER);
		buscar_ruta.setId("buscador_ruta");

		VBox busqueda = new VBox();
		busqueda.setPrefWidth(Constantes.ANCHO/2);
		busqueda.getStyleClass().add("padding-medio");
		busqueda.getStyleClass().add("spacing-medio");

		TextField ruta_inicio = new TextField();
		ruta_inicio.setPromptText("Ruta inicial"); //placeholder
		TextField ruta_fin = new TextField();
		ruta_fin.setPromptText("Ruta final");
		Button btn_ruta_buscar = new Button("Buscar Camino");
		btn_ruta_buscar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("La ruta va de'"+ruta_inicio.getText()+"' a '"+ruta_fin.getText()+"'");
			}
		});

		busqueda.getChildren().addAll(ruta_inicio, ruta_fin, btn_ruta_buscar);

		// Derecha
		GridPane funciones_extras = new GridPane();
//		funciones_extras.setGridLinesVisible(true);
		funciones_extras.setPrefWidth(Constantes.ANCHO/2);
		funciones_extras.getStyleClass().add("padding-medio");
		funciones_extras.getStyleClass().add("spacing-medio");
		funciones_extras.setAlignment(Pos.TOP_CENTER);
		funciones_extras.setHgap(10);
		funciones_extras.setVgap(10);

		Button camino_corto = new Button("Camino mas corto");
		Button camino_mejor = new Button("Camino mejor");
		Button camino_rapido = new Button("Camino mas rapido");

		funciones_extras.add(camino_corto, 1, 0);
		funciones_extras.add(camino_mejor, 2, 0);
		funciones_extras.add(camino_rapido, 3, 0);

		buscar_ruta.getChildren().addAll(busqueda, funciones_extras);

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(josm,buscar_ruta);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
