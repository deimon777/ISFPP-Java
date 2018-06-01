package gui.panels.ver;

import com.deimon.camino.Camino;
import conexion.db.entidades.Caminos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class JFX_Ver_Camino {
	VBox panel = new VBox();

	public JFX_Ver_Camino() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Ver Caminos");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		TableView<Camino> table = new TableView<Camino>();
		table.setEditable(true);
		table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

		TableColumn<Camino,Object> nombreCol = new TableColumn<Camino, Object>("Nombre");
		TableColumn<Camino,Object> distanciaCol = new TableColumn<Camino, Object>("Distancia");
		TableColumn<Camino,Object> pesoCaminoCol = new TableColumn<Camino, Object>("Peso");
		TableColumn<Camino,Object> tipoCol = new TableColumn<Camino, Object>("Tipo");
		TableColumn<Camino,Object> estadoCol = new TableColumn<Camino, Object>("Estado");
		TableColumn<Camino,Object> traficoCol = new TableColumn<Camino, Object>("Trafico");		
		TableColumn<Camino,Object> activoCol = new TableColumn<Camino, Object>("Activo");
		activoCol.setSortable(false);        
		TableColumn<Camino,Camino> accionesCol = new TableColumn<Camino, Camino>("Acciones");
		accionesCol.setSortable(false);        
		activoCol.setMinWidth(70);
		activoCol.setMaxWidth(100);		
				
		table.setItems(new Caminos().getCaminos());

		nombreCol.setCellValueFactory(new PropertyValueFactory<Camino,Object>("nombre"));
		distanciaCol.setCellValueFactory(new PropertyValueFactory<Camino,Object>("distancia"));
		pesoCaminoCol.setCellValueFactory(new PropertyValueFactory<Camino,Object>("peso"));
		tipoCol.setCellValueFactory(new PropertyValueFactory<Camino,Object>("tipo"));
		estadoCol.setCellValueFactory(new PropertyValueFactory<Camino,Object>("estado"));
		traficoCol.setCellValueFactory(new PropertyValueFactory<Camino,Object>("trafico"));
		activoCol.setCellValueFactory(new PropertyValueFactory<Camino,Object>("activo"));
		accionesCol.setCellValueFactory(new PropertyValueFactory<Camino,Camino>("acciones"));        
        
        accionesCol.setCellFactory(param -> new TableCell<Camino,Camino>() {
            private final Button editButton = new Button("Modificar");
            private final Button deleteButton = new Button("Eliminar");
            @Override
            protected void updateItem(Camino item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    HBox pane = new HBox(deleteButton, editButton);
                    setGraphic(pane);
                    setText(null);
                }

                deleteButton.setOnAction(event -> {
                    Camino select = getTableView().getItems().get(getIndex());
                    Alert alert = new Alert(AlertType.CONFIRMATION);
        			alert.setTitle("Eliminar Camino");
        			alert.setHeaderText(null);
        			alert.setContentText("¿Segudo que desea eliminar el camino "+select.getNombre()+"?");
//        			alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.OK) {
                        Caminos.deleteItemByID("ciudades", select.getID());
        				table.setItems(null);
        				table.setItems(new Caminos().getCaminos());
                    }
                });

                editButton.setOnAction(event -> {
                    Camino select = getTableView().getItems().get(getIndex());
                    System.out.println("ID: "+select.getID());
                });
            }
        });
		
		table.getColumns().addAll(nombreCol, distanciaCol, pesoCaminoCol, tipoCol, estadoCol, traficoCol, activoCol, accionesCol);

		Button btn = new Button("Recargar Caminos");
		HBox hbBtn = new HBox();
//		hbBtn.setPrefHeight(150); //Tamaño	
		hbBtn.getStyleClass().add("padding-medio");
		hbBtn.setAlignment(Pos.TOP_LEFT);
		hbBtn.getChildren().add(btn);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				table.setItems(null);
				table.setItems(new Caminos().getCaminos());
			}
		});

		panel.getStyleClass().add("padding-medio");
		panel.getChildren().addAll(hbox_titulo, table, hbBtn);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
