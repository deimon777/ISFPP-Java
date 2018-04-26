package gui;

import com.sun.javafx.tools.packager.Main;

import gui.utils.TextoGUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import gui.panels.*;

public class JFX_Menu {

	MenuBar menu = new MenuBar();

	public JFX_Menu() {
		EventHandler<ActionEvent> action = changeView();

		/*
		 * Creando las secciones del menú
		 */
		Menu archivo = new Menu(TextoGUI.MENU_ARCHIVO); // el _ hace que se pueda abrir con alt+LETRA		
		MenuItem archivoSesion = new MenuItem(TextoGUI.MENU_ARCHIVO_SESION);
		MenuItem archivoSalir = new MenuItem(TextoGUI.MENU_ARCHIVO_SALIR);

		Menu publico = new Menu(TextoGUI.MENU_PUBLICO);
		MenuItem verPublico = new MenuItem(TextoGUI.MENU_PUBLICO_VER);

		Menu ciudades = new Menu(TextoGUI.MENU_CIUDAD);
		MenuItem verCiudades = new MenuItem(TextoGUI.MENU_CIUDAD_VER);
		MenuItem crearCiudad = new MenuItem(TextoGUI.MENU_CIUDAD_CREAR);

		Menu caminos = new Menu(TextoGUI.MENU_CAMINO);
		MenuItem verCaminos = new MenuItem(TextoGUI.MENU_CAMINO_VER);
		MenuItem crearCamino = new MenuItem(TextoGUI.MENU_CAMINO_CREAR);

		Menu recursos= new Menu(TextoGUI.MENU_RECURSO);
		MenuItem verRecursos = new MenuItem(TextoGUI.MENU_RECURSO_VER);
		MenuItem crearRecursos = new MenuItem(TextoGUI.MENU_RECURSO_CREAR);

		Menu sistema = new Menu(TextoGUI.MENU_SISTEMA);
		MenuItem sistemaTema = new MenuItem(TextoGUI.MENU_SISTEMA_TEMA);

		Menu ayuda = new Menu(TextoGUI.MENU_AYUDA);
		MenuItem ayudaAcerca = new MenuItem(TextoGUI.MENU_AYUDA_ACERCA);
		MenuItem ayudaAyuda = new MenuItem(TextoGUI.MENU_AYUDA_AYUDA);

		/*
		 * Creando los Submenus
		 */
		archivo.getItems().addAll(archivoSesion,archivoSalir);
		publico.getItems().addAll(verPublico);
		ciudades.getItems().addAll(verCiudades,crearCiudad);
		caminos.getItems().addAll(verCaminos,crearCamino);
		recursos.getItems().addAll(verRecursos,crearRecursos);
		sistema.getItems().addAll(sistemaTema);
		ayuda.getItems().addAll(ayudaAcerca,ayudaAyuda);

		/*
		 * Agregando los Atajos de teclado
		 */
		archivoSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q,KeyCombination.SHORTCUT_DOWN));
		archivoSesion.setAccelerator(new KeyCodeCombination(KeyCode.N,KeyCombination.SHORTCUT_DOWN));
		verPublico.setAccelerator(new KeyCodeCombination(KeyCode.P,KeyCombination.SHORTCUT_DOWN));

		ayudaAyuda.setAccelerator(new KeyCodeCombination(KeyCode.F1));
		/*
		 * Agregando los menus
		 */
		// menu.getMenus().addAll(archivo,ver,sistema,ayuda);
		menu.getMenus().addAll(archivo,publico,ciudades,caminos,recursos,ayuda);

		/*
		 * Agregando las acciones
		 */
		archivoSesion.setOnAction(action);
		archivoSalir.setOnAction(action);

		verPublico.setOnAction(action);
		verCiudades.setOnAction(action);
		verCaminos.setOnAction(action);
		verRecursos.setOnAction(action);

		//		crearCiudad.setOnAction(action);
		//		crearCamino.setOnAction(action);
		//		crearRecursos.setOnAction(action);

		ayudaAcerca.setOnAction(action);
		ayudaAyuda.setOnAction(action);
	}

	public MenuBar getMenu() {
		return this.menu;

	}

	/*
	 * ACCIONES
	 */
	private <T> EventHandler<ActionEvent> changeView() {
		return new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				MenuItem mItem = (MenuItem) event.getSource();
				String side = mItem.getText();
				// System.out.println(side);

				TestGUI<T> r = new TestGUI<>();
				T vista = null;

				switch (side) {
				//ARCHIVO
				case TextoGUI.MENU_ARCHIVO_SESION:
					System.out.println("Login"); //LOG
					JFX_Login jfx_login = new JFX_Login();
					vista = (T)jfx_login.getPanel();

					break;
				case TextoGUI.MENU_ARCHIVO_SALIR:
					System.out.println("Salir"); //LOG
					Platform.exit();
					break;
					//PUBLICO
				case TextoGUI.MENU_PUBLICO_VER:
					System.out.println("Publico"); //LOG		
					JFX_Publico jfx_publico = new JFX_Publico();
					vista = (T)jfx_publico.getPanel();			
					break;
					//CIUDADES
				case TextoGUI.MENU_CIUDAD_VER:
					System.out.println("Ciudad"); //LOG			
					break;
					//CAMINOS
				case TextoGUI.MENU_CAMINO_VER:
					System.out.println("Camino"); //LOG			
					break;
					//RECURSOS
				case TextoGUI.MENU_RECURSO_VER:
					System.out.println("Recurso"); //LOG			
					break;
					//SISTEMA
					
					//AYUDA
				case TextoGUI.MENU_AYUDA_ACERCA:
					System.out.println("Acerca de"); //LOG				
					break;
				case TextoGUI.MENU_AYUDA_AYUDA:
					System.out.println("Ayuda"); //LOG	
					JFX_Ayuda jfx_ayuda = new JFX_Ayuda();
					vista = (T)jfx_ayuda.getPanel();	
					break;

				default:
					System.out.println("Default | Publico"); //LOG
					JFX_Publico jfx_default = new JFX_Publico();
					vista = (T)jfx_default.getPanel();
					break;
				}

				r.cambiarVista(vista);
			}
		};
	}
}
