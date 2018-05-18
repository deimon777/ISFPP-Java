package gui.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import gui.MainGUI;
import gui.utils.TextoGUI;
import gui.panels.*;
import javafx.application.Platform;

public class Menu_Utils {	
	public <T> EventHandler<ActionEvent> setAction() {
		EventHandler<ActionEvent> action = changeView();
		return action;
	}

	public <T> EventHandler<ActionEvent> changeView() {
		return new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				MenuItem mItem = (MenuItem) event.getSource();
				String side = mItem.getText();
				// System.out.println(side);

				MainGUI<T> r = new MainGUI<>();
				T vista = null;

				switch (side) {
				//ARCHIVO
				case TextoGUI.MENU_ARCHIVO_SESION:
					System.out.println("Login"); //LOG
					vista = (T)new JFX_Login().getPanel();

					break;
				case TextoGUI.MENU_ARCHIVO_SALIR:
					System.out.println("Salir"); //LOG
					Platform.exit();
					break;
					//PUBLICO
				case TextoGUI.MENU_PUBLICO_VER:
					System.out.println("Publico"); //LOG
					vista = (T)new JFX_Publico().getPanel();			
					break;
					//CIUDADES
				case TextoGUI.MENU_CIUDAD_CREAR:
					System.out.println("Ciudad crear"); //LOG
					vista = (T)new JFX_Ciudad_Crear().getPanel();
					break;
				case TextoGUI.MENU_CIUDAD_VER:
					System.out.println("Ciudad ver"); //LOG
					vista = (T)new JFX_Ciudad_Ver().getPanel();
					break;
					//CAMINOS
				case TextoGUI.MENU_CAMINO_CREAR:
					System.out.println("Camino crear"); //LOG
					vista = (T)new JFX_Camino_Crear().getPanel();
					break;
				case TextoGUI.MENU_CAMINO_VER:
					System.out.println("Camino ver"); //LOG
					vista = (T)new JFX_Camino_Ver().getPanel();
					break;
					//RECURSOS
				case TextoGUI.MENU_RECURSO_CREAR:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_Recurso_Crear().getPanel();
					break;
				case TextoGUI.MENU_RECURSO_VER:
					System.out.println("Recurso ver"); //LOG
					vista = (T)new JFX_Recurso_Ver().getPanel();
					break;
					//SISTEMA

					//AYUDA
				case TextoGUI.MENU_AYUDA_ACERCA:
					System.out.println("Acerca de"); //LOG
					vista = (T)new JFX_Acerca().getPanel();
					break;
				case TextoGUI.MENU_AYUDA_AYUDA:
					System.out.println("Ayuda"); //LOG
					vista = (T)new JFX_Ayuda().getPanel();	
					break;

				default:
					System.out.println("Default | Publico"); //LOG
					vista = (T)new JFX_Publico().getPanel();
					break;
				}

				r.cambiarVista(vista);
			}
		};
	}

}
