package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class JFX_Recurso_Ver {
	HBox hbox = new HBox();

	public JFX_Recurso_Ver() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("Recursos ver!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
