package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JFX_Publico{
	VBox contenedor = new VBox();

	public JFX_Publico() {

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().add(new Label("MAPA!!!"));
		hbox.setStyle("-fx-background-color: #F0591E;");
		hbox.setPrefHeight(Double.MAX_VALUE);
		hbox.setPrefHeight(400);

		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.CENTER);
		hbox2.getChildren().add(new Label("Tab1 in 2"));
		hbox2.setStyle("-fx-background-color: #f23421;");
		hbox2.setPrefHeight(200);

//		contenedor.setAlignment(Pos.CENTER);
		contenedor.setStyle("-fx-background-color: #7f1f11;");
		contenedor.getChildren().add(hbox);
		contenedor.getChildren().add(hbox2);
	}

	public VBox getPanel() {
		return this.contenedor;
	}
}
