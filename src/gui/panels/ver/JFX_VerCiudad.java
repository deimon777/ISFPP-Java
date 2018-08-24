package gui.panels.ver;

import com.deimon.entidades.ciudad.Vertice;
import com.deimon.isfpp.Main;

import conexion.db.entidades.Vertices;
import gui.panels.modificar.JFX_ModificarCiudad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class JFX_VerCiudad extends Pane{
	VBox panel = new VBox();

	public JFX_VerCiudad() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Ver Ciudades");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		TableView<Vertice> table = new TableView<Vertice>();
		table.setEditable(true);
		table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

		TableColumn<Vertice,Object> nombreCol = new TableColumn<Vertice, Object>("Nombre");
		TableColumn<Vertice,Object> habitantesCol = new TableColumn<Vertice, Object>("Habitantes");
		TableColumn<Vertice,Object> historiaCol = new TableColumn<Vertice, Object>("Historia");
		historiaCol.setSortable(false);
		TableColumn<Vertice,Object> latitudCol = new TableColumn<Vertice, Object>("Latitud");
		TableColumn<Vertice,Object> longitudCol = new TableColumn<Vertice, Object>("Longitud");
		TableColumn<Vertice,Object> activoCol = new TableColumn<Vertice, Object>("Activo");
		activoCol.setSortable(false);        
		TableColumn<Vertice,Vertice> accionesCol = new TableColumn<Vertice, Vertice>("Acciones");
		accionesCol.setSortable(false);        
		activoCol.setMinWidth(70);
		activoCol.setMaxWidth(100);		
				
		table.setItems(new Vertices().getListaVertices());

		nombreCol.setCellValueFactory(new PropertyValueFactory<Vertice,Object>("nombre"));
		habitantesCol.setCellValueFactory(new PropertyValueFactory<Vertice,Object>("habitantes"));
		historiaCol.setCellValueFactory(new PropertyValueFactory<Vertice,Object>("historia"));
		latitudCol.setCellValueFactory(new PropertyValueFactory<Vertice,Object>("latitud"));
		longitudCol.setCellValueFactory(new PropertyValueFactory<Vertice,Object>("longitud"));
		activoCol.setCellValueFactory(new PropertyValueFactory<Vertice,Object>("activo"));
		accionesCol.setCellValueFactory(new PropertyValueFactory<Vertice,Vertice>("acciones"));        
        
        accionesCol.setCellFactory(param -> new TableCell<Vertice,Vertice>() {
            private final Button editButton = new Button("");
            private final Button deleteButton = new Button("");
            @Override
            protected void updateItem(Vertice item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    HBox pane = new HBox(deleteButton, editButton);
                    setGraphic(pane);
                    setText(null);
                }

				deleteButton.getStyleClass().add("action-button");
				deleteButton.getStyleClass().add("delete-button");
				deleteButton.setPrefWidth(accionesCol.getWidth()/2);
                deleteButton.setOnAction(event -> {
                    Vertice select = getTableView().getItems().get(getIndex());
                    Alert alert = new Alert(AlertType.CONFIRMATION);
        			alert.setTitle("Eliminar Item");
        			alert.setHeaderText(null);
        			alert.setContentText("¿Segudo que desea eliminar la ciudad "+select.getNombre()+"?");
        			// alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.OK) {
                        new Vertices().deleteItemByID(select.getID());
        				table.setItems(null);
        				table.setItems(new Vertices().getListaVertices());
                    }
                });

				editButton.getStyleClass().add("action-button");
				editButton.getStyleClass().add("edit-button");
				editButton.setPrefWidth(accionesCol.getWidth()/2);
                editButton.setOnAction(event -> {
                    Vertice select = getTableView().getItems().get(getIndex());			
                	new Main<VBox>().cambiarVista(
                			new JFX_ModificarCiudad(
                					select.getID(),
                					select.getNombre(),
                					select.getHabitantes(),
                					select.getHistoria(),
                					select.getLatitud(),
                					select.getLongitud(),
                					select.isActivo()
                					).getPanel());
                });
            }
        });
		
		table.getColumns().addAll(nombreCol, habitantesCol, historiaCol, latitudCol, longitudCol, activoCol, accionesCol);

		Button btn = new Button("Recargar Ciudades");
		HBox hbBtn = new HBox();
//		hbBtn.setPrefHeight(150); //Tamaño	
		hbBtn.getStyleClass().add("padding-medio");
		hbBtn.setAlignment(Pos.TOP_LEFT);
		hbBtn.getChildren().add(btn);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				table.setItems(null);
				table.setItems(new Vertices().getListaVertices());
			}
		});

		panel.getStyleClass().add("padding-medio");
		panel.getChildren().addAll(hbox_titulo, table, hbBtn);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
