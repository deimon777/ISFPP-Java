package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class JFX_Ver_Camino {
	HBox hbox = new HBox();

	public JFX_Ver_Camino() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("Camino ver!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
