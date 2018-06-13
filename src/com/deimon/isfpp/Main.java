package com.deimon.isfpp;

import java.net.URL;

import com.deimon.isfpp.configuracion.Constantes;

import gui.menu.JFX_Menu_admin;
import gui.menu.JFX_Menu_public;
import gui.panels.ver.JFX_Ver_Publico;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main<T> extends Application{

	private static BorderPane root = new BorderPane();

	/**
	 * Just a root getter for the controller to use
	 */
	public static BorderPane getRoot() {
		return root;
	}

	public void cambiarVista(T n) {
		Main.getRoot().setCenter((Node) n);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Buscador de Rutas");
		primaryStage.setResizable(false);

		JFX_Menu_admin jfx_m = new JFX_Menu_admin();
//		JFX_Menu_public jfx_m = new JFX_Menu_public();
		MenuBar menu = jfx_m.getMenu();
		
		JFX_Ver_Publico jfx_p= new JFX_Ver_Publico();
		T publico = (T)jfx_p.getPanel();

		root.setTop(menu);
		this.cambiarVista(publico);
		
		Scene scene = new Scene(root,Constantes.ANCHO,Constantes.ALTO);
		
		URL url = this.getClass().getResource("../../../gui/resource/styles.css");
		URL dark = this.getClass().getResource("../../../gui/resource/dark.css");
		//poner un mensaje con el error del estilo
	    String css = url.toExternalForm();
	    String css_dark = dark.toExternalForm();
		scene.getStylesheets().clear(); 
//	    scene.getStylesheets().addAll(css);
	    scene.getStylesheets().addAll(css_dark,css);

		root.getStyleClass().add("background-ppal");
		root.getStyleClass().add("texto-blanco");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);		
	}
}

