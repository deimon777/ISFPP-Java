package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class JFX_Login {	
	HBox hbox = new HBox();

	public JFX_Login() {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("LOGIN!!!!!"));
	}

	public HBox getPanel() {
		return this.hbox;
	}
}
