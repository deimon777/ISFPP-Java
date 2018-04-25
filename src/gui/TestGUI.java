package gui;

import gui.panels.JFX_Publico;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class TestGUI extends Application{

	private static BorderPane root = new BorderPane();

	  /**
	   * Just a root getter for the controller to use
	   */
	  public static BorderPane getRoot() {
	    return root;
	  }


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Mi primer app");
		primaryStage.setResizable(false);

		JFX_Menu jfx_m = new JFX_Menu();
		MenuBar menu = jfx_m.getMenu();
		
		JFX_Publico jfx_p= new JFX_Publico();
		VBox publico = jfx_p.getPublico();

		root.setTop(menu);
	    root.setCenter(publico);   	    

		Scene scene = new Scene(root,1000,600);
//		String base = "file:///home/deimon/Programacion/Java/ISFPP-Java/src/gui/resource/";
//		String css = base+"modena_dark.css"; //ver por ruta relativa!!!!
//		scene.getStylesheets().clear();
//		scene.getStylesheets().add(css);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);		
	}
}
