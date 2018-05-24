package gui.panels.ver;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class JFX_Ver_Recurso {
	HBox hbox = new HBox();

	public JFX_Ver_Recurso() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("Recursos ver!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
