package gui;

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

		Menu ver = new Menu(TextoGUI.MENU_VER);
		MenuItem verCiudad = new MenuItem(TextoGUI.MENU_VER_CIUDAD);
		MenuItem verCamino = new MenuItem(TextoGUI.MENU_VER_CAMINO);
		MenuItem verRecursos = new MenuItem(TextoGUI.MENU_VER_RECURSO);

		Menu sistema= new Menu(TextoGUI.MENU_SISTEMA);
		MenuItem sistemaTema = new MenuItem(TextoGUI.MENU_SISTEMA_TEMA);

		Menu ayuda = new Menu(TextoGUI.MENU_AYUDA);
		MenuItem ayudaAcerca = new MenuItem(TextoGUI.MENU_AYUDA_ACERCA);
		MenuItem ayudaAyuda = new MenuItem(TextoGUI.MENU_AYUDA_AYUDA);

		/*
		 * Creando los Submenus
		 */
		archivo.getItems().addAll(archivoSesion,archivoSalir);
		ver.getItems().addAll(verCiudad,verCamino,verRecursos);
		sistema.getItems().addAll(sistemaTema);
		ayuda.getItems().addAll(ayudaAcerca,ayudaAyuda);

		/*
		 * Agregando los Atajos de teclado
		 */
		archivoSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q,KeyCombination.SHORTCUT_DOWN));
		archivoSesion.setAccelerator(new KeyCodeCombination(KeyCode.N,KeyCombination.SHORTCUT_DOWN));
		verCiudad.setAccelerator(new KeyCodeCombination(KeyCode.C,KeyCombination.SHORTCUT_DOWN));
		verCamino.setAccelerator(new KeyCodeCombination(KeyCode.V,KeyCombination.SHORTCUT_DOWN));
		verRecursos.setAccelerator(new KeyCodeCombination(KeyCode.R,KeyCombination.SHORTCUT_DOWN));
		
		ayudaAyuda.setAccelerator(new KeyCodeCombination(KeyCode.F1));
		/*
		 * Agregando los menus
		 */
		// menu.getMenus().addAll(archivo,ver,sistema,ayuda);
		menu.getMenus().addAll(archivo,ver,ayuda);

		/*
		 * Agregando las acciones
		 */
		archivoSesion.setOnAction(action);
		archivoSalir.setOnAction(action);

		verCiudad.setOnAction(action);
		verCamino.setOnAction(action);
		verRecursos.setOnAction(action);

		ayudaAcerca.setOnAction(action);
		ayudaAyuda.setOnAction(action);
	}

	public MenuBar getMenu() {
		return this.menu;

	}

	/*
	 * ACCIONES
	 */
	private EventHandler<ActionEvent> changeView() {
		return new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				MenuItem mItem = (MenuItem) event.getSource();
				String side = mItem.getText();
				// System.out.println(side);
				switch (side) {
				case TextoGUI.MENU_ARCHIVO_SESION:
					System.out.println("Sesion");					
					break;
				case TextoGUI.MENU_ARCHIVO_SALIR:
					System.out.println("Salir");
					Platform.exit();
					break;
				case TextoGUI.MENU_VER_CIUDAD:
					System.out.println("Ciuadad");					
					break;
				case TextoGUI.MENU_VER_CAMINO:
					System.out.println("Camino");					
					break;
				case TextoGUI.MENU_VER_RECURSO:
					System.out.println("Recurso");					
					break;
				case TextoGUI.MENU_AYUDA_ACERCA:
					System.out.println("Acerca de");					
					break;
				case TextoGUI.MENU_AYUDA_AYUDA:
					System.out.println("Ayuda");					
					break;

				default:
					System.out.println("Default");
					break;
				}
			}
		};
	}
}
