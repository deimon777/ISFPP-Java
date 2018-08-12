package gui.panels.crear;

import com.deimon.entidades.camino.Trafico;
import com.deimon.isfpp.Main;

import conexion.db.entidades.Rec_Trafico;
import gui.panels.modificar.JFX_ModificarTrafico;
import gui.utiles.TextoUtiles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JFX_Trafico extends Pane{
	VBox panel = new VBox();
	TableView<Trafico> table = new TableView<Trafico>();

	public JFX_Trafico() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Trafico");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		table.setEditable(true);
		table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

		TableColumn<Trafico,Object> nombreCol = new TableColumn<Trafico, Object>("Nombre");
		TableColumn<Trafico,Trafico> accionesCol = new TableColumn<Trafico, Trafico>("Acciones");

		table.setItems(new Rec_Trafico().getListaTrafico());

		nombreCol.setCellValueFactory(new PropertyValueFactory<Trafico,Object>("nombre"));
		accionesCol.setCellValueFactory(new PropertyValueFactory<Trafico,Trafico>("acciones"));        

		accionesCol.setCellFactory(param -> new TableCell<Trafico,Trafico>() {
			private final Button editButton = new Button("");
			private final Button deleteButton = new Button("");
			@Override
			protected void updateItem(Trafico item, boolean empty) {
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
					Trafico select = getTableView().getItems().get(getIndex());
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Eliminar Item");
					alert.setHeaderText(null);
					alert.setContentText("¿Segudo que desea eliminar el item "+select.getNombre()+"?");
					// alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
					alert.showAndWait();
					if (alert.getResult() == ButtonType.OK) {
						//						new Rec_Trafico().deleteItemByID(select.getID());
						System.out.println("Revisar al borrar quien tiene este recurso asignado ");
						recargarTabla();
					}
				});

				editButton.getStyleClass().add("action-button");
				editButton.getStyleClass().add("edit-button");
				editButton.setPrefWidth(accionesCol.getWidth()/2);
				editButton.setOnAction(event -> {
					Trafico select = getTableView().getItems().get(getIndex());			
					new Main<VBox>().cambiarVista(
							new JFX_ModificarTrafico(select.getID(),select.getNombre()).getPanel());
				});
			}
		});

		table.getColumns().addAll(nombreCol, accionesCol);

		VBox vb = new VBox();

		HBox hbCrear = new HBox();		
		hbCrear.getStyleClass().add("padding-medio");
		hbCrear.setSpacing(10);
		hbCrear.setAlignment(Pos.CENTER_LEFT);
		Label nombre = new Label("Nombre:");
		TextField nombreTextField = new TextField();		
		Button btnCrear = new Button("Crear");

		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0);

		hbCrear.getChildren().addAll(nombre,nombreTextField,btnCrear,outputNombre);
		btnCrear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				outputNombre.setOpacity(0);
				String nombre = nombreTextField.getText();
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setText("Nombre Vacio");
				}else {
					Rec_Trafico record = new Rec_Trafico();
					nombre = new TextoUtiles().Capitalizar(nombre);
//					record.insertar(nombre);
					nombreTextField.setText("");
					outputNombre.setText("Recurso Creado");
					recargarTabla();
				}
				outputNombre.setOpacity(1);
			}
		});

		Button btnRecargar = new Button("Recargar Recurso");
		HBox hbRecargar = new HBox();
		//		hbRecargar.setPrefHeight(150); //Tamaño	
		hbRecargar.getStyleClass().add("padding-medio");
		hbRecargar.setAlignment(Pos.TOP_LEFT);
		hbRecargar.getChildren().add(btnRecargar);

		btnRecargar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				recargarTabla();
			}
		});

		vb.getChildren().addAll(hbCrear,hbRecargar);
		panel.getStyleClass().add("padding-medio");
		panel.getChildren().addAll(hbox_titulo, table, vb);
	}

	public VBox getPanel() {
		return this.panel;
	}	
	private void recargarTabla() {
		table.setItems(null);
		table.setItems(new Rec_Trafico().getListaTrafico());		
	}
}
