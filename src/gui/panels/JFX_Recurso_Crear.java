package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class JFX_Recurso_Crear {
	HBox hbox = new HBox();

	public JFX_Recurso_Crear() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("Recursos crear!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
