package gui.panels.crear;

import com.deimon.entidades.camino.TipoCamino;
import com.deimon.isfpp.Main;

import conexion.db.entidades.Rec_TipoCamino;
import gui.panels.modificar.JFX_ModificarTipoCamino;
import gui.utiles.NumberField;
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

public class JFX_TipoCamino extends Pane{
	VBox panel = new VBox();
	TableView<TipoCamino> table = new TableView<TipoCamino>();

	public JFX_TipoCamino() {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Tipo Camino");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		table.setEditable(true);
		table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );

		TableColumn<TipoCamino,Object> nombreCol = new TableColumn<TipoCamino, Object>("Nombre");
		TableColumn<TipoCamino,Object> pesoCol = new TableColumn<TipoCamino, Object>("Peso");		
		pesoCol.setStyle( "-fx-alignment: CENTER;");
		TableColumn<TipoCamino,TipoCamino> accionesCol = new TableColumn<TipoCamino, TipoCamino>("Acciones");

		table.setItems(new Rec_TipoCamino().getListaTipoCamino());

		nombreCol.setCellValueFactory(new PropertyValueFactory<TipoCamino,Object>("nombre"));
		pesoCol.setCellValueFactory(new PropertyValueFactory<TipoCamino,Object>("peso"));
		accionesCol.setCellValueFactory(new PropertyValueFactory<TipoCamino,TipoCamino>("acciones"));        

		accionesCol.setCellFactory(param -> new TableCell<TipoCamino,TipoCamino>() {
			private final Button editButton = new Button("");
			private final Button deleteButton = new Button("");
			@Override
			protected void updateItem(TipoCamino item, boolean empty) {
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
					TipoCamino select = getTableView().getItems().get(getIndex());
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Eliminar Item");
					alert.setHeaderText(null);
					alert.setContentText("¿Segudo que desea eliminar el item "+select.getNombre()+"?");
					// alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
					alert.showAndWait();
					if (alert.getResult() == ButtonType.OK) {
						//						new Rec_TipoCamino().deleteItemByID(select.getID());
						System.out.println("Revisar al borrar quien tiene este recurso asignado ");
						recargarTabla();
					}
				});

				editButton.getStyleClass().add("action-button");
				editButton.getStyleClass().add("edit-button");
				editButton.setPrefWidth(accionesCol.getWidth()/2);
				editButton.setOnAction(event -> {
					TipoCamino select = getTableView().getItems().get(getIndex());			
					new Main<VBox>().cambiarVista(new JFX_ModificarTipoCamino(select.getID(),select.getNombre()).getPanel());
				});
			}
		});

		table.getColumns().addAll(nombreCol,pesoCol,accionesCol);

		VBox vb = new VBox();

		HBox hbCrear = new HBox();		
		hbCrear.getStyleClass().add("padding-medio");
		hbCrear.setSpacing(10);
		hbCrear.setAlignment(Pos.CENTER_LEFT);
		Label nombre = new Label("Nombre:");
		TextField nombreTextField = new TextField();
		Label peso = new Label("Peso:");
		NumberField pesoNumberField = new NumberField();
		Button btnCrear = new Button("Crear");

		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0);

		hbCrear.getChildren().addAll(nombre,nombreTextField,peso,pesoNumberField,btnCrear,outputNombre);
		btnCrear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				outputNombre.setOpacity(0);
				String nombre = nombreTextField.getText();
				int peso = pesoNumberField.getValue();
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setText("Nombre Vacio");
				}else {
					Rec_TipoCamino record = new Rec_TipoCamino();
					nombre = new TextoUtiles().Capitalizar(nombre);
					record.insertar(nombre, peso);
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
		table.setItems(new Rec_TipoCamino().getListaTipoCamino());		
	}
}
