package gui.panels;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class JFX_Ciudad_Crear extends Pane{

	public JFX_Ciudad_Crear(HBox hbox) {
		Button btn = new Button();
		btn.setText("mi boton admin");
		//agregar la accion del boton
		hbox.getChildren().add(btn);
	}
}
