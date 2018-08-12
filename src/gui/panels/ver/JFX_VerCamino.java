package gui.panels.ver;

import com.deimon.entidades.camino.Camino;
import com.deimon.entidades.camino.EstadoCamino;
import com.deimon.entidades.camino.TipoCamino;
import com.deimon.entidades.camino.Trafico;
import com.deimon.entidades.ciudad.Ciudad;
import com.deimon.isfpp.Main;

import conexion.db.entidades.Caminos;
import gui.panels.modificar.JFX_ModificarCamino;
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

public class JFX_VerCamino {
	VBox panel = new VBox();

	public JFX_VerCamino() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Ver Caminos");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		TableView<Camino> table = new TableView<Camino>();
		table.setEditable(true);
		table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

		TableColumn<Camino,String> nombreCol = new TableColumn<Camino, String>("Nombre");
		TableColumn<Camino,Integer> distanciaCol = new TableColumn<Camino, Integer>("Distancia");
		distanciaCol.setMinWidth(60);
		distanciaCol.setMaxWidth(75);
		distanciaCol.setStyle("-fx-alignment: CENTER;");
		TableColumn<Camino,TipoCamino> tipoCol = new TableColumn<Camino, TipoCamino>("Tipo");
		TableColumn<Camino,EstadoCamino> estadoCol = new TableColumn<Camino, EstadoCamino>("Estado");
		TableColumn<Camino,Trafico> traficoCol = new TableColumn<Camino, Trafico>("Trafico");
		TableColumn<Camino,Ciudad> ciudad1Col = new TableColumn<Camino, Ciudad>("Ciudad");
		TableColumn<Camino,Ciudad> ciudad2Col = new TableColumn<Camino, Ciudad>("Ciudad");		
		TableColumn<Camino,Camino> activoCol = new TableColumn<Camino, Camino>("Activo");
		activoCol.setSortable(false);        
		TableColumn<Camino,Camino> accionesCol = new TableColumn<Camino, Camino>("Acciones");
		accionesCol.setSortable(false);
		activoCol.setMinWidth(70);
		activoCol.setMaxWidth(70);	
		activoCol.setStyle("-fx-alignment: CENTER;");	

		table.setItems(new Caminos().getListaCaminos());

		nombreCol.setCellValueFactory(new PropertyValueFactory<Camino,String>("nombre"));
		distanciaCol.setCellValueFactory(new PropertyValueFactory<Camino,Integer>("distancia"));
		tipoCol.setCellValueFactory(new PropertyValueFactory<Camino,TipoCamino>("tipoCaminoNombre"));
		estadoCol.setCellValueFactory(new PropertyValueFactory<Camino,EstadoCamino>("estadoCaminoNombre"));
		traficoCol.setCellValueFactory(new PropertyValueFactory<Camino,Trafico>("traficoNombre"));
		ciudad1Col.setCellValueFactory(new PropertyValueFactory<Camino,Ciudad>("CiudadInicioNombre"));
		ciudad2Col.setCellValueFactory(new PropertyValueFactory<Camino,Ciudad>("CiudadFinNombre"));
		activoCol.setCellValueFactory(new PropertyValueFactory<Camino,Camino>("activo"));
		accionesCol.setCellValueFactory(new PropertyValueFactory<Camino,Camino>("acciones"));  

		accionesCol.setCellFactory(param -> new TableCell<Camino,Camino>() {
			private final Button editButton   = new Button("");
			private final Button deleteButton = new Button("");
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

				deleteButton.getStyleClass().add("action-button");
				deleteButton.getStyleClass().add("delete-button");
				deleteButton.setPrefWidth(accionesCol.getWidth()/2);
				deleteButton.setOnAction(event -> {
					Camino select = getTableView().getItems().get(getIndex());
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Eliminar Camino");
					alert.setHeaderText(null);
					alert.setContentText("¿Segudo que desea eliminar el camino "+select.getNombre()+"?");
					//        			alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
					alert.showAndWait();
					if (alert.getResult() == ButtonType.OK) {
						Caminos.deleteItemByID("caminos", select.getID());
						table.setItems(null);
						table.setItems(new Caminos().getListaCaminos());
					}
				});

				editButton.getStyleClass().add("action-button");
				editButton.getStyleClass().add("edit-button");
				editButton.setPrefWidth(accionesCol.getWidth()/2);
				editButton.setOnAction(event -> {
					Camino select = getTableView().getItems().get(getIndex());

					System.out.println(select.getID());
					System.out.println(select.getNombre());
					System.out.println(select.getDistancia());
					System.out.println(select.getTipoCamino().getNombre());
					System.out.println(select.getEstadoCamino().getNombre());
					System.out.println(select.isActivo());
					System.out.println(select.getCiudadInicio().getNombre());
					System.out.println(select.getCiudadFin().getNombre());

					new Main<VBox>().cambiarVista(
							new JFX_ModificarCamino(
									select.getID(),
									select.getNombre(),
									select.getDistancia(),
									select.getTipoCamino().getNombre(),
									select.getEstadoCamino().getNombre(),
									select.getTrafico().getNombre(),
									select.isActivo(),
									select.getCiudadInicio().getNombre(),
									select.getCiudadFin().getNombre()
									).getPanel());
				});
			}
		});

		table.getColumns().addAll(nombreCol, distanciaCol, tipoCol, estadoCol, traficoCol, ciudad1Col, ciudad2Col,activoCol, accionesCol);

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
				table.setItems(new Caminos().getListaCaminos());
			}
		});

		panel.getStyleClass().add("padding-medio");
		panel.getChildren().addAll(hbox_titulo, table, hbBtn);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
