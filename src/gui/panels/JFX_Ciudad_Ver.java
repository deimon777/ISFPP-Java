package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class JFX_Ciudad_Ver extends Pane{
	HBox hbox = new HBox();

	public JFX_Ciudad_Ver() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("Ciudad ver!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
