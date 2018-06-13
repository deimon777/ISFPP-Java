package gui.panels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.deimon.isfpp.Main;

import conexion.db.tablas.DB_Tablas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class JFX_Sistema_CSV {
	VBox panel = new VBox();

	public JFX_Sistema_CSV() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Cargar Datos CSV");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		GridPane gpCSV = new GridPane();
		gpCSV.setAlignment(Pos.CENTER);
		gpCSV.setHgap(10);		
		gpCSV.setVgap(10);
		
		Button btnCiudadesCSV = new Button("Cargar Ciudades");
		Button btnAlojamientosCSV = new Button("Cargar Alojamientos");
		Button btnSitiosCSV = new Button("Cargar Sitios Turisticos");		
		Button btnCaminosCSV = new Button("Cargar Caminos");
		Button btnTipoCSV = new Button("Cargar Tipo Camino");
		Button btnEstadosCSV = new Button("Cargar Estados Camino");
		Button btnTraficoCSV = new Button("Cargar Trafico");		
		Button btnTodoCSV = new Button("Cargar Todo");
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Abrir Archivo");
		
		gpCSV.add(btnCiudadesCSV, 0, 0);
		gpCSV.add(btnCaminosCSV, 1, 0);
		gpCSV.add(btnAlojamientosCSV, 0, 1);
		gpCSV.add(btnSitiosCSV, 1, 1);
		gpCSV.add(btnTipoCSV, 0, 2);
		gpCSV.add(btnEstadosCSV, 1, 2);
		gpCSV.add(btnTraficoCSV, 2, 2);
		gpCSV.add(btnTodoCSV, 0, 3);

		btnCiudadesCSV.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				File file = fileChooser.showOpenDialog(panel.getScene().getWindow());
				if (file != null) {
					//controlar q sea CSV
					System.out.println(file.getName());
					System.out.println(file.getPath());

					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";

					try {

						br = new BufferedReader(new FileReader(file));
						while ((line = br.readLine()) != null) {
							String[] ciudad = line.split(cvsSplitBy);
							System.out.println(ciudad[0]+", "+ciudad[1]+", "+ciudad[2]+", "+ciudad[3]+", "+ciudad[4]+", "+ciudad[5]);

						}

					} catch (FileNotFoundException e11) {
						e11.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}

			};
		});

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo,gpCSV);
//		panel.getChildren().addAll(hbox_titulo);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
