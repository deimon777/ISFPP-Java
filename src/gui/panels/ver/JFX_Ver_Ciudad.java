package gui.panels.ver;

import com.deimon.ciudad.Ciudad;

import conexion.db.entidades.Ciudades;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class JFX_Ver_Ciudad extends Pane{
	VBox panel = new VBox();

	public JFX_Ver_Ciudad() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Ver Ciudades");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		TableView<Ciudad> table = new TableView<Ciudad>();
		table.setPrefHeight(250); //Tamaño	
		table.setEditable(true);
		table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

		TableColumn<Ciudad,Object> nombreCol = new TableColumn<Ciudad, Object>("Nombre");
		TableColumn<Ciudad,Object> habitantesCol = new TableColumn<Ciudad, Object>("Habitantes");
		TableColumn<Ciudad,Object> historiaCol = new TableColumn<Ciudad, Object>("Historia");
		historiaCol.setSortable(false);
		TableColumn<Ciudad,Object> latitudCol = new TableColumn<Ciudad, Object>("Latitud");
		TableColumn<Ciudad,Object> longitudCol = new TableColumn<Ciudad, Object>("Longitud");
		TableColumn<Ciudad,Object> activoCol = new TableColumn<Ciudad, Object>("Activo");
		activoCol.setSortable(false);        
		TableColumn<Ciudad,Object> accionesCol = new TableColumn<Ciudad, Object>("Acciones");
		accionesCol.setSortable(false);        
		activoCol.setMinWidth(70);
		activoCol.setMaxWidth(100);		
				
		table.setItems(new Ciudades().getCiudades());

		nombreCol.setCellValueFactory(new PropertyValueFactory<Ciudad,Object>("nombre"));
		habitantesCol.setCellValueFactory(new PropertyValueFactory<Ciudad,Object>("habitantes"));
		historiaCol.setCellValueFactory(new PropertyValueFactory<Ciudad,Object>("historia"));
		latitudCol.setCellValueFactory(new PropertyValueFactory<Ciudad,Object>("latitud"));
		longitudCol.setCellValueFactory(new PropertyValueFactory<Ciudad,Object>("longitud"));
		activoCol.setCellValueFactory(new PropertyValueFactory<Ciudad,Object>("activo"));
		accionesCol.setCellValueFactory(new PropertyValueFactory<Ciudad,Object>("acciones"));
		
		table.getColumns().addAll(nombreCol, habitantesCol, historiaCol, latitudCol, longitudCol, activoCol,accionesCol);

		Button btn = new Button("Recargar Ciudades");
		HBox hbBtn = new HBox();
		hbBtn.setPrefHeight(150); //Tamaño	
		hbBtn.getStyleClass().add("padding-medio");
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Recargar ciudades");
			}
		});

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo, table, hbBtn);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
