package gui.panels.modificar;

import com.deimon.isfpp.Main;

import conexion.db.entidades.Rec_EstadoCamino;
import gui.panels.crear.JFX_EstadoCamino;
import gui.utiles.TextoUtiles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JFX_ModificarEstadoCamino {
	VBox panel = new VBox();

	public JFX_ModificarEstadoCamino(int nId, String nNombre) {
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Modificar Trafico");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);

		ScrollPane scroll = new ScrollPane();
		scroll.setFitToHeight(true);
		scroll.setFitToWidth(true);
		scroll.getStyleClass().add("padding-medio");
		GridPane gp = new GridPane();
		//		gp.setGridLinesVisible(true);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);

		Label nombre = new Label("Nombre:");
		TextField nombreTextField = new TextField(nNombre);
		Label outputNombre = new Label("Nombre Vacio");
		outputNombre.setTextFill(Color.RED);
		outputNombre.setOpacity(0); //ver como no ocupan espacio 

		GridPane.setHalignment(nombre, HPos.RIGHT);

		int fila = 0;
		gp.add(nombre, 0, fila);
		gp.add(nombreTextField, 1, fila++);
		gp.add(outputNombre, 1, fila++);

		Button btn = new Button("Modificar");
		HBox hbBtn = new HBox();
		hbBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBtn.getChildren().add(btn);
		gp.add(hbBtn, 1, fila++);

		Label output = new Label("");
		output.setOpacity(0);
		gp.add(output, 1, fila);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				boolean valido = true;
				String nombre = nombreTextField.getText();
				if (nombreTextField.getText() == null || nombreTextField.getText().trim().isEmpty()) {
					outputNombre.setOpacity(1);
					valido = false;	
				}

				if(valido){
					output.setText("Camino Modificado!");
					Rec_EstadoCamino record = new Rec_EstadoCamino();
					nombre = new TextoUtiles().Capitalizar(nombre);
					record.actualizar(nId,nombre);
					new Main<VBox>().cambiarVista(new JFX_EstadoCamino().getPanel());
				}else {
					output.setText("Controlar los errores");					
				}
				output.setOpacity(1);	
			}
		});

		//		panel.getStyleClass().add("spacing-medio");
		scroll.setContent(gp);
		panel.getChildren().addAll(hbox_titulo,scroll);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
