package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class JFX_Ciudad_Crear extends Pane{
	HBox hbox = new HBox();

	public JFX_Ciudad_Crear() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("CIUDAD!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
