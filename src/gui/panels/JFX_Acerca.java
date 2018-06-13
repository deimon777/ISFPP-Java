package gui.panels;

import com.deimon.isfpp.configuracion.Constantes;

import gui.utiles.TextoGUI;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class JFX_Acerca {
	VBox panel = new VBox();

	public JFX_Acerca() {				
		/* TITULO */
		HBox hbox_titulo = new HBox();
		hbox_titulo.setId("contenedor-titulo");
		hbox_titulo.setAlignment(Pos.CENTER);
		Text titulo = new Text("Acerca de");
		titulo.getStyleClass().add("texto-grande");
		hbox_titulo.getChildren().add(titulo);
		
		/* TEXTO */			
		ScrollPane scroll = new ScrollPane();
		scroll.setId("contenedor-texto");
		scroll.getStyleClass().add("padding-medio");
//		scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); 
//		scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);	
		
		Text texto = new Text(TextoGUI.TEXTO_SUPER_LARGO);		
		texto.setWrappingWidth(Constantes.ANCHO-50); //deja el texto dentro de la ventan :)
		texto.getStyleClass().add("texto-justificado");
		texto.getStyleClass().add("texto-mediano");
		
		scroll.setContent(texto);		

		panel.getStyleClass().add("spacing-medio");
		panel.getChildren().addAll(hbox_titulo,scroll);
	}

	public VBox getPanel() {
		return this.panel;
	}
}
