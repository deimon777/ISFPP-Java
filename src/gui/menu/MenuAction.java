package gui.menu;

import com.deimon.isfpp.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import gui.panels.*;
import gui.panels.crear.JFX_CrearAlojamiento;
import gui.panels.crear.JFX_CrearCamino;
import gui.panels.crear.JFX_CrearCiudad;
import gui.panels.crear.JFX_EstadoCamino;
import gui.panels.crear.JFX_CrearSitiosTuristicos;
import gui.panels.crear.JFX_TipoCamino;
import gui.panels.crear.JFX_Trafico;
import gui.panels.ver.JFX_VerCamino;
import gui.panels.ver.JFX_VerCiudad;
import gui.panels.ver.JFX_Buscar;
import gui.utiles.TextoGUI;
import javafx.application.Platform;

public class MenuAction {	
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
					
					//BUSCAR
				case TextoGUI.MENU_BUSCAR_RUTAS:
					System.out.println("Buscar"); //LOG
					vista = (T)new JFX_Buscar().getPanel();			
					break;
					
					//VER
				case TextoGUI.MENU_VER_CIUDAD:
					System.out.println("Ciudad ver"); //LOG
					vista = (T)new JFX_VerCiudad().getPanel();
					break;
				case TextoGUI.MENU_VER_CAMINO:
					System.out.println("Camino ver"); //LOG
					vista = (T)new JFX_VerCamino().getPanel();
					break;
					
					//CREAR
				case TextoGUI.MENU_CREAR_CIUDAD:
					System.out.println("Ciudad crear"); //LOG
					vista = (T)new JFX_CrearCiudad().getPanel();
					break;
				case TextoGUI.MENU_CREAR_CAMINO:
					System.out.println("Camino crear"); //LOG
					vista = (T)new JFX_CrearCamino().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_ALOJAMIENTO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_CrearAlojamiento().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_TRAFICO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_Trafico().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_SITIO_TURISTICO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_CrearSitiosTuristicos().getPanel();
					break;
				case TextoGUI.MENU_CREAR_RECURSO_TIPO_CAMINO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_TipoCamino().getPanel(); //cambiar
					break;
				case TextoGUI.MENU_CREAR_RECURSO_ESTADO_CAMINO:
					System.out.println("Recurso crear"); //LOGnew JFX_Recurso_Crear()
					vista = (T)new JFX_EstadoCamino().getPanel(); //cambiar
					break;

					//SISTEMA
				case TextoGUI.MENU_SISTEMA_BASE_DE_DATOS:
					System.out.println("Base de datos"); //LOG
					vista = (T)new JFX_SistemaDB().getPanel();
					break;
				case TextoGUI.MENU_SISTEMA_AUTO_AUTO:
					System.out.println("Automatizar"); //LOG
					vista = (T)new JFX_SistemaAutomatico().getPanel();
					break;
				case TextoGUI.MENU_SISTEMA_AUTO_CSV:
					System.out.println("Automatizar CSV"); //LOG
					vista = (T)new JFX_SistemaCSV().getPanel();
					break;

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
					vista = (T)new JFX_Buscar().getPanel();
					break;
				}

				r.cambiarVista(vista);
			}
		};
	}

}
