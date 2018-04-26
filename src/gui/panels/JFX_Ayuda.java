package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class JFX_Ayuda{
	HBox hbox = new HBox();

	public JFX_Ayuda() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("AYUDA!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
