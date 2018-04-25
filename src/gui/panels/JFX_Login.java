package gui.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class JFX_Login {	
	
	public JFX_Login(HBox hbox) {
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(new Label("Tab1 in"));
	}
}
