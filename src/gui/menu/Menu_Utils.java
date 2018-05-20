package gui.menu;

import com.deimon.isfpp.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
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

				Main<T> r = new Main<>();
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

					//VER
				case TextoGUI.MENU_PUBLICO:
					System.out.println("Publico"); //LOG
					vista = (T)new JFX_Ver_Publico().getPanel();			
					break;
				case TextoGUI.MENU_VER_CIUDAD:
					System.out.println("Ciudad ver"); //LOG
					vista = (T)new JFX_Ver_Ciudad().getPanel();
					break;
				case TextoGUI.MENU_VER_CAMINO:
					System.out.println("Camino ver"); //LOG
					vista = (T)new JFX_Ver_Camino().getPanel();
					break;
				case TextoGUI.MENU_VER_RECURSO:
					System.out.println("Recurso ver"); //LOG
					vista = (T)new JFX_Ver_Recurso().getPanel();
					break;
					
					//CREAR
				case TextoGUI.MENU_CREAR_CIUDAD:
					System.out.println("Ciudad crear"); //LOG
					vista = (T)new JFX_Crear_Ciudad().getPanel();
					break;
				case TextoGUI.MENU_CREAR_CAMINO:
					System.out.println("Camino crear"); //LOG
					vista = (T)new JFX_Crear_Camino().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_ALOJAMIENTO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_Crear_Alojamiento().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_TRAFICO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_Crear_Trafico().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_SITIO_TURISTICO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_Crear_SitiosTuristicos().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_TIPO_CAMINO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_Crear_TipoCamino().getPanel(); //cambiar
					break;
				case TextoGUI.MENU_CREAR_RECURSO_ESTADO_CAMINO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_Crear_EstadoCamino().getPanel(); //cambiar
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
					vista = (T)new JFX_Ver_Publico().getPanel();
					break;
				}

				r.cambiarVista(vista);
			}
		};
	}

}
